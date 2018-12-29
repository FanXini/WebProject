package Javaœ‘ Ω≈‰÷√;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Bean.Flower;
import Bean.Rose;

@Configuration
public class FlowerJavaConfig {
	@Bean(name= {"rose","rose1"})
	public Flower getRose() {
		return new Rose();
	}
}
