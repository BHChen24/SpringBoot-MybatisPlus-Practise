package io.github.parkerchen.springbootmybatisplus;

import io.github.parkerchen.springbootmybatisplus.entity.User;
import io.github.parkerchen.springbootmybatisplus.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    void testInsert() {
        long now = Instant.now().toEpochMilli();
        User user = User.builder().name("Parker").age(18).email("myemail@test.com").createTime(now).updateTime(now).build();
        mapper.insert(user);
    }

}
