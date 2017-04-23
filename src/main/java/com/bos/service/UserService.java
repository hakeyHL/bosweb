package com.bos.service;

import com.bos.mapper.UserMapper;
import com.bos.model.User;
import com.bos.model.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linux on 2017年04月23日.
 * Time 16:59
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名查询
     *
     * @return
     */
    public User getUserByName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public int saveUser(User user) {
        return userMapper.insert(user);
    }
}
