package bitcamp.myapp.service;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

    private UserDao userDao;

    public DefaultUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void add(User user) throws Exception {
        userDao.insert(user);
    }

    public List<User> list() throws Exception {
        return userDao.list();
    }

    public User get(int userNo) throws Exception {
        return userDao.findBy(userNo);
    }

    public User exists(String email, String password) throws Exception {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Transactional
    public boolean update(User user) throws Exception {
        return userDao.update(user);
    }

    @Transactional
    public boolean delete(int userNo) throws Exception {
        // if (userNo != 0) {
        //     throw new Exception("test1");
        // }
        return userDao.delete(userNo);
    }
}
