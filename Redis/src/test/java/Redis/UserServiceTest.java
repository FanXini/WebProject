package Redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entity.User;
import service.UserService;

public class UserServiceTest extends BaseConfig {
	@Autowired
	private UserService userService;
	
	 @Test
	    public void testGetUserInfo(){
	        String username = "fanxin";
	        // 第一次执行了方法体
	        userService.getUserInfo(username);

	        // 第二次没有执行方法体，直接从缓存中获取的
	        User userInfo = userService.getUserInfo(username);
	        System.out.println(userInfo); // User [id=565857, username=mengdee, age=20]
	    }
}
