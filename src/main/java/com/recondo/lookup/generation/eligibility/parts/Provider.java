package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.EntityIdCode;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityTypeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.IdCodeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.ProvCode;
import com.recondo.lookup.generation.eligibility.parts.codes.RefIdQlfr;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 2100B loop of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class Provider implements Serializable {
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

	// REF
	@Size(max = 9)
	private List<Ref> refs = new ArrayList<>();

	// PRV
	private ProvCode provCode;
	private String provCodeDesc;

	private RefIdQlfr refIdQlfr;
	private String refIdQlfrDesc;

	@Size(min = 1, max = 50)
	private String taxonomyId;


	// Must have a default constructor for Jackson to use when parsing JSON
	public Provider() {
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
