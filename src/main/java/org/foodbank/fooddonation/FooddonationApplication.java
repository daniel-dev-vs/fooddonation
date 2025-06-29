package org.foodbank.fooddonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		basePackages = "org.foodbank.fooddonation",
		excludeFilters =  @ComponentScan.Filter(
				type = FilterType.REGEX,
				pattern = "org\\.core\\..*"
		)
)
public class FooddonationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooddonationApplication.class, args);
	}

}
