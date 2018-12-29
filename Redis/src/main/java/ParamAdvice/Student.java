package ParamAdvice;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data  //使用了lombok插件，自动配置get set方法
public class Student {
	
	private String sno;
	public Student() {
		
	}
	public Student(String sno) {
		this.sno=sno;
	}
	public void enterClassRoom(String sno) {
		System.out.println("学生："+sno+" 进入教室");
	}
	
	public void outClassRoom(String sno) {
		System.out.println("学生："+sno+" 出去教室");
	}

}
