package Bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  //优先使用
public class Dog implements Animal{

	@Override
	public void sound() {
		System.out.println("旺旺");
	}

	@Override
	public void function() {
		System.out.println("看门");
	}

}
