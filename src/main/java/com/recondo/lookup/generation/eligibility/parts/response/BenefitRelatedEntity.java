package com.recondo.lookup.generation.eligibility.parts.response;

import com.recondo.lookup.generation.eligibility.parts.Contact;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityIdCode;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityRelationshipCode;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityTypeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.IdCodeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.LocationQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.ProvCode;
import com.recondo.lookup.generation.eligibility.parts.codes.RefIdQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 2120C/D loops segments of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class BenefitRelatedEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// NM1
	private EntityIdCode entityIdCode;
	private String entityIdCodeDesc;

	private EntityTypeQlfr entityTypeQlfr;
	private String entityTypeQlfrDesc;

	@Size(min = 1, max = 35)
	private String firstName;
	@Size(min = 1, max = 60)
	private String lastName;
	@Size(min = 1, max = 25)
	private String middleName;
	@Size(min = 1, max = 10)
	private String nameSuffix;

	private IdCodeQlfr idCodeQlfr;
	private String idCodeQlfrDesc;
	@Size(min = 2, max = 80)
	private String idCode;

	private EntityRelationshipCode relationshipCode;
	private String relationshipCodeDesc;

	// N3/N4
	@Size(min = 1, max = 55)
	private String addressLine1;
	@Size(min = 1, max = 55)
	private String addressLine2;
	@Size(min = 2, max = 30)
	private String city;
	@Size(min = 2, max = 2)
	private String state;
	@Size(min = 3, max = 15)
	private String zipcode;
	@Size(min = 2, max = 3)
	private String countryCode;
	@Size(min = 1, max = 3)
	private String countrySubdivisionCode;

	private LocationQlfr locQlfr;
	private String locQlfrDesc;
	@Size(min = 1, max = 30)
	private String locId;

	// PER
	@Size(max = 3)
	private List<Contact> contacts = new ArrayList<>();

	// PRV
	private ProvCode provCode;
	private String provCodeDesc;

	private RefIdQlfr refIdQlfr;
	private String refIdQlfrDesc;

	@Size(min = 1, max = 50)
	private String taxonomyId;


	// Must have a default constructor for Jackson to use when parsing JSON
	public BenefitRelatedEntity() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	// NM1
	public EntityIdCode getEntityIdCode() {
		return entityIdCode;
	}
	public void setEntityIdCode(EntityIdCode entityIdCode) {
		this.entityIdCode = entityIdCode;
	}

	public String getEntityIdCodeDesc() {
		return entityIdCodeDesc;
	}
	public void setEntityIdCodeDesc(String entityIdCodeDesc) {
		this.entityIdCodeDesc = entityIdCodeDesc;
	}

	public EntityTypeQlfr getEntityTypeQlfr() {
		return entityTypeQlfr;
	}
	public void setEntityTypeQlfr(EntityTypeQlfr entityTypeQlfr) {
		this.entityTypeQlfr = entityTypeQlfr;
	}

	public String getEntityTypeQlfrDesc() {
		return entityTypeQlfrDesc;
	}
	public void setEntityTypeQlfrDesc(String entityTypeQlfrDesc) {
		this.entityTypeQlfrDesc = entityTypeQlfrDesc;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public IdCodeQlfr getIdCodeQlfr() {
		return idCodeQlfr;
	}
	public void setIdCodeQlfr(IdCodeQlfr idCodeQlfr) {
		this.idCodeQlfr = idCodeQlfr;
	}

	public String getIdCodeQlfrDesc() {
		return idCodeQlfrDesc;
	}
	public void setIdCodeQlfrDesc(String idCodeQlfrDesc) {
		this.idCodeQlfrDesc = idCodeQlfrDesc;
	}

	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public EntityRelationshipCode getRelationshipCode() {
		return relationshipCode;
	}
	public void setRelationshipCode(EntityRelationshipCode relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getRelationshipCodeDesc() {
		return relationshipCodeDesc;
	}
	public void setRelationshipCodeDesc(String relationshipCodeDesc) {
		this.relationshipCodeDesc = relationshipCodeDesc;
	}

	// N3/N4
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountrySubdivisionCode() {
		return countrySubdivisionCode;
	}
	public void setCountrySubdivisionCode(String countrySubdivisionCode) {
		this.countrySubdivisionCode = countrySubdivisionCode;
	}

	public LocationQlfr getLocQlfr() {
		return locQlfr;
	}
	public void setLocQlfr(LocationQlfr locQlfr) {
		this.locQlfr = locQlfr;
	}

	public String getLocQlfrDesc() {
		return locQlfrDesc;
	}
	public void setLocQlfrDesc(String locQlfrDesc) {
		this.locQlfrDesc = locQlfrDesc;
	}

	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}

	// PER
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	// PRV
	public ProvCode getProvCode() {
		return provCode;
	}
	public void setProvCode(ProvCode provCode) {
		this.provCode = provCode;
	}

	public String getProvCodeDesc() {
		return provCodeDesc;
	}
	public void setProvCodeDesc(String provCodeDesc) {
		this.provCodeDesc = provCodeDesc;
	}

	public RefIdQlfr getRefIdQlfr() {
		return refIdQlfr;
	}
	public void setRefIdQlfr(RefIdQlfr refIdQlfr) {
		this.refIdQlfr = refIdQlfr;
	}

	public String getRefIdQlfrDesc() {
		return refIdQlfrDesc;
	}
	public void setRefIdQlfrDesc(String refIdQlfrDesc) {
		this.refIdQlfrDesc = refIdQlfrDesc;
	}

	public String getTaxonomyId() {
		return taxonomyId;
	}
	public void setTaxonomyId(String taxonomyId) {
		this.taxonomyId = taxonomyId;
	}
}
