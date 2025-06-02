package com.recondo.lookup.generation.eligibility.parts;

import com.recondo.lookup.generation.eligibility.parts.codes.AckRequested;
import com.recondo.lookup.generation.eligibility.parts.codes.AuthInfoQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.HirclStructCode;
import com.recondo.lookup.generation.eligibility.parts.codes.InterchangeCtrlVerNum;
import com.recondo.lookup.generation.eligibility.parts.codes.InterchangeIdQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.InterchangeUsageIndicator;
import com.recondo.lookup.generation.eligibility.parts.codes.ReleaseIndustryIDCode;
import com.recondo.lookup.generation.eligibility.parts.codes.RespAgencyCode;
import com.recondo.lookup.generation.eligibility.parts.codes.SecurityInfoQlfr;
import com.recondo.lookup.generation.eligibility.parts.codes.TranSetPurpCode;
import com.recondo.lookup.generation.eligibility.parts.codes.TransSetIdCode;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Represents the ISA/GS/ST/BHT/SE/GE/IEA segments of a X12 270/271 EDI
 * 
 * @author Robert.Larivee
 */
public class TransactionHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	// ISA/IEA
	private AuthInfoQlfr authInfoQlfr;
	private String authInfoQlfrDesc;
	@Size(min = 10, max = 10)
	private String authInfo;

	private SecurityInfoQlfr securityInfoQlfr;
	private String securityInfoQlfrDesc;
	@Size(min = 10, max = 10)
	private String securityInfo;

	private InterchangeIdQlfr senderIdQlfr;
	private String senderIdQlfrDesc;
	@Size(min = 15, max = 15)
	private String senderId;

	private InterchangeIdQlfr recvIdQlfr;
	private String recvIdQlfrDesc;
	@Size(min = 15, max = 15)
	private String recvId;

	private Date interchangeTimeStamp;

	private Character repititionSeparator;

	private InterchangeCtrlVerNum interchangeCtrlVerNum;
	private String interchangeCtrlVerNumDesc;
	@Size(min = 9, max = 9)
	private String interchangeCtrlNum;

	private AckRequested ackRequested;
	private String ackRequestedDesc;

	private InterchangeUsageIndicator interchangeUsageIndicator;
	private String interchangeUsageIndicatorDesc;

	private Character componentElemSeparator;

	private Character segmentTerminator;

	private Character dataElemSeparator;

	private Short funcGroupIncluded;

	// GS/GE
	@Size(min = 2, max = 2)
	private String funcIdCode;

	@Size(min = 2, max = 15)
	private String senderCode;

	@Size(min = 2, max = 15)
	private String recvCode;

	@Size(min = 1, max = 9)
	private String groupCtrlNum;

	private RespAgencyCode respAgencyCode;
	private String respAgencyCodeDesc;

	private ReleaseIndustryIDCode releaseIndustryIDCode;
	private String releaseIndustryIDCodeDesc;

	private Integer tsIncluded;

	// ST/SE
	private TransSetIdCode transSetIdCode;
	private String transSetIdCodeDesc;

	@Size(min = 4, max = 9)
	private String transSetCtrlNum;

	// BHT
	private HirclStructCode hirclStructCode;
	private String hirclStructCodeDesc;

	private TranSetPurpCode tranSetPurpCode;
	private String tranSetPurpCodeDesc;

	@Size(min = 1, max = 50)
	private String transRefId;


	// Must have a default constructor for Jackson to use when parsing JSON
	public TransactionHeader() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	// ISA/IEA
	public AuthInfoQlfr getAuthInfoQlfr() {
		return authInfoQlfr;
	}
	public void setAuthInfoQlfr(AuthInfoQlfr authInfoQlfr) {
		this.authInfoQlfr = authInfoQlfr;
	}

	public String getAuthInfoQlfrDesc() {
		return authInfoQlfrDesc;
	}
	public void setAuthInfoQlfrDesc(String authInfoQlfrDesc) {
		this.authInfoQlfrDesc = authInfoQlfrDesc;
	}

	public String getAuthInfo() {
		return authInfo;
	}
	public void setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
	}

	public SecurityInfoQlfr getSecurityInfoQlfr() {
		return securityInfoQlfr;
	}
	public void setSecurityInfoQlfr(SecurityInfoQlfr securityInfoQlfr) {
		this.securityInfoQlfr = securityInfoQlfr;
	}

	public String getSecurityInfoQlfrDesc() {
		return securityInfoQlfrDesc;
	}
	public void setSecurityInfoQlfrDesc(String securityInfoQlfrDesc) {
		this.securityInfoQlfrDesc = securityInfoQlfrDesc;
	}

	public String getSecurityInfo() {
		return securityInfo;
	}
	public void setSecurityInfo(String securityInfo) {
		this.securityInfo = securityInfo;
	}

	public InterchangeIdQlfr getSenderIdQlfr() {
		return senderIdQlfr;
	}
	public void setSenderIdQlfr(InterchangeIdQlfr senderIdQlfr) {
		this.senderIdQlfr = senderIdQlfr;
	}

	public String getSenderIdQlfrDesc() {
		return senderIdQlfrDesc;
	}
	public void setSenderIdQlfrDesc(String senderIdQlfrDesc) {
		this.senderIdQlfrDesc = senderIdQlfrDesc;
	}

	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public InterchangeIdQlfr getRecvIdQlfr() {
		return recvIdQlfr;
	}
	public void setRecvIdQlfr(InterchangeIdQlfr recvIdQlfr) {
		this.recvIdQlfr = recvIdQlfr;
	}

	public String getRecvIdQlfrDesc() {
		return recvIdQlfrDesc;
	}
	public void setRecvIdQlfrDesc(String recvIdQlfrDesc) {
		this.recvIdQlfrDesc = recvIdQlfrDesc;
	}

	public String getRecvId() {
		return recvId;
	}
	public void setRecvId(String recvId) {
		this.recvId = recvId;
	}

	public Date getInterchangeTimeStamp() {
		return interchangeTimeStamp;
	}
	public void setInterchangeTimeStamp(Date interchangeTimeStamp) {
		this.interchangeTimeStamp = interchangeTimeStamp;
	}

	public Character getRepititionSeparator() {
		return repititionSeparator;
	}
	public void setRepititionSeparator(Character repititionSeparator) {
		this.repititionSeparator = repititionSeparator;
	}

	public InterchangeCtrlVerNum getInterchangeCtrlVerNum() {
		return interchangeCtrlVerNum;
	}
	public void setInterchangeCtrlVerNum(InterchangeCtrlVerNum interchangeCtrlVerNum) {
		this.interchangeCtrlVerNum = interchangeCtrlVerNum;
	}

	public String getInterchangeCtrlVerNumDesc() {
		return interchangeCtrlVerNumDesc;
	}
	public void setInterchangeCtrlVerNumDesc(String interchangeCtrlVerNumDesc) {
		this.interchangeCtrlVerNumDesc = interchangeCtrlVerNumDesc;
	}

	public String getInterchangeCtrlNum() {
		return interchangeCtrlNum;
	}
	public void setInterchangeCtrlNum(String interchangeCtrlNum) {
		this.interchangeCtrlNum = interchangeCtrlNum;
	}

	public AckRequested getAckRequested() {
		return ackRequested;
	}
	public void setAckRequested(AckRequested ackRequested) {
		this.ackRequested = ackRequested;
	}

	public String getAckRequestedDesc() {
		return ackRequestedDesc;
	}
	public void setAckRequestedDesc(String ackRequestedDesc) {
		this.ackRequestedDesc = ackRequestedDesc;
	}

	public InterchangeUsageIndicator getInterchangeUsageIndicator() {
		return interchangeUsageIndicator;
	}
	public void setInterchangeUsageIndicator(InterchangeUsageIndicator interchangeUsageIndicator) {
		this.interchangeUsageIndicator = interchangeUsageIndicator;
	}

	public String getInterchangeUsageIndicatorDesc() {
		return interchangeUsageIndicatorDesc;
	}
	public void setInterchangeUsageIndicatorDesc(String interchangeUsageIndicatorDesc) {
		this.interchangeUsageIndicatorDesc = interchangeUsageIndicatorDesc;
	}

	public Character getComponentElemSeparator() {
		return componentElemSeparator;
	}
	public void setComponentElemSeparator(Character componentElemSeparator) {
		this.componentElemSeparator = componentElemSeparator;
	}

	public Character getSegmentTerminator() {
		return segmentTerminator;
	}
	public void setSegmentTerminator(Character segmentTerminator) {
		this.segmentTerminator = segmentTerminator;
	}

	public Character getDataElemSeparator() {
		return dataElemSeparator;
	}
	public void setDataElemSeparator(Character dataElemSeparator) {
		this.dataElemSeparator = dataElemSeparator;
	}

	public Short getFuncGroupIncluded() {
		return funcGroupIncluded;
	}
	public void setFuncGroupIncluded(Short funcGroupIncluded) {
		this.funcGroupIncluded = funcGroupIncluded;
	}


	// GS/GE
	public String getFuncIdCode() {
		return funcIdCode;
	}
	public void setFuncIdCode(String funcIdCode) {
		this.funcIdCode = funcIdCode;
	}

	public String getSenderCode() {
		return senderCode;
	}
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}

	public String getRecvCode() {
		return recvCode;
	}
	public void setRecvCode(String recvCode) {
		this.recvCode = recvCode;
	}

	public String getGroupCtrlNum() {
		return groupCtrlNum;
	}
	public void setGroupCtrlNum(String groupCtrlNum) {
		this.groupCtrlNum = groupCtrlNum;
	}

	public RespAgencyCode getRespAgencyCode() {
		return respAgencyCode;
	}
	public void setRespAgencyCode(RespAgencyCode respAgencyCode) {
		this.respAgencyCode = respAgencyCode;
	}

	public String getRespAgencyCodeDesc() {
		return respAgencyCodeDesc;
	}
	public void setRespAgencyCodeDesc(String respAgencyCodeDesc) {
		this.respAgencyCodeDesc = respAgencyCodeDesc;
	}

	public ReleaseIndustryIDCode getReleaseIndustryIDCode() {
		return releaseIndustryIDCode;
	}
	public void setReleaseIndustryIDCode(ReleaseIndustryIDCode releaseIndustryIDCode) {
		this.releaseIndustryIDCode = releaseIndustryIDCode;
	}

	public String getReleaseIndustryIDCodeDesc() {
		return releaseIndustryIDCodeDesc;
	}
	public void setReleaseIndustryIDCodeDesc(String releaseIndustryIDCodeDesc) {
		this.releaseIndustryIDCodeDesc = releaseIndustryIDCodeDesc;
	}

	public Integer getTsIncluded() {
		return tsIncluded;
	}
	public void setTsIncluded(Integer tsIncluded) {
		this.tsIncluded = tsIncluded;
	}


	// ST/SE
	public TransSetIdCode getTransSetIdCode() {
		return transSetIdCode;
	}
	public void setTransSetIdCode(TransSetIdCode transSetIdCode) {
		this.transSetIdCode = transSetIdCode;
	}

	public String getTransSetIdCodeDesc() {
		return transSetIdCodeDesc;
	}
	public void setTransSetIdCodeDesc(String transSetIdCodeDesc) {
		this.transSetIdCodeDesc = transSetIdCodeDesc;
	}

	public String getTransSetCtrlNum() {
		return transSetCtrlNum;
	}
	public void setTransSetCtrlNum(String transSetCtrlNum) {
		this.transSetCtrlNum = transSetCtrlNum;
	}


	// BHT
	public HirclStructCode getHirclStructCode() {
		return hirclStructCode;
	}
	public void setHirclStructCode(HirclStructCode hirclStructCode) {
		this.hirclStructCode = hirclStructCode;
	}

	public String getHirclStructCodeDesc() {
		return hirclStructCodeDesc;
	}
	public void setHirclStructCodeDesc(String hirclStructCodeDesc) {
		this.hirclStructCodeDesc = hirclStructCodeDesc;
	}

	public TranSetPurpCode getTranSetPurpCode() {
		return tranSetPurpCode;
	}
	public void setTranSetPurpCode(TranSetPurpCode tranSetPurpCode) {
		this.tranSetPurpCode = tranSetPurpCode;
	}

	public String getTranSetPurpCodeDesc() {
		return tranSetPurpCodeDesc;
	}
	public void setTranSetPurpCodeDesc(String tranSetPurpCodeDesc) {
		this.tranSetPurpCodeDesc = tranSetPurpCodeDesc;
	}

	public String getTransRefId() {
		return transRefId;
	}
	public void setTransRefId(String transRefId) {
		this.transRefId = transRefId;
	}
}
