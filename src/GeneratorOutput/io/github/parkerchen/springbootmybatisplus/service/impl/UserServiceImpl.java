package io.github.parkerchen.springbootmybatisplus.service.impl;

import io.github.parkerchen.springbootmybatisplus.entity.User;
import io.github.parkerchen.springbootmybatisplus.mapper.UserMapper;
import io.github.parkerchen.springbootmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Parker Chen
 * @since 2024-11-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
