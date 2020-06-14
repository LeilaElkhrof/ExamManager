package com.fstg.gestion.exams.model.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



 @RequestMapping(value = "exam-api/sendemail")
@RestController
public class EmailRest {
	 
	 @Autowired
	    private JavaMailSender javaMailSender;
	 @PostMapping("/send/to/{to}/subject/{subject}/text/{text}")
	    public void sendSimpleMessage( @PathVariable String to, @PathVariable  String subject, @PathVariable  String text) {
	    	       System.out.println("zahrrraa");
	    	        SimpleMailMessage message = new SimpleMailMessage(); 
	    	        message.setTo(to); 
	    	        System.out.println(to);
	    	        message.setSubject(subject);
	    	        System.out.println(subject);
	    	        message.setText(text);
	    	        System.out.println(text);
	    	        javaMailSender.send(message);
	    	    }
}
