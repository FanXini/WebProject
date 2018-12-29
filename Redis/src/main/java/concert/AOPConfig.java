package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy   //启动AspectJ自动代理
public class AOPConfig {

	//声明 Audience bean
	@Bean
	public Audience audience() {
		return new Audience();
	}
	//声明 EncoreableIntroducer bean
	@Bean
	public EncoreableIntroducer encoreableIntroducer() {
		return new EncoreableIntroducer();
	}
	@Bean 
	public JChou jChou() {
		return new JChou();
	}
	
}
