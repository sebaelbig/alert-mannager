require 'httparty'
require 'addressable/uri'




################################################################################
#################################### READ ME ###################################
# Requirements for use:
# 1. You must have all the rules you wish to add in the same file.
# 2. Any payer/provider restrictions MUST NOT be removed from the rules.
# 3. All other updates to the rules must be completed.
# 4. This script should be run with dry_run set to TRUE until you are confident the rules are parseable
#
########## In order to use this script, you must make certain changes##########
#
# 1. The URL should be updated to point to the correct env.
# 2. The scope_name variable should be updated
# 3. product_value (currently EPLUS)
# 4. realm_id (Currently set to 4 -> TEST)
# 5. imports (this is the list of imports you will use for each rule)
# 6. the file name of your rules file
# 7. if you need to override the payer or provider date use payer_override or provider_override
################################### FINALLY: ##################################
# You MUST make sure you look at the regex for the provider/payer restrictions.
# What worked for one file will not work for them all. It is a very good starting point,
# but something could easily be missed. For instance, it cannot figure out if something
# is turned off for a certain payer/provider combination, but rather, will just output this as a follow-up task.
# If your scope should be disabled by default (unlikely) make the change in the build_scope_map method

@failure_rule_list = []

def get_from_url(url)
  handle_response HTTParty.get(url), url
end

def post_to_url(url, body)
  handle_response HTTParty.post(url, body: body.to_json, headers: {'Content-Type' => 'application/json', 'Authorization' => @auth_token}), url, body
end

def handle_response(response, url, body = nil)
  unless [200, 201, 409].include? response.code # Success || Created || Conflict(already exists)
    throw "ERROR! response code: #{response.code} failure! could not successfully get response! \n URL: #{url} \n Request Body: #{body} \n Message: #{response.message}: #{response.body}"
  end
  response
end

def fail_rule(rule, error_message)
  @failure_rule_list << [error_message, rule]
end

def get_replacement_string(use_comma)
  if use_comma
    ', '
  else
    ''
  end
end

def get_disabled_value(disabled_for_a_payer, disabled_for_a_provider)
  if disabled_for_a_payer.nil? && disabled_for_a_provider.nil?
    false
  elsif disabled_for_a_payer == false || disabled_for_a_provider == false
    true
  else
    false
  end
end

def activation_for_other_entities(disabled_for_payer, disabled_for_provider, rec_ids, provider_ids, rule_id, realm_id)
  url = "#{@activate_alert_url}/#{rule_id}/#{realm_id}/"

  if !(provider_ids.empty? && rec_ids.empty?)

    if disabled_for_payer == disabled_for_provider
      if disabled_for_payer && disabled_for_provider
        action = 'DEACTIVATE'
      else
        action = 'ACTIVATE'
      end
      provider_ids.each do |provider_id|
        rec_ids.each do |rec_id|
          post_payer_provider_combo rec_id, provider_id, url, action
        end
      end
      if action == 'DEACTIVATE'
        post_for_all rec_ids, 'recId', url, 'DEACTIVATE'
        post_for_all provider_ids, 'providerCode', url, 'DEACTIVATE'
      end
    else

      if disabled_for_payer
        post_for_all rec_ids, 'recId', url, 'DEACTIVATE'
      else
        post_for_all rec_ids, 'recId', url, 'ACTIVATE'
      end

      if disabled_for_provider
        post_for_all provider_ids, 'providerCode', url, 'DEACTIVATE'
      else
        post_for_all provider_ids, 'providerCode', url, 'ACTIVATE'
      end
    end
  else
    unless rec_ids.empty?
      if disabled_for_payer
        post_for_all rec_ids, 'recId', url, 'DEACTIVATE'
      else
        post_for_all rec_ids, 'recId', url, 'ACTIVATE'
      end
    end

    unless provider_ids.empty?
      if disabled_for_provider
        post_for_all provider_ids, 'providerCode', url, 'DEACTIVATE'
      else
        post_for_all provider_ids, 'providerCode', url, 'ACTIVATE'
      end
    end
  end
end

def post_for_all(ids, descriptor, url, action)
  ids.each do |id|
    body = {action: action}

    if descriptor == 'providerCode'
      body[:providerCode] = id
    else
      body[:payer] = {recId: id}
    end
    post_to_url url, body
  end
end

def post_payer_provider_combo(rec_id, provider_id, url, action)
  body = {action: action, providerCode: provider_id, payer: {recId: rec_id}}
  post_to_url url, body
end

def grab_and_replace(text, regex, replacement)
  return_value = nil
  text.gsub!(regex) do
    return_value = Regexp.last_match(1).to_s
    replacement
  end
  return_value
