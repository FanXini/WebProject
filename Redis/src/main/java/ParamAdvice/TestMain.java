package ParamAdvice;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ParamAdviceConfig.class)
public class TestMain {
	@Autowired
	private ClassRoom classRoom;
	@Autowired
	private CountAspect aspect;
	
	@Autowired
	@Qualifier("snoStudent")
	private Student student;
	
	@Test
	public void Test(){
		classRoom.restTime();
		System.out.println("*******************进入次数统计******************");
		for(Map.Entry<String, Integer> entry:aspect.getEnterMap().entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("*******************出去次数统计******************");
		for(Map.Entry<String, Integer> entry:aspect.getOutMap().entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}		
	}
	
	@Test
	public void Test1(){
		student.enterClassRoom(student.getSno());	
	}
}
