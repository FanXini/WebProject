package Redis;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.User;
import service.CollectService;

public class CollctSeriveTest extends BaseConfig{
	
	@Autowired
	private CollectService collectService;
	
	@Test
	public void Test() {
		List<User> list=collectService.getList("1");
		for(User user:list) {
			System.out.println(user);
		}
		List<User> list2=collectService.getList("1");
		for(User user:list2) {
			System.out.println(user);
		}
	}

}