end

def get_product_id(product)
  products = get_from_url @products_url

  products['productList'].each do |hash|
    return hash['id'] if hash['name'] == product
  end
end

def get_realm_id(realm)
  realms = get_from_url @realms_url

  realms['realmList'].each do |hash|
    return hash['realmId'] if hash['name'] == realm.upcase
  end
end

def build_scope_map(scope_name, product_id, product_name)
  uri = Addressable::URI.parse @scope_url
  uri.query_values = {scopeName: scope_name, product: product_name}

  scopes = get_from_url(uri.normalize.to_s)['scopes']
  scope_id = nil

  scopes.each do |scope|
    if scope['name'] == scope_name
      scope_id = scope['id']
      break
    end
  end

  scope = {}
  scope['name'] = scope_name
  scope['disabledByDefault'] = false
  scope['productId'] = product_id
  scope['id'] = scope_id unless scope_id.nil?
  scope
end

def build_alert_text_map(alert_text)
  uri = Addressable::URI.parse @alert_text_url

  messages = get_from_url(uri.normalize.to_s)['messages']
  message_id = nil

  messages.each do |message|
    if message['text'] == alert_text
      message_id = message['id']
      break
    end
  end

  alert_text_map = {}
  alert_text_map['text'] = alert_text
  alert_text_map['id'] = message_id unless message_id.nil?
  alert_text_map
end

# Each body should be unique, so no need to check url for a body
def build_rule_body_map(body_text)
  rule_body_map = {}
  rule_body_map['body'] = body_text
  rule_body_map['realmId'] = get_realm_id 'PROD' # TEST, STAGE, PROD
  rule_body_map
end

# base_url = 'http://ploualrtms001.recondo.vci:8080/revenueCycleAlertsService/rcalerts/v1/'
# base_url = 'http://sloualrtms001.recondo.vci:8080/revenueCycleAlertsService/rcalerts/v1/'
base_url = 'http://dloualrtms001.recondo.vci:8080/revenueCycleAlertsService/rcalerts/v1/'

@rules_url = "#{base_url}rules"
@activate_alert_url = "#{base_url}activation/rules"
@products_url = "#{base_url}products"
@realms_url = "#{base_url}realms"
@scope_url = "#{base_url}scopes"
@alert_text_url = "#{base_url}messages"
# Log into like, authinit, and for a brief moment, a token like this will appear in the url. Look at your history and grab it.
@auth_token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTZWJhc3RpYW4uR2FyY2lhQHdheXN0YXIuY29tIiwiYXVkIjoiaHR0cDovLzEwLjIwMi4yMDguODkiLCJyb2xlcyI6WyJjdXN0X25nYXJ0YV9hdXRoX2luaXRpYXRlX2dlbmVyYWwiLCJjdXN0X3JlY29uZG9fYXJ0X2dlbmVyYWwiLCJhdHBfcmVjaGVja19nZW5lcmFsIiwiY3VzdF9lbWlkc19hdXRoX2luaXRpYXRlX2FkbWluIiwiY3VzdF9zdGFtZmVfYXV0aF9pbml0aWF0ZV9nZW5lcmFsIiwiY3VzdF9lbWVyc29uX2F1dGhfaW5pdGlhdGVfZ2VuZXJhbCIsImF0cF9yZWNoZWNrX2FkbWluIiwiY3VzdF9jaHNsaWFfYXV0aF9pbml0aWF0ZV9nZW5lcmFsIl0sImV4cCI6MTc0ODYzMTQ4NSwiaWF0IjoxNzQ4NjI5Njg1LCJjdXN0YWJiciI6IlVOS05PV04ifQ.Ty_7hgWLs8ob7AjITzYE6QOUGmUB_xHLpXxdTgvllikBmc_17-c0owozuI-QAz5ReG3IVq7aXySeOsbtZL6WjA'
realm_id = get_realm_id 'TEST' # STAGE, TEST, PROD
scope_name = 'SHIELDS_RADIOLOGY_ALERTS' #UIHC_PCV_ALERTS_8 RTE_OON_BAYLOR_ALERTS_19 Customer 1392
product_name = 'ELIGIBILITY_PLUS'
product_id = get_product_id product_name
dry_run = false # means we won't actually load anything
payer_override = [] # rec_ids that you want to override and use for dev
provider_override = [] # provider_ids that you want to override and use for dev

