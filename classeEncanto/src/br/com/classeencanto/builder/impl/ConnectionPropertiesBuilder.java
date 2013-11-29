package br.com.classeencanto.builder.impl;

import java.util.Properties;

import br.com.classeencanto.builder.Builder;

public class ConnectionPropertiesBuilder implements Builder<Properties> {

	@Override
	public Properties build() {
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		properties.put("mail.smtp.socketFactory.port", "465");

		properties.put("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
		
		properties.put("mail.smtp.auth", "true");
		
		properties.put("mail.smtp.port", "465");
		
		return properties;
	}

}
