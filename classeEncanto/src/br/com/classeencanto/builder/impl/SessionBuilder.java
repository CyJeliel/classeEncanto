package br.com.classeencanto.builder.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import br.com.classeencanto.builder.Builder;

public class SessionBuilder implements Builder<Session> {

	private Properties properties;
	
	public SessionBuilder(Properties properties) {

		this.properties = properties;
	}
	
	@Override
	public Session build() {
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("cindy.jeliel@gmail.com", "M0k0n@w@M0k0n@");
			}
		});
		
		return session;
	}

}
