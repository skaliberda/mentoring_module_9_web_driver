package com.epam.mentoring.core;

public class TestDataCreator {
	
	Builder builder = new Builder();
	
	public TestData createTestData(String addresse, String subject, String body) {
		builder.create();
		builder.setAddressee(addresse);
		builder.setSubject(subject);
		builder.setBody(body);
		return builder.getTestData();
	}
}
