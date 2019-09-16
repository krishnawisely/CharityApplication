package com.revature.charity.model;

import java.time.LocalDate;

public class Donor {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private String gender;
	private LocalDate date;
	private String active;
	@Override
	public String toString() {
		return "Donor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", date=" + date + ", active=" + active + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}