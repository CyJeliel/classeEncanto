package br.com.classeencanto.builder.impl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.classeencanto.builder.Builder;

public class MessageBuilder implements Builder<Message> {

	private String fromEmail;

	private String emailContent;

	private Session session;

	public MessageBuilder(String fromEmail, String mensagem, Session session) {

		this.fromEmail = fromEmail;

		this.emailContent = mensagem;

		this.session = session;
	}

	@Override
	public Message build() {

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(fromEmail));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("cindy.jeliel@gmail.com"));

			message.setSubject("Fale Conosco - " + fromEmail);

			message.setText(emailContent);

			return message;

		} catch (MessagingException e) {

			e.printStackTrace();

			throw new RuntimeException(e);
		}
	}

}
