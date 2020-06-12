package com.dathanwong.relationships.services;

import org.springframework.stereotype.Service;

import com.dathanwong.relationships.models.License;
import com.dathanwong.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository repo;
	
	public LicenseService(LicenseRepository repo) {
		this.repo = repo;
	}
	
	public License createLicense(License license) {
		//Create license number by converting id to string and padding zeros in front
		Long number = license.getPerson().getId();
		System.out.println(number);
		int numLength = String.valueOf(number).length();
		System.out.println("Length:" + numLength);
		int numZeros = 6-numLength;
		String licenseNumber = "";
		for(int i = 0; i < numZeros; i++) {
			licenseNumber = licenseNumber + "0";
		}
		System.out.println(licenseNumber);
		licenseNumber = licenseNumber + String.valueOf(number);
		license.setNumber(licenseNumber);
		return repo.save(license);
	}
}
