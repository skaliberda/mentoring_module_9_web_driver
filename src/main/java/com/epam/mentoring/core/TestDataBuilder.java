package com.epam.mentoring.core;

public class TestDataBuilder {
		
		private String letterAddressee;
		private String letterSubject;
		private String letterBody;
		
		public TestDataBuilder setAddresse(String addresse) {
			letterAddressee = addresse;
			return this;
		}
		
		public TestDataBuilder setSubject(String subject) {
			this.letterSubject = subject;
			return this;
		}
		
		public TestDataBuilder setBody(String body) {
			letterBody = body;
			return this;
		}
		 
		 public TestData build() {
		      return new TestData(letterAddressee, letterSubject, letterBody);
		 }
	}

