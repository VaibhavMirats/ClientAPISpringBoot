package com.system.api.model;

import lombok.Data;

@Data
public class Survey {
	
	private String surveyName;
	private String surveyStatus;
	private Integer clientId;
	private String studyType;
	private String surveyType;
	private Integer requiredCompletes;
	private Integer clientCPI;
	private Boolean existingProjectChecked;
	private Integer bidIR;
	private Integer bidLOI;
	private String businessUnit;
	private String industry;
	private String expectedStartDate;
	private String expectedEndDate;
	private String externalSurveyName;
	private String liveURL;
	private String testURL;
	private Boolean piiCollection;
	private Integer projectId;
	private Integer countryId;
	private Integer currencyId;
	private Integer surveyGroupId;
	private Integer employeeId;
	
	
	
	
	public Survey() {
		super();
	}




	public Survey(String surveyName, String surveyStatus, Integer clientId, String studyType, String surveyType,
			Integer requiredCompletes, Integer clientCPI, Boolean existingProjectChecked, Integer bidIR, Integer bidLOI,
			String businessUnit, String industry, String expectedStartDate, String expectedEndDate,
			String externalSurveyName, String liveURL, String testURL, Boolean piiCollection, Integer projectId,
			Integer countryId, Integer currencyId, Integer surveyGroupId, Integer employeeId) {
		super();
		this.surveyName = surveyName;
		this.surveyStatus = surveyStatus;
		this.clientId = clientId;
		this.studyType = studyType;
		this.surveyType = surveyType;
		this.requiredCompletes = requiredCompletes;
		this.clientCPI = clientCPI;
		this.existingProjectChecked = existingProjectChecked;
		this.bidIR = bidIR;
		this.bidLOI = bidLOI;
		this.businessUnit = businessUnit;
		this.industry = industry;
		this.expectedStartDate = expectedStartDate;
		this.expectedEndDate = expectedEndDate;
		this.externalSurveyName = externalSurveyName;
		this.liveURL = liveURL;
		this.testURL = testURL;
		this.piiCollection = piiCollection;
		this.projectId = projectId;
		this.countryId = countryId;
		this.currencyId = currencyId;
		this.surveyGroupId = surveyGroupId;
		this.employeeId = employeeId;
	}




	public String getSurveyName() {
		return surveyName;
	}




	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}




	public String getSurveyStatus() {
		return surveyStatus;
	}




	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}




	public Integer getClientId() {
		return clientId;
	}




	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}




	public String getStudyType() {
		return studyType;
	}




	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}




	public String getSurveyType() {
		return surveyType;
	}




	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}




	public Integer getRequiredCompletes() {
		return requiredCompletes;
	}




	public void setRequiredCompletes(Integer requiredCompletes) {
		this.requiredCompletes = requiredCompletes;
	}




	public Integer getClientCPI() {
		return clientCPI;
	}




	public void setClientCPI(Integer clientCPI) {
		this.clientCPI = clientCPI;
	}









	public Boolean getExistingProjectChecked() {
		return existingProjectChecked;
	}




	public void setExistingProjectChecked(Boolean existingProjectChecked) {
		this.existingProjectChecked = existingProjectChecked;
	}




	public Integer getBidIR() {
		return bidIR;
	}




	public void setBidIR(Integer bidIR) {
		this.bidIR = bidIR;
	}




	public Integer getBidLOI() {
		return bidLOI;
	}




	public void setBidLOI(Integer bidLOI) {
		this.bidLOI = bidLOI;
	}




	public String getBusinessUnit() {
		return businessUnit;
	}




	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}




	public String getIndustry() {
		return industry;
	}




	public void setIndustry(String industry) {
		this.industry = industry;
	}




	public String getExpectedStartDate() {
		return expectedStartDate;
	}




	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}




	public String getExpectedEndDate() {
		return expectedEndDate;
	}




	public void setExpectedEndDate(String expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}




	public String getExternalSurveyName() {
		return externalSurveyName;
	}




	public void setExternalSurveyName(String externalSurveyName) {
		this.externalSurveyName = externalSurveyName;
	}




	public String getLiveURL() {
		return liveURL;
	}




	public void setLiveURL(String liveURL) {
		this.liveURL = liveURL;
	}




	public String getTestURL() {
		return testURL;
	}




	public void setTestURL(String testURL) {
		this.testURL = testURL;
	}




	public Boolean getPiiCollection() {
		return piiCollection;
	}




	public void setPiiCollection(Boolean piiCollection) {
		this.piiCollection = piiCollection;
	}




	public Integer getProjectId() {
		return projectId;
	}




	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}




	public Integer getCountryId() {
		return countryId;
	}




	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}




	public Integer getCurrencyId() {
		return currencyId;
	}




	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}




	public Integer getSurveyGroupId() {
		return surveyGroupId;
	}




	public void setSurveyGroupId(Integer surveyGroupId) {
		this.surveyGroupId = surveyGroupId;
	}




	public Integer getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}




	@Override
	public String toString() {
		return "Survey [surveyName=" + surveyName + ", surveyStatus=" + surveyStatus + ", clientId=" + clientId
				+ ", studyType=" + studyType + ", surveyType=" + surveyType + ", requiredCompletes=" + requiredCompletes
				+ ", clientCPI=" + clientCPI + ", existingProjectChecked=" + existingProjectChecked + ", bidIR=" + bidIR
				+ ", bidLOI=" + bidLOI + ", businessUnit=" + businessUnit + ", industry=" + industry
				+ ", expectedStartDate=" + expectedStartDate + ", expectedEndDate=" + expectedEndDate
				+ ", externalSurveyName=" + externalSurveyName + ", liveURL=" + liveURL + ", testURL=" + testURL
				+ ", piiCollection=" + piiCollection + ", projectId=" + projectId + ", countryId=" + countryId
				+ ", currencyId=" + currencyId + ", surveyGroupId=" + surveyGroupId + ", employeeId=" + employeeId
				+ "]";
	}
	
	
	

}
