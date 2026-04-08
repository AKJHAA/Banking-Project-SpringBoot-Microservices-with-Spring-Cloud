package com.abhi.loans;

import com.abhi.loans.Dto.LoansContactInfoDto;
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
/*@ComponentScans({ @ComponentScan("com.abhi.loans.Controller") })
@EnableJpaRepositories("com.abhi.loans.Repository")
@EntityScan("com.abhi.loans.Model")*/
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "Abhijeet Banks Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Abhijeet Kumar Jha",
						email = "akjhaa1508@gmail.com",
						url = "https://www.abhijeet.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.abhijeet.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Abhijeet Banks Loans microservice REST API Documentation",
				url = "https://www.abhijeet.com/swagger-ui.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}