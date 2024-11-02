package io.github.parkerchen.springbootmybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.parkerchen.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
