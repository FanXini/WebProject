package serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import entity.User;
import service.CollectService;
import service.UserService;
@Service
public class CollectServiceImpl implements CollectService{

	@Autowired
	private UserService userService;
	@Override
	@Cacheable(value="collect",key="#page")
	public List<User> getList(String page) {
		List<User> list=new ArrayList<>();
		list.add(userService.getUserInfo("fanxin"));
		list.add(userService.getUserInfo("liushimei"));
		list.add(userService.getUserInfo("fannao"));
		System.out.println("≤È‘É");
		return list;
	}

	@Override
	public Map<String, User> getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
