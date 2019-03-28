package com.zhd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zhd.service.MessageService;

@SpringBootApplication
public class SpringbootSampleProfileApplication implements CommandLineRunner{

	@Autowired
	private MessageService messageService;

	@Override
	public void run(String... args) {
		System.out.println(this.messageService.getMessage());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSampleProfileApplication.class, args);
	}

}
