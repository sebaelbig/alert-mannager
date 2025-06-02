package com.recondo.lookup.generation.ruleInput.eligibility.parts;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Represents the ISA/GS/ST/BHT/SE/GE/IEA segments of a X12 270/271 EDI
 */
public class RuleTransactionHeader {
	// ISA/IEA
	private String authInfoQlfr;
	private String authInfoQlfrDesc;
	private String authInfo;

	private String securityInfoQlfr;
	private String securityInfoQlfrDesc;
	private String securityInfo;

	private String senderIdQlfr;
	private String senderIdQlfrDesc;
	private String senderId;

	private String recvIdQlfr;
	private String recvIdQlfrDesc;
	private String recvId;

	private Date interchangeTimeStamp;

	private Character repititionSeparator;

	private String interchangeCtrlVerNum;
	private String interchangeCtrlVerNumDesc;
	private String interchangeCtrlNum;

	private String ackRequested;
	private String ackRequestedDesc;

	private String interchangeUsageIndicator;
	private String interchangeUsageIndicatorDesc;

	private Character componentElemSeparator;
	private Character segmentTerminator;
	private Character dataElemSeparator;
	private Short funcGroupIncluded;

	// GS/GE
	private String funcIdCode;
	private String senderCode;
	private String recvCode;
	private String groupCtrlNum;

	private String respAgencyCode;
	private String respAgencyCodeDesc;

	private String releaseIndustryIDCode;
	private String releaseIndustryIDCodeDesc;

	private Integer tsIncluded;

	// ST/SE
	private String transSetIdCode;
	private String transSetIdCodeDesc;

	private String transSetCtrlNum;

	// BHT
	private String hirclStructCode;
	private String hirclStructCodeDesc;

	private String tranSetPurpCode;
	private String tranSetPurpCodeDesc;

	private String transRefId;


	public RuleTransactionHeader() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	// ISA/IEA
	public String getAuthInfoQlfr() {
		return authInfoQlfr;
	}
	public void setAuthInfoQlfr(String authInfoQlfr) {
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

	public String getSecurityInfoQlfr() {
		return securityInfoQlfr;
	}
	public void setSecurityInfoQlfr(String securityInfoQlfr) {
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

	public String getSenderIdQlfr() {
		return senderIdQlfr;
	}
	public void setSenderIdQlfr(String senderIdQlfr) {
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

	public String getRecvIdQlfr() {
		return recvIdQlfr;
	}
	public void setRecvIdQlfr(String recvIdQlfr) {
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

	public String getInterchangeCtrlVerNum() {
		return interchangeCtrlVerNum;
	}
	public void setInterchangeCtrlVerNum(String interchangeCtrlVerNum) {
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

	public String getAckRequested() {
		return ackRequested;
	}
	public void setAckRequested(String ackRequested) {
		this.ackRequested = ackRequested;
	}

	public String getAckRequestedDesc() {
		return ackRequestedDesc;
	}
	public void setAckRequestedDesc(String ackRequestedDesc) {
		this.ackRequestedDesc = ackRequestedDesc;
	}

	public String getInterchangeUsageIndicator() {
		return interchangeUsageIndicator;
	}
	public void setInterchangeUsageIndicator(String interchangeUsageIndicator) {
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

	public String getRespAgencyCode() {
		return respAgencyCode;
	}
	public void setRespAgencyCode(String respAgencyCode) {
		this.respAgencyCode = respAgencyCode;
	}

	public String getRespAgencyCodeDesc() {
		return respAgencyCodeDesc;
	}
	public void setRespAgencyCodeDesc(String respAgencyCodeDesc) {
		this.respAgencyCodeDesc = respAgencyCodeDesc;
	}

	public String getReleaseIndustryIDCode() {
		return releaseIndustryIDCode;
	}
	public void setReleaseIndustryIDCode(String releaseIndustryIDCode) {
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
	public String getTransSetIdCode() {
		return transSetIdCode;
	}
	public void setTransSetIdCode(String transSetIdCode) {
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
	public String getHirclStructCode() {
		return hirclStructCode;
	}
	public void setHirclStructCode(String hirclStructCode) {
		this.hirclStructCode = hirclStructCode;
	}

	public String getHirclStructCodeDesc() {
		return hirclStructCodeDesc;
	}
	public void setHirclStructCodeDesc(String hirclStructCodeDesc) {
		this.hirclStructCodeDesc = hirclStructCodeDesc;
	}

	public String getTranSetPurpCode() {
		return tranSetPurpCode;
	}
	public void setTranSetPurpCode(String tranSetPurpCode) {
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
