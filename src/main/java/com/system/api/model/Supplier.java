package com.system.api.model;

import lombok.Data;

@Data
public class Supplier {
	
	private String approval_description;
	private String bid_contact_name;
	private String bid_emails_cc;
	private String company_name;
	private String company_description;
	private String date_applied;
	private Boolean supplier_portal_access;
	private String status;
	private String user_id;
	public String getApproval_description() {
		return approval_description;
	}
	public void setApproval_description(String approval_description) {
		this.approval_description = approval_description;
	}
	public String getBid_contact_name() {
		return bid_contact_name;
	}
	public void setBid_contact_name(String bid_contact_name) {
		this.bid_contact_name = bid_contact_name;
	}
	public String getBid_emails_cc() {
		return bid_emails_cc;
	}
	public void setBid_emails_cc(String bid_emails_cc) {
		this.bid_emails_cc = bid_emails_cc;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_description() {
		return company_description;
	}
	public void setCompany_description(String company_description) {
		this.company_description = company_description;
	}
	public String getDate_applied() {
		return date_applied;
	}
	public void setDate_applied(String date_applied) {
		this.date_applied = date_applied;
	}
	public Boolean getSupplier_portal_access() {
		return supplier_portal_access;
	}
	public void setSupplier_portal_access(Boolean supplier_portal_access) {
		this.supplier_portal_access = supplier_portal_access;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Supplier(String approval_description, String bid_contact_name, String bid_emails_cc, String company_name,
			String company_description, String date_applied, Boolean supplier_portal_access, String status,
			String user_id) {
		super();
		this.approval_description = approval_description;
		this.bid_contact_name = bid_contact_name;
		this.bid_emails_cc = bid_emails_cc;
		this.company_name = company_name;
		this.company_description = company_description;
		this.date_applied = date_applied;
		this.supplier_portal_access = supplier_portal_access;
		this.status = status;
		this.user_id = user_id;
	}
	public Supplier() {
		super();
	}
	@Override
	public String toString() {
		return "Supplier [approval_description=" + approval_description + ", bid_contact_name=" + bid_contact_name
				+ ", bid_emails_cc=" + bid_emails_cc + ", company_name=" + company_name + ", company_description="
				+ company_description + ", date_applied=" + date_applied + ", supplier_portal_access="
				+ supplier_portal_access + ", status=" + status + ", user_id=" + user_id + "]";
	}
	 
	

}
