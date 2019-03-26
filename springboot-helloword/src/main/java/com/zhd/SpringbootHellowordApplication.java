package com.zhd;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
@ComponentScan(basePackages="com")
public class SpringbootHellowordApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootHellowordApplication.class);
	
	public static void main(String[] args) {
//		System.out.println("---主方法开始---");
		logger.info("---主方法开始---");
		SpringApplication.run(SpringbootHellowordApplication.class, args);
//		System.out.println("---主方法结束---");
		logger.info("---主方法结束---");
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
//			System.out.println("bean的个数"+ctx.getBeanDefinitionCount());
			logger.info("bean的个数"+ctx.getBeanDefinitionCount());
			
			String[] names = ctx.getBeanDefinitionNames();
			Arrays.sort(names);
			for (String name : names) {
//				System.out.println(name);
				logger.info(name);
			}
//			System.out.println("CommandLineRunner结束");
			logger.info("CommandLineRunner结束");
		};
	}
	@Bean
	public ApplicationRunner appRunner() {
		return args -> {
			System.out.println("ApplicationRunner:开始");
			for (String opt : args.getOptionNames()) {
//				System.out.print(opt);
//				System.out.print("->");
//				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(",", "[", "]")));
				logger.info(opt);
				logger.info(args.getOptionValues(opt).stream().collect(Collectors.joining(",", "[", "]")));
				
				String.join(",", args.getOptionValues(opt));
			}
		};
	}
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL = "/hello";
		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
//					System.out.println(" hello");
					logger.info(" hello");
			}
		};
	}
}
