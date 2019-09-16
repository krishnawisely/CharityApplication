package com.revature.charity.service;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.model.Donor;

public class DonorRegisterServiceTest {
	@Test
	public void donorRefisterService()
	{
		DonorService service = new DonorServiceImpl();
		Donor donor = new Donor();
		donor.setName("test");
		donor.setEmail("test@gmail.com");
		donor.setPassword("mypass");
		LocalDate dateOfBirth = LocalDate.parse("1997-06-05");
		donor.setDateOfBirth(dateOfBirth);
		donor.setGender("male");
		service.donorRegister(donor);
	}
}
