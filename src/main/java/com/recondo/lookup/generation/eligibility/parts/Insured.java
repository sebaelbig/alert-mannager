package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.EmpStatusCode;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityIdCode;
import com.recondo.lookup.generation.eligibility.parts.codes.EntityTypeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.GenderCode;
import com.recondo.lookup.generation.eligibility.parts.codes.GovServAffCode;
import com.recondo.lookup.generation.eligibility.parts.codes.IdCodeQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.IndRelCode;
import com.recondo.lookup.generation.eligibility.parts.codes.InfStatusCode;
import com.recondo.lookup.generation.eligibility.parts.codes.LocationQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.MaintReasonCode;
import com.recondo.lookup.generation.eligibility.parts.codes.MaintTypeCode;
import com.recondo.lookup.generation.eligibility.parts.codes.MilServRankCode;
import com.recondo.lookup.generation.eligibility.parts.codes.ProvCode;
import com.recondo.lookup.generation.eligibility.parts.codes.RefIdQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.StudentStatusCode;
import com.recondo.lookup.generation.eligibility.parts.codes.YesNoIndicator;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents either the Subscriber or Dependent segment of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class Insured implements Serializable {
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

	// DMG
	private GenderCode genderCode;
	private String genderCodeDesc;

	private Date dateOfBirth; 

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

	// INS
	private IndRelCode indRelCode;
	private String indRelCodeDesc;

	private MaintTypeCode maintTypeCode;
	private String maintTypeCodeDesc;

	private MaintReasonCode maintReasonCode;
	private String maintReasonCodeDesc;

	private Short birthSeqNumber;

	// REF
	@Size(max = 9)
	private List<Ref> refs = new ArrayList<>();

	// DTP
	@Size(max = 20)
	private List<EligibilityDate> dates = new ArrayList<>();

	// MPI
	private InfStatusCode infStatusCode;
	private String infStatusCodeDesc;

	private EmpStatusCode empStatusCode;
	private String empStatusCodeDesc;

	private GovServAffCode govServAffCode;
	private String govServAffCodeDesc;

	private MilServRankCode milServRankCode;
	private String milServRankCodeDesc;

	private StudentStatusCode studentStatusCode;
	private String studentStatusCodeDesc;

	private YesNoIndicator handicapIndicator;
	private String handicapIndicatorDesc;

	private Date mpiStartDate;
	private Date mpiEndDate;

	@Size(min = 1, max = 80)
	private String mpiDesc;

	// PRV
	private ProvCode provCode;
	private String provCodeDesc;

	private RefIdQlfr refIdQlfr;
	private String refIdQlfrDesc;

	@Size(min = 1, max = 50)
	private String taxonomyId;

	private LocationQlfr locQlfr;
	private String locQlfrDesc;
	@Size(min = 1, max = 30)
	private String locId;

	// PER
	@Size(max = 3)
	private List<Contact> contacts = new ArrayList<>();

	@Size(max = 8)
	private List<DiagnosisCode> diagnosisCodes = new ArrayList<>();


	// Must have a default constructor for Jackson to use when parsing JSON
	public Insured() {
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

	// DMG
	public GenderCode getGenderCode() {
		return genderCode;
	}
	public void setGenderCode(GenderCode genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderCodeDesc() {
		return genderCodeDesc;
	}
	public void setGenderCodeDesc(String genderCodeDesc) {
		this.genderCodeDesc = genderCodeDesc;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	// INS
	public IndRelCode getIndRelCode() {
		return indRelCode;
	}
	public void setIndRelCode(IndRelCode indRelCode) {
		this.indRelCode = indRelCode;
	}

	public String getIndRelCodeDesc() {
		return indRelCodeDesc;
	}
	public void setIndRelCodeDesc(String indRelCodeDesc) {
		this.indRelCodeDesc = indRelCodeDesc;
	}

	public MaintTypeCode getMaintTypeCode() {
		return maintTypeCode;
	}
	public void setMaintTypeCode(MaintTypeCode maintTypeCode) {
		this.maintTypeCode = maintTypeCode;
	}

	public String getMaintTypeCodeDesc() {
		return maintTypeCodeDesc;
	}
	public void setMaintTypeCodeDesc(String maintTypeCodeDesc) {
		this.maintTypeCodeDesc = maintTypeCodeDesc;
	}

	public MaintReasonCode getMaintReasonCode() {
		return maintReasonCode;
	}
	public void setMaintReasonCode(MaintReasonCode maintReasonCode) {
		this.maintReasonCode = maintReasonCode;
	}

	public String getMaintReasonCodeDesc() {
		return maintReasonCodeDesc;
	}
	public void setMaintReasonCodeDesc(String maintReasonCodeDesc) {
		this.maintReasonCodeDesc = maintReasonCodeDesc;
	}

	public Short getBirthSeqNumber() {
		return birthSeqNumber;
	}
	public void setBirthSeqNumber(Short birthSeqNumber) {
		this.birthSeqNumber = birthSeqNumber;
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

	// DTP
	public List<EligibilityDate> getDates() {
		return dates;
	}
	public void setDates(List<EligibilityDate> dates) {
		this.dates = dates;
	}
	public void addDate(EligibilityDate date) {
		dates.add(date);
	}

	// MPI
	public InfStatusCode getInfStatusCode() {
		return infStatusCode;
	}
	public void setInfStatusCode(InfStatusCode infStatusCode) {
		this.infStatusCode = infStatusCode;
	}

	public String getInfStatusCodeDesc() {
		return infStatusCodeDesc;
	}
	public void setInfStatusCodeDesc(String infStatusCodeDesc) {
		this.infStatusCodeDesc = infStatusCodeDesc;
	}

	public EmpStatusCode getEmpStatusCode() {
		return empStatusCode;
	}
	public void setEmpStatusCode(EmpStatusCode empStatusCode) {
		this.empStatusCode = empStatusCode;
	}

	public String getEmpStatusCodeDesc() {
		return empStatusCodeDesc;
	}
	public void setEmpStatusCodeDesc(String empStatusCodeDesc) {
		this.empStatusCodeDesc = empStatusCodeDesc;
	}

	public GovServAffCode getGovServAffCode() {
		return govServAffCode;
	}
	public void setGovServAffCode(GovServAffCode govServAffCode) {
		this.govServAffCode = govServAffCode;
	}

	public String getGovServAffCodeDesc() {
		return govServAffCodeDesc;
	}
	public void setGovServAffCodeDesc(String govServAffCodeDesc) {
		this.govServAffCodeDesc = govServAffCodeDesc;
	}

	public MilServRankCode getMilServRankCode() {
		return milServRankCode;
	}
	public void setMilServRankCode(MilServRankCode milServRankCode) {
		this.milServRankCode = milServRankCode;
	}

	public String getMilServRankCodeDesc() {
		return milServRankCodeDesc;
	}
	public void setMilServRankCodeDesc(String milServRankCodeDesc) {
		this.milServRankCodeDesc = milServRankCodeDesc;
	}

	public StudentStatusCode getStudentStatusCode() {
		return studentStatusCode;
	}
	public void setStudentStatusCode(StudentStatusCode studentStatusCode) {
		this.studentStatusCode = studentStatusCode;
	}

	public String getStudentStatusCodeDesc() {
		return studentStatusCodeDesc;
	}
	public void setStudentStatusCodeDesc(String studentStatusCodeDesc) {
		this.studentStatusCodeDesc = studentStatusCodeDesc;
	}

	public YesNoIndicator getHandicapIndicator() {
		return handicapIndicator;
	}
	public void setHandicapIndicator(YesNoIndicator handicapIndicator) {
		this.handicapIndicator = handicapIndicator;
	}

	public String getHandicapIndicatorDesc() {
		return handicapIndicatorDesc;
	}
	public void setHandicapIndicatorDesc(String handicapIndicatorDesc) {
		this.handicapIndicatorDesc = handicapIndicatorDesc;
	}

	public Date getMpiStartDate() {
		return mpiStartDate;
	}
	public void setMpiStartDate(Date mpiStartDate) {
		this.mpiStartDate = mpiStartDate;
	}

	public Date getMpiEndDate() {
		return mpiEndDate;
	}
	public void setMpiEndDate(Date mpiEndDate) {
		this.mpiEndDate = mpiEndDate;
	}

	public String getMpiDesc() {
		return mpiDesc;
	}
	public void setMpiDesc(String mpiDesc) {
		this.mpiDesc = mpiDesc;
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

	public List<DiagnosisCode> getDiagnosisCodes() {
		return diagnosisCodes;
	}
	public void setDiagnosisCodes(List<DiagnosisCode> diagnosisCodes) {
		this.diagnosisCodes = diagnosisCodes;
	}
	public void addDiagnosisCode(DiagnosisCode diagnosisCode) {
		diagnosisCodes.add(diagnosisCode);
	}
}
