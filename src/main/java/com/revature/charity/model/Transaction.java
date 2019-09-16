package com.revature.charity.model;

import java.time.LocalDate;

public class Transaction {
	private Integer id;
	private Integer fundRequestId;
	private Integer donorId;
	private Double amount;
	private LocalDate date;
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", donorId=" + fundRequestId + ", admin_id=" + donorId + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getfundRequestId() {
		return fundRequestId;
	}
	public void setfundRequestId(Integer fundRequestId) {
		this.fundRequestId = fundRequestId;
	}
	public Integer getDonorId() {
		return donorId;
	}
	public void setDonorId(Integer admin_id) {
		this.donorId = admin_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
