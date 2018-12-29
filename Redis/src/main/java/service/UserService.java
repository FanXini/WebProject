package service;

import entity.User;

public interface UserService {
	public User getUserInfo(String username);

	public void deleteUser(String username);

	public User updateUser(User user);
}
