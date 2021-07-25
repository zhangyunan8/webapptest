package com.proquest.interview.phonebook;

/*
 Because of personal data, feel it is necessary to put some access control in place:
 	1. class variables can only be accessed within the declared class itself.
  	2. class methods, constructor can be only accessed within the same package and subclass within other package
 */


public class Person {

	private String name;
	private String phoneNumber;
	private String address;

	protected Person(){};

	protected Person (String inputName, String inputPhonenumber, String inputAddress){
		setName(inputName);
		setAddress(inputAddress);
		setPhoneNumber(inputPhonenumber);
	}
	// setters and getters
	protected void setName(String inputName){
		this.name = inputName;
	}
	protected void setPhoneNumber(String inputPhonenumber){
		this.phoneNumber = inputPhonenumber;
	}
	protected void setAddress(String inputAddress){
		this.address = inputAddress;
	}
	protected String getName(){
		return this.name;
	}
	protected String getPhoneNumber(){
		return this.phoneNumber;
	}
	protected String getAddress(){
		return this.address;
	}
}