imports = 'package rules.eplusAlerts.convertedRuleScopes;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.RuleRequest;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.RuleResponse;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.response.RuleBenefit;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.response.RuleBenefitRelatedEntity;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleRef;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleProvider;
import com.recondotech.revenueCycleAlerts.processors.generation.utils.ResponseUtils;
import com.recondotech.revenueCycleAlerts.models.generation.providerInterface.ProviderInterface;
import com.recondotech.revenueCycleAlerts.models.generation.providerInterface.parts.PayerPlan;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleInsured;
import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleEligibilityDate;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang.StringUtils;
import com.recondotech.revenueCycleAlerts.processors.generation.utils.BenefitUtils;'

all_rules = File.open('C:\workspace\services\revenueCycleAlertsService-trunk\src\main\resources\rules\eplusAlerts\convertedRuleScopes\addNewRule.drl', 'rb').read

rule_array = all_rules.scan(/.+?(?=end[^"'A-Za-z])\bend\s*\n/m)

rule_array.each do |rule|
  rule_name = grab_and_replace(rule, /rule "([^"]*)"/, 'rule "<RULE_NAME>"')
  rule_alert = grab_and_replace(rule, /ResponseUtils\.addEplusAlertToResponse\(\$response,\s*"([^"]*)"/, 'ResponseUtils.addEplusAlertToResponse($response, "<RULE_ALERT>"')

  fail_rule rule, 'ERROR: Could not parse rule_name for rule' if rule_name.nil?
  fail_rule rule, 'ERROR: Could not parse rule_alert for rule' if rule_alert.nil?

  rec_ids = []
  provider_ids = []
  disabled_for_specific_payer = nil
  disabled_for_specific_provider = nil

  rule.gsub!(/(,)?\s*payerId( not)? in \(([^()]*)\)\s*(,)?/) do
    both_commas = Regexp.last_match(1) == ',' && Regexp.last_match(4) == ','
    disabled_for_specific_payer = !Regexp.last_match(2).nil?
    rec_ids += Regexp.last_match(3).scan(/"(REC....)"/).flatten # do this last or we will overwrite important values
    get_replacement_string both_commas # This will replace the whole big payerId thing
  end

  if rec_ids.empty?
    rule.gsub!(/(,)?\s*payerId\s*([=!])=\s*"([^"]*)"\s*(,)?/) do
      both_commas = Regexp.last_match(1) == ',' && Regexp.last_match(4) == ','
      disabled_for_specific_payer = Regexp.last_match(2).to_s == '!'
      rec_ids << Regexp.last_match(3).to_s
      get_replacement_string both_commas # This will replace the whole big payerId thing
    end
  end

  if rec_ids.empty?
    rule.gsub!(/String\(\s*this ([=!])= "([^"]*)"\s*\)/) do
      disabled_for_specific_payer = Regexp.last_match(1).to_s == '!'
      rec_ids << Regexp.last_match(2).to_s
      '' # This will replace the whole big payerId thing
    end
  end

  rule.gsub!(/(,)?\s*providerId( not)? in \(([^()]*)\)\s*(,)?/) do
    both_commas = Regexp.last_match(1) == ',' && Regexp.last_match(4) == ','
    disabled_for_specific_provider = !Regexp.last_match(2).nil?
    provider_ids += Regexp.last_match(3).scan(/"([^"]*)"/).flatten # do this last or we will overwrite important values
    get_replacement_string both_commas # This will replace the whole big providerId thing
  end

  if provider_ids.empty?
    rule.gsub!(/(,)?\s*providerId\s*([=!])=\s*"([^"]*)"\s*(,)?/) do
      both_commas = Regexp.last_match(1) == ',' && Regexp.last_match(4) == ','
      disabled_for_specific_provider = Regexp.last_match(2).to_s == '!'
      provider_ids << Regexp.last_match(3).to_s
      get_replacement_string both_commas # This will replace the whole big providerId thing
    end
  end

  body = {}

  body['name'] = rule_name
  body['scope'] = build_scope_map scope_name, product_id, product_name
  body['disabledByDefault'] = get_disabled_value disabled_for_specific_payer, disabled_for_specific_provider
  body['message'] = build_alert_text_map rule_alert
  body['ruleBody'] = build_rule_body_map imports + rule

  # puts body
  # puts rule

  next if dry_run
  response = post_to_url @rules_url, body
  rule_id = JSON.parse(response.body)['id']

  rec_ids = payer_override unless payer_override.empty?
  provider_ids = provider_override unless provider_override.empty?

  activation_for_other_entities disabled_for_specific_payer, disabled_for_specific_provider, rec_ids, provider_ids, rule_id, realm_id
end

puts "#{rule_array.size - @failure_rule_list.size}/#{rule_array.size} loaded"
puts @failure_rule_list
puts 'Rules and association loading complete!'
