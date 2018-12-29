package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import entity.User;

public interface CollectService {
	
	public List<User> getList(String page);
	
	public Map<String, User> getMap();
	
	public Set<User> getSet();

}
