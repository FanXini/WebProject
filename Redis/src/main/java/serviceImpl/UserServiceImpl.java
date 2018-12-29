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
        System.out.println("�����ݿ��в�ѯ�û���Ϣ������");
        long id = (int)((Math.random()*9+1)*100000);

        return new User(id, username, 20);
    }

    @CacheEvict("users")
    @Override
    public void deleteUser(String username) {
        System.out.println("ɾ���û���"+username);
    }

    // ʹ��@CachePut������Ҫ����Ķ���ʹ��value��Ϊ����ǰ׺��users����ʹ��ð����Ϊ�ָ�����������ʹ��key��ֵ׷�ӵ�ǰ�����ϣ���"users:mengdee"
    // �����ķ���ֵ��Ϊ��ֵ�Ե�ֵ�����������������û�з���ֵ����ô���൱��û�и��»���
    @CachePut(value="users", key="#user.getUsername()")
    @Override
    public User updateUser(User user) {
        System.out.println("�����û�");

        return user;
    }

}

