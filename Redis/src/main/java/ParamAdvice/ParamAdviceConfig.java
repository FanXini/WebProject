package ParamAdvice;

import static org.junit.Assert.assertArrayEquals;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses= {Student.class})
public class ParamAdviceConfig {

	@Bean
	public CountAspect countAspect() {
		return new CountAspect();
	}
	
	@Bean
	public ClassRoom classRoom() {
		ClassRoom classRoom= new ClassRoom();
		for(int i=0;i<50;i++) {
			classRoom.getStudents().add(studentFactory(String.valueOf(i)));
		}
		return classRoom;
		
	}
	
	@Bean
	@Scope("prototype")
	public Student studentFactory(String sno) {
		return new Student(sno);
	}
	
	@Bean
	@Qualifier("noSnoStudent")
	public Student noSnoStudent() {
		return new Student();
	}
	
	@Bean
	@Qualifier("snoStudent")
	public Student snoStudent() {
		String sno=String.valueOf((int)(Math.random()*100));
		return new Student(sno);
	}
}
