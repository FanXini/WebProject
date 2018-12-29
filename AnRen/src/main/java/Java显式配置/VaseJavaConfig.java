package Javaœ‘ Ω≈‰÷√;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import Bean.Flower;
import Bean.Vase;

@Configuration
@Import(FlowerJavaConfig.class)
public class VaseJavaConfig {
	@Bean
	Vase getVase3(Flower flower) {
		return new Vase(flower);
	}
}
