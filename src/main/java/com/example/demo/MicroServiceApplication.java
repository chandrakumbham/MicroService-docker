package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
	
	
	@Bean
	public Docket swaggerconfiguration() {
		//return docket instance customize the document based on package that under /api
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/api/*/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.build()
				.apiInfo(apiDetails());
			//	.select()
			//	.paths(PathSelectors.ant("/api/*"))
				
		
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Notes API",
				"Sample Api for notes",
				"1.0",
				"Pay per use",
				new springfox.documentation.service.Contact("chandra", "http://localhost:8080/api/notes", "chandra@gmailc.om"),
				"Api License",
				"",
				Collections.emptyList());
				
	}

}
