package Javaœ‘ Ω≈‰÷√;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(VaseJavaConfig.class)
@ImportResource("classpath:Spring/ApplicationContext.xml")
public class ConfigCenter {

}
