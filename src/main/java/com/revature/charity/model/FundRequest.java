package com.revature.charity.model;

import java.time.LocalDate;

public class FundRequest {
	
	private Integer id;
	private Integer adminId;
	private String requestType;
	private String description;
	private LocalDate expireDate;
	private String date;
	private Double amount;
	private Boolean active;
	@Override
	public String toString() {
		return "FundRequest [id=" + id + ", adminId=" + adminId + ", requestType=" + requestType + ", description="
				+ description + ", expireDate=" + expireDate + ", date=" + date + ", amount=" + amount + ", active="
				+ active + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
