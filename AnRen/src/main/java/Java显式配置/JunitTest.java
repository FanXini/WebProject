package Javaœ‘ Ω≈‰÷√;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Bean.Vase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigCenter.class)
public class JunitTest {
	@Autowired
	Vase vase;
	@Test
	public void Test() {
		vase.getFlower().Smell();
	}
}
