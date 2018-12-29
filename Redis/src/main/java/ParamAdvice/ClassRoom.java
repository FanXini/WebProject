package ParamAdvice;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class ClassRoom {
	
	private List<Student> students;
	
	public  ClassRoom() {
		students=new ArrayList<>();

	}
	
	public void restTime() {
		for(int i=0;i<30;i++) {
			Student student=students.get((int)(Math.random()*49)+1);
			double j=Math.random();
			if(j<=0.5) {
				student.enterClassRoom(student.getSno());
			}
			else {
				student.outClassRoom(student.getSno());
			}
		}
	}

}
