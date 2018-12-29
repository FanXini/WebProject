package ParamAdvice;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import lombok.Data;


@Aspect
@Data
public class CountAspect {
	
	private Map<String, Integer> enterMap;
	
	private Map<String, Integer> outMap;
	@Pointcut("execution(** ParamAdvice.Student.enterClassRoom(String))&&args(sno)")
	public void enter(String sno) {
		
	}
	
	public CountAspect() {
		enterMap=new HashMap<>();
		outMap=new HashMap<>();
	}
	@After("enter(sno)")
	public void enterAction(String sno) {
		if(enterMap.containsKey(sno)) {
			enterMap.put(sno, enterMap.get(sno)+1);
		}
		else {
			enterMap.put(sno,1);
		}
		System.out.println("student:"+sno+"进入教室");
	}
	@After("execution(** ParamAdvice.Student.outClassRoom(String))"+"&&args(sno)")
	public void outAction(String sno) {
		if(outMap.containsKey(sno)) {
			outMap.put(sno, outMap.get(sno)+1);
		}
		else {
			outMap.put(sno,1);
		}
		System.out.println("student:"+sno+"出去教室");
	}
}
