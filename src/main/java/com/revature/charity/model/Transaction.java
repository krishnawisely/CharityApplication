package com.revature.charity.model;

import java.time.LocalDate;

public class Transaction {
	private Integer id;
	private Integer donorId;
	private Integer admin_id;
	private Double amount;
	private LocalDate date;
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", donorId=" + donorId + ", admin_id=" + admin_id + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDonorId() {
		return donorId;
	}
	public void setDonorId(Integer donorId) {
		this.donorId = donorId;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
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
