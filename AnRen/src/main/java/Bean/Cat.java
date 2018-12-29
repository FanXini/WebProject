package Bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
@Qualifier("smart")
public class Cat implements Animal {

	@Override
	public void sound() {
		System.out.println("ß÷ß÷");
		
	}

	@Override
	public void function() {
		System.out.println("×¥ÀÏÊó");
	}

}
