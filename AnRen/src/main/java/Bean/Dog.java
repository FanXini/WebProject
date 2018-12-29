package Bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  //����ʹ��
public class Dog implements Animal{

	@Override
	public void sound() {
		System.out.println("����");
	}

	@Override
	public void function() {
		System.out.println("����");
	}

}
