package Java显式配置;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Bean.Flower;
import Bean.Rose;
import Bean.Vase;

@Configuration
public class JavaConfig {
	@Bean(name= {"rose","rose1"})
	public Flower getRose() {
		return new Rose();
	}
	@Bean
	public Vase getVase() {
		return new Vase(getRose());  //调用获取rose bean的方法
	}
	@Bean 
	public Vase getVase1() {
		Vase vase=new Vase();
		vase.setFlower(getRose());
		return vase;
	}
	@Bean Vase getVase3(Flower flower) {
		return new Vase(flower);
	}

}
