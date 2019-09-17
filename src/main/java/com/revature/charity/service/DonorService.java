package com.revature.charity.service;

import com.revature.charity.model.Donor;


public interface DonorService {
	public Donor donorSignin(Donor donor);
	public Boolean donorRegister(Donor donor);
}
