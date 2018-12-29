package Java“˛ Ω≈‰÷√;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Bean.Animal;
import Bean.Family;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class JunitTest {
	@Autowired(required=false)
	@Qualifier("smart")
	private Animal animal;
	
	@Autowired
	private Family family;
	@Test
	public void Test() {
		animal.function();
	}
	@Test
	public void Test1() {
		family.getPet().function();
	}
}
