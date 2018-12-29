package serviceImpl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import entity.User;
import service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Cacheable("users")
    @Override
    public User getUserInfo(String username) {
        System.out.println("从数据库中查询用户信息。。。");
        long id = (int)((Math.random()*9+1)*100000);

        return new User(id, username, 20);
    }

    @CacheEvict("users")
    @Override
    public void deleteUser(String username) {
        System.out.println("删除用户："+username);
    }

    // 使用@CachePut比许返回要缓存的对象，使用value作为键的前缀（users），使用冒号作为分隔符（：），使用key的值追加到前面的组合，如"users:mengdee"
    // 方法的返回值作为键值对的值缓存起来，如果方法没有返回值，那么就相当于没有更新缓存
    @CachePut(value="users", key="#user.getUsername()")
    @Override
    public User updateUser(User user) {
        System.out.println("更新用户");

        return user;
    }

}

