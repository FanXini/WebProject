package XMLœ‘ Ω≈‰÷√;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Bean.Animal;
import Bean.Family;
import Bean.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class JunitTest {
	
	@Autowired 
	private ApplicationContext context;
	
	
	
	@Test
	public void test() {
		Family family=(Family) context.getBean("family");
		family.getPet().function();
		Family family1=(Family) context.getBean("family1");
		family1.getPet().function();
		Family family2=(Family) context.getBean("family2");
		family2.getPet().function();
		System.out.println(family.getPet().toString()+" "+family1.getPet().toString());
	}
	
	@Test
	public void test1() {		
		Person fanxin=(Person) context.getBean("lucy");
		System.out.println(fanxin.getName()+" "+fanxin.getAge());
		Person Zero=(Person) context.getBean("Zero");		
		System.out.println(Zero.getName()+" "+Zero.getAge());
		Person MLXG=(Person) context.getBean("MLXG");		
		System.out.println(MLXG.getName()+" "+MLXG.getAge());
		Person white=(Person) context.getBean("White");		
		System.out.println(white.getName()+" "+white.getAge());
		for(Animal pets:white.getPetList()) {
			pets.sound();
		}
		Person jklove=(Person) context.getBean("jklove");		
		System.out.println(jklove.getName()+" "+jklove.getAge());
		for(Animal pets:jklove.getPetList()) {
			pets.sound();
		}
	}
}
