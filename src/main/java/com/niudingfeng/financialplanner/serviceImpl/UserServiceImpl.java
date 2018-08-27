package com.niudingfeng.financialplanner.serviceImpl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.niudingfeng.financialplanner.entity.User;
import com.niudingfeng.financialplanner.mapper.UserMapper;
import com.niudingfeng.financialplanner.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lin123
 * @since 2018-08-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
