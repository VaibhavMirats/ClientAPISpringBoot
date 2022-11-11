package com.system.api.model;

import java.util.List;

import lombok.Data;

@Data
public class SalesOrders {
	
	private Integer id;
	private String account_name;
	private Integer account_id;
	private String account_email;
	private Integer cpi;
	private Integer ir;
	private String currency_type;
	private String buisness_unit;
	private Integer feasibility;
	private String industry;
	private Integer loi;
	private String project_name;
	private String reference_client_project_name;
	private Integer sample_required;
	private String status;
	private String overall_target_audience;
	private Integer timeline;
	private Integer total_budget;
	private String studytype;
	private String survey_type;
	private Integer created_user_id;
	private String created_user_name;
	private String created_user_email;
	
	private Integer sales_manager_id;
	private String sales_manager_name;
	private String sales_manager_email;
	
	private String device_compatibility;
	private String description;
	private String extra_notes;
	private List <SalesOrdertableData> salesOrdertableData;
	

	public SalesOrders() {
		super();
	}



	


	






	public SalesOrders(Integer id, String account_name, Integer account_id, String account_email, Integer cpi,
			Integer ir, String currency_type, String buisness_unit, Integer feasibility, String industry, Integer loi,
			String project_name, String reference_client_project_name, Integer sample_required, String status,
			String overall_target_audience, Integer timeline, Integer total_budget, String studytype,
			String survey_type, Integer created_user_id, String created_user_name, String created_user_email,
			Integer sales_manager_id, String sales_manager_name, String sales_manager_email,
			String device_compatibility, String description, String extra_notes,
			List<SalesOrdertableData> salesOrdertableData) {
		super();
		this.id = id;
		this.account_name = account_name;
		this.account_id = account_id;
		this.account_email = account_email;
		this.cpi = cpi;
		this.ir = ir;
		this.currency_type = currency_type;
		this.buisness_unit = buisness_unit;
		this.feasibility = feasibility;
		this.industry = industry;
		this.loi = loi;
		this.project_name = project_name;
		this.reference_client_project_name = reference_client_project_name;
		this.sample_required = sample_required;
		this.status = status;
		this.overall_target_audience = overall_target_audience;
		this.timeline = timeline;
		this.total_budget = total_budget;
		this.studytype = studytype;
		this.survey_type = survey_type;
		this.created_user_id = created_user_id;
		this.created_user_name = created_user_name;
		this.created_user_email = created_user_email;
		this.sales_manager_id = sales_manager_id;
		this.sales_manager_name = sales_manager_name;
		this.sales_manager_email = sales_manager_email;
		this.device_compatibility = device_compatibility;
		this.description = description;
		this.extra_notes = extra_notes;
		this.salesOrdertableData = salesOrdertableData;
	}













	public void setDevice_compatibility(String device_compatibility) {
		this.device_compatibility = device_compatibility;
	}






	@Override
	public String toString() {
		return "SalesOrders [account_name=" + account_name + ", account_id=" + account_id + ", account_email="
				+ account_email + ", cpi=" + cpi + ", ir=" + ir + ", currency_type=" + currency_type
				+ ", buisness_unit=" + buisness_unit + ", feasibility=" + feasibility + ", industry=" + industry
				+ ", loi=" + loi + ", project_name=" + project_name + ", reference_client_project_name="
				+ reference_client_project_name + ", sample_required=" + sample_required + ", status=" + status
				+ ", overall_target_audience=" + overall_target_audience + ", timeline=" + timeline + ", total_budget="
				+ total_budget + ", studytype=" + studytype + ", survey_type=" + survey_type + ", created_user_id="
				+ created_user_id + ", created_user_name=" + created_user_name + ", created_user_email="
				+ created_user_email + ", sales_manager_id=" + sales_manager_id + ", sales_manager_name="
				+ sales_manager_name + ", sales_manager_email=" + sales_manager_email + ", device_compatibility="
				+ device_compatibility + ", description=" + description + ", extra_notes=" + extra_notes + "]";
	}



