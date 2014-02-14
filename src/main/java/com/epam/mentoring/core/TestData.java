package com.epam.mentoring.core;

public class TestData {
	
	private String letterAddressee;
	private String letterSubject;
	private String letterBody;

	public TestData(String letterAddressee, String letterSubject, String letterBody) {
		this.letterAddressee = letterAddressee;
		this.letterSubject = letterSubject;
		this.letterBody = letterBody;
	 }
	
	public String getAddressee() {
		return this.letterAddressee;
	}

	public String getSubject() {
		return this.letterSubject;
	}

	public String getBody() {
		return this.letterBody;
	}	
}
