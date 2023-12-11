package com.anand.democallapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class DemoCallAppApplication implements ApplicationRunner {
	private final static String SID_ACCOUNT = "ACbcb8bf54c8af8cbca9479b41264d91cf";
	private final static String AUTH_ID = "a02a0159881f573dbc8264c6b5875890";
	private final static String FROM_NUMBER="+12536550005";
	private final static String TO_NUMBER ="+917992310106";
	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoCallAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();
	}
}
