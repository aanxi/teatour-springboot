package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.UserMapper;
import cn.teatour.pojo.User;
import cn.teatour.pojo.UserExample;
import cn.teatour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService 实现类
 *
 * @author: @zj
 * @create: 2022-04-29-上午 9:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public void updatePassword(int id, String password) {
        User user = get(id);
        user.setPassword(password);
        userMapper.updateById(user);
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User get(String name, String password) {
        UserExample example = new UserExample();
        example.or().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(example);
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    @Override
    public boolean isExist(String name) {
        UserExample example = new UserExample();
        example.or().andNameEqualTo(name);
        List<User> result = userMapper.selectByExample(example);
        if (!result.isEmpty())
            return true;
        return false;
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
