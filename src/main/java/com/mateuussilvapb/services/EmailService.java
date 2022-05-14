package com.mateuussilvapb.services;

import org.springframework.mail.SimpleMailMessage;

import com.mateuussilvapb.domain.Pedido;

//---------------------------------------------------------
public interface EmailService {

	// ---------------------------------------------------------
	void sendOrderConfirmationEmail(Pedido obj);

	// ---------------------------------------------------------
	void sendEmail(SimpleMailMessage msg);
}
