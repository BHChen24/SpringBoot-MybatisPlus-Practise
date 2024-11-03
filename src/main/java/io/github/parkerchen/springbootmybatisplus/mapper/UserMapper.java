package io.github.parkerchen.springbootmybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.parkerchen.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where age > 18 and age != 100 or name like '%Parker%'")
    List<User> selectRaw();
}
