package Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Family {
	//@Autowired   //直接用在对象定义上
	private  Animal pet;
	@Autowired(required=false)     //用在构造器上
	public Family(Animal animal) {
		this.pet=animal;
	}
	public Family() {
		
	}
	
	public Animal getPet() {
		return pet;
	}
	
	//@Autowired       //用在setter方法上
	public void setPet(Animal pet) {
		this.pet=pet;
	}
}
