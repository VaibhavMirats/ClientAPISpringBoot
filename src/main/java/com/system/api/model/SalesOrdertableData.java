package com.system.api.model;

import java.util.List;

import lombok.Data;

@Data
public class SalesOrdertableData {
	
	private Integer salesorder_id;
	private Integer ir;
	private Integer loi;
	private Integer cpi;
	private Integer required_sample;
	private Integer feasibility;
	private Integer timeline;
	private Integer total_budget;
	private String target_audience_row;
	
	private List <SalesOrderCountry> salesOrderCountry;
	
	
	public Integer getSalesorder_id() {
		return salesorder_id;
	}
	public void setSalesorder_id(Integer salesorder_id) {
		this.salesorder_id = salesorder_id;
	}
	public Integer getIr() {
		return ir;
	}
	public void setIr(Integer ir) {
		this.ir = ir;
	}
	public Integer getLoi() {
		return loi;
	}
	public void setLoi(Integer loi) {
		this.loi = loi;
	}
	public Integer getCpi() {
		return cpi;
	}
	public void setCpi(Integer cpi) {
		this.cpi = cpi;
	}
	public Integer getRequired_sample() {
		return required_sample;
	}
	public void setRequired_sample(Integer required_sample) {
		this.required_sample = required_sample;
	}
	public Integer getFeasibility() {
		return feasibility;
	}
	public void setFeasibility(Integer feasibility) {
		this.feasibility = feasibility;
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
	public String getTarget_audience_row() {
		return target_audience_row;
	}
	public void setTarget_audience_row(String target_audience_row) {
		this.target_audience_row = target_audience_row;
	}
	
	public List<SalesOrderCountry> getSalesOrderCountry() {
		return salesOrderCountry;
	}
	public void setSalesOrderCountry(List<SalesOrderCountry> salesOrderCountry) {
		this.salesOrderCountry = salesOrderCountry;
	}
	public SalesOrdertableData() {
		super();
	}
	public SalesOrdertableData(Integer salesorder_id, Integer ir, Integer loi, Integer cpi, Integer required_sample,
			Integer feasibility, Integer timeline, Integer total_budget, String target_audience_row,
			List<SalesOrderCountry> salesOrderCountry) {
		super();
		this.salesorder_id = salesorder_id;
		this.ir = ir;
		this.loi = loi;
		this.cpi = cpi;
		this.required_sample = required_sample;
		this.feasibility = feasibility;
		this.timeline = timeline;
		this.total_budget = total_budget;
		this.target_audience_row = target_audience_row;
		this.salesOrderCountry = salesOrderCountry;
	}
	@Override
	public String toString() {
		return "SalesOrdertableData [salesorder_id=" + salesorder_id + ", ir=" + ir + ", loi=" + loi + ", cpi=" + cpi
				+ ", required_sample=" + required_sample + ", feasibility=" + feasibility + ", timeline=" + timeline
				+ ", total_budget=" + total_budget + ", target_audience_row=" + target_audience_row
				+ ", salesOrderCountry=" + salesOrderCountry + "]";
	}
	
	
	
	
	
	

}
