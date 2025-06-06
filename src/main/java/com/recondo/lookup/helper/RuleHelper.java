package com.recondo.lookup.helper;

import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;

import java.util.List;

/**
 * Helper class for rule-related operations
 */
public class RuleHelper {

    public boolean isValidDroolsRule(String ruleText) {
        if (ruleText == null || ruleText.trim().isEmpty())
            return false;

        // Basic structure checks
        boolean hasRuleDeclaration = ruleText.contains("rule \"");
        boolean hasWhen = ruleText.contains("when");
        boolean hasThen = ruleText.contains("then");
        boolean hasEnd = ruleText.trim().endsWith("end");

        // Optional: check for balanced quotes and parentheses
        boolean balancedQuotes = ruleText.chars().filter(ch -> ch == '"').count() % 2 == 0;
        boolean balancedParens = ruleText.chars().filter(ch -> ch == '(').count() == ruleText.chars()
                .filter(ch -> ch == ')').count();

        return hasRuleDeclaration && hasWhen && hasThen && hasEnd && balancedQuotes && balancedParens;
    }

    /**
     * Validates if a Drools rule is syntactically correct
     * 
     * @param rule The rule content to validate
     * @return true if the rule is valid
     * @throws RuntimeException if the rule is invalid with error details
     */
    public static boolean isDroolsRuleValid(String rule) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();

        // Add necessary imports
        String fullRuleContent = String.join("\n",
                getImportList(),
                rule);

        kfs.write("src/main/resources/rules/Rule.drl", fullRuleContent);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs);
        kieBuilder.buildAll();

        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException(kieBuilder.getResults().getMessages().toString());
        }

        return true;
    }

    private static CharSequence getImportList() {
        return String.join("\n",
                "package rules.eplusAlerts.convertedRuleScopes;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.RuleRequest;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.RuleResponse;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.response.RuleBenefitRelatedEntity;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.response.RuleBenefit;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleRef;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleProvider;",
                "import com.recondotech.revenueCycleAlerts.processors.generation.utils.ResponseUtils;",
                "import com.recondotech.revenueCycleAlerts.models.generation.providerInterface.ProviderInterface;",
                "import com.recondotech.revenueCycleAlerts.models.generation.providerInterface.parts.PayerPlan;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleInsured;",
                "import com.recondotech.revenueCycleAlerts.models.generation.ruleInput.eligibility.parts.RuleEligibilityDate;",
                "import java.text.SimpleDateFormat;",
                "import java.util.HashSet;",
                "import java.util.ArrayList;",
                "import java.util.Map;",
                "import java.util.TreeSet;",
                "import org.apache.commons.lang.StringUtils;",
                "import com.recondotech.revenueCycleAlerts.processors.generation.utils.BenefitUtils;");
    }

    // public static void main(String[] args) {
    // String rule = "rule \"Sample\" when eval(true) then System.out.println(\"Rule
    // fired\"); end";
    //
    // boolean isValid = isDroolsRuleValid(rule);
    // System.out.println("Is rule valid? " + isValid);
    // }

}
