package Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Family {
	//@Autowired   //ֱ�����ڶ�������
	private  Animal pet;
	@Autowired(required=false)     //���ڹ�������
	public Family(Animal animal) {
		this.pet=animal;
	}
	public Family() {
		
	}
	
	public Animal getPet() {
		return pet;
	}
	
	//@Autowired       //����setter������
	public void setPet(Animal pet) {
		this.pet=pet;
	}
}
