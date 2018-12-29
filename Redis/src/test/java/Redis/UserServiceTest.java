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
	        // ��һ��ִ���˷�����
	        userService.getUserInfo(username);

	        // �ڶ���û��ִ�з����壬ֱ�Ӵӻ����л�ȡ��
	        User userInfo = userService.getUserInfo(username);
	        System.out.println(userInfo); // User [id=565857, username=mengdee, age=20]
	    }
}
