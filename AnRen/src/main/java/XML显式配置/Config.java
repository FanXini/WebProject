package XMLœ‘ Ω≈‰÷√;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ImportResource("classpath:Spring/ApplicationContext.xml")
public class Config {
  @Bean 
  public ApplicationContext getContext() {
	  return new ClassPathXmlApplicationContext("Spring/ApplicationContext.xml");
  }
}
