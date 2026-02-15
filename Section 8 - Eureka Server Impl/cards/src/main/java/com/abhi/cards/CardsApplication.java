package com.abhi.cards;

import com.abhi.cards.Dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

   @SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.abhi.accounts.controller") })
@EnableJpaRepositories("com.abhi.accounts.repository")
@EntityScan("com.abhi.accounts.model")*/
   	@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
	@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
	@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "Abhijeet Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Abhijeet Kumar Jha",
						email = "abhijeet@gmail.com",
						url = "https://www.abhijeet.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.abhijeet.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Abhijeet Cards microservice REST API Documentation",
				url = "https://www.abhijeet.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
