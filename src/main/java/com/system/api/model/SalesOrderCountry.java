package com.system.api.model;

import lombok.Data;

@Data
public class SalesOrderCountry {
	
	private Integer salesorder_tabledata_id;
	private String country_name;
	private String country_code;
	
	public Integer getSalesorder_tabledata_id() {
		return salesorder_tabledata_id;
	}
	public void setSalesorder_tabledata_id(Integer salesorder_tabledata_id) {
		this.salesorder_tabledata_id = salesorder_tabledata_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	
	
	public SalesOrderCountry() {
		super();
	}
	
	public SalesOrderCountry(Integer salesorder_tabledata_id, String country_name, String country_code) {
		super();
		this.salesorder_tabledata_id = salesorder_tabledata_id;
		this.country_name = country_name;
		this.country_code = country_code;
	}
	@Override
	public String toString() {
		return "SalesOrderCountry [salesorder_tabledata_id=" + salesorder_tabledata_id + ", country_name="
				+ country_name + ", country_code=" + country_code + "]";
	}
	
	
	

	

}
