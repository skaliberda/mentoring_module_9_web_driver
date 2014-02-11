package com.epam.mentoring.core;

public class Builder {
	
	private TestData testData;

	public void create() {
		testData = new TestData();
	}

	public void setAddresse(String addressee) {
		this.testData.letterAddressee = addressee;		
	}

	public void setSubject(String subject) {
		this.testData.letterSubject = subject;
	}

	public void setBody(String body) {
		this.testData.letterBody = body;		
	}

	public TestData getTestData() {
		return this.testData;
	}
}