	public String getAccount_name() {
		return account_name;
	}



	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}



	public Integer getAccount_id() {
		return account_id;
	}



	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}



	public String getAccount_email() {
		return account_email;
	}



	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}



	public Integer getCpi() {
		return cpi;
	}



	public void setCpi(Integer cpi) {
		this.cpi = cpi;
	}



	public Integer getIr() {
		return ir;
	}



	public void setIr(Integer ir) {
		this.ir = ir;
	}



	public String getCurrency_type() {
		return currency_type;
	}



	public void setCurrency_type(String currency_type) {
		this.currency_type = currency_type;
	}



	public String getBuisness_unit() {
		return buisness_unit;
	}



	public void setBuisness_unit(String buisness_unit) {
		this.buisness_unit = buisness_unit;
	}



	public Integer getFeasibility() {
		return feasibility;
	}



	public void setFeasibility(Integer feasibility) {
		this.feasibility = feasibility;
	}



	public String getIndustry() {
		return industry;
	}



	public void setIndustry(String industry) {
		this.industry = industry;
	}



	public Integer getLoi() {
		return loi;
	}



	public void setLoi(Integer loi) {
		this.loi = loi;
	}



	public String getProject_name() {
		return project_name;
	}



	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}



	public String getReference_client_project_name() {
		return reference_client_project_name;
	}



	public void setReference_client_project_name(String reference_client_project_name) {
		this.reference_client_project_name = reference_client_project_name;
	}



	public Integer getSample_required() {
		return sample_required;
	}



	public void setSample_required(Integer sample_required) {
		this.sample_required = sample_required;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getOverall_target_audience() {
		return overall_target_audience;
	}



	public void setOverall_target_audience(String overall_target_audience) {
		this.overall_target_audience = overall_target_audience;
	}



	public Integer getTimeline() {
		return timeline;
	}



	public void setTimeline(Integer timeline) {
		this.timeline = timeline;
	}



	public Integer getTotal_budget() {
		return total_budget;
	}



	public void setTotal_budget(Integer total_budget) {
		this.total_budget = total_budget;
	}



	public String getStudytype() {
		return studytype;
	}



	public void setStudytype(String studytype) {
		this.studytype = studytype;
	}



	public String getSurvey_type() {
		return survey_type;
	}



	public void setSurvey_type(String survey_type) {
		this.survey_type = survey_type;
	}



	public Integer getCreated_user_id() {
		return created_user_id;
	}



	public void setCreated_user_id(Integer created_user_id) {
		this.created_user_id = created_user_id;
	}



	public String getCreated_user_name() {
		return created_user_name;
	}



	public void setCreated_user_name(String created_user_name) {
		this.created_user_name = created_user_name;
	}



	public String getCreated_user_email() {
		return created_user_email;
	}



	public void setCreated_user_email(String created_user_email) {
		this.created_user_email = created_user_email;
	}



	public Integer getSales_manager_id() {
		return sales_manager_id;
	}



	public void setSales_manager_id(Integer sales_manager_id) {
		this.sales_manager_id = sales_manager_id;
	}



	public String getSales_manager_name() {
		return sales_manager_name;
	}



	public void setSales_manager_name(String sales_manager_name) {
		this.sales_manager_name = sales_manager_name;
	}



	public String getSales_manager_email() {
		return sales_manager_email;
	}



	public void setSales_manager_email(String sales_manager_email) {
		this.sales_manager_email = sales_manager_email;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getExtra_notes() {
		return extra_notes;
	}



	public void setExtra_notes(String extra_notes) {
		this.extra_notes = extra_notes;
	}






	public Integer getId() {
		return id;
	}






	public void setId(Integer id) {
		this.id = id;
	}






	public String getDevice_compatibility() {
		return device_compatibility;
	}






	public List<SalesOrdertableData> getSalesOrdertableData() {
		return salesOrdertableData;
	}






	public void setSalesOrdertableData(List<SalesOrdertableData> salesOrdertableData) {
		this.salesOrdertableData = salesOrdertableData;
	}
	
	
	

}
