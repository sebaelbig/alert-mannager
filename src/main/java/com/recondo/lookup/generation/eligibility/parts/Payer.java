package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.EntityIdCode;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityTypeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.IdCodeQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 2100A loop of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class Payer implements Serializable {
	private static final long serialVersionUID = 1L;

	// NM1
	@NotNull
	private EntityIdCode entityIdCode;
	private String entityIdCodeDesc;

	@NotNull
	private EntityTypeQlfr entityTypeQlfr;
	private String entityTypeQlfrDesc;

	@Size(min = 1, max = 35)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 60)
	private String lastName;
	@Size(min = 1, max = 25)
	private String middleName;
	@Size(min = 1, max = 10)
	private String nameSuffix;

	@NotNull
	private IdCodeQlfr idCodeQlfr;
	private String idCodeQlfrDesc;
	@NotNull
	@Size(min = 2, max = 80)
	private String idCode;

	@Valid
	@Size(max = 3)
	private List<Contact> contacts = new ArrayList<>();

	// REF
	@Size(max = 9)
	private List<Ref> refs = new ArrayList<>();


	// Must have a default constructor for Jackson to use when parsing JSON
	public Payer() {
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

	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	// REF
	public List<Ref> getRefs() {
		return refs;
	}
	public void setRefs(List<Ref> refs) {
		this.refs = refs;
	}
	public void addRef(Ref ref) {
		refs.add(ref);
	}
}
