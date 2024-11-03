package io.github.parkerchen.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.parkerchen.springbootmybatisplus.entity.User;
import io.github.parkerchen.springbootmybatisplus.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    // After implementing MetaObjectHandler, createTime and updateTime will be automatically filled
    void testInsertAutoTime() {
        User user = User.builder().name("Parker4").age(21).email("myemail22@test.com").build();
        mapper.insert(user);
    }

    @Test
    void testSelect() {
        User user = mapper.selectById(24);
        System.out.println(user.getName());
    }

    @Test
    // Changed createTime and updateTime to 0 (default value), because they are basic type in java
    void testUpdate() {
        User newUser = User.builder().id(24L).name("Parker Chen").build();
        mapper.updateById(newUser);
        mapper.selectById(24);
        System.out.println(mapper.selectById(24).getName());
    }

    @Test
    void testUpdateAutoTime() {
        User newUser = User.builder().id(26L).name("Parker0").build();
        mapper.updateById(newUser);
    }
    @Test
    void testDelete() {
        mapper.deleteById(24);
    }

    // QueryWrapper
    @Test
    void testQueryWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "er");
//        queryWrapper.between("age", 18, 30);
//        queryWrapper.eq("email", "myemail@test.com");
        String name = "Parker";
        // Query when condition is met
        queryWrapper.eq(StringUtils.isNotBlank(name), "name", name);

        queryWrapper.select("id", "name");
        List<User> users = mapper.selectList(queryWrapper);
        System.out.println(users.size());
    }
    @Test
    void testQueryWrapper2() {
        User user = User.builder().name("Parker Chen").age(18).build();
        // Directly use the entity object to create a QueryWrapper, apply eq to all non-null fields
        // Noticed that the createTime and updateTime are 0 if not set
        QueryWrapper<User> qw = new QueryWrapper<>(user);
        List<User> result = mapper.selectList(qw);
    }

    @Test
    void testQueryWrapper3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Parker Bigger");
        map.put("age", 28);
        map.put("email", null);
        // ignore null map
        queryWrapper.allEq(map, false);

        List<User> users = mapper.selectList(queryWrapper);
    }

    @Test
    void testLambda() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // Use User's method
        // Can pass a SQL like expression into it
        lambdaQueryWrapper.like(User::getName, "%er");
        lambdaQueryWrapper.between(User::getAge, 18, 30);

        List<User> resultList = mapper.selectList(lambdaQueryWrapper);
    }

    @Test
    void testUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.ge("age", 18);
        updateWrapper.set("name", "Parker Chen");
        mapper.update(updateWrapper);
    }

    @Test
    void testSelectRaw() {
        List<User> res = mapper.selectRaw();
        System.out.println(res);
    }

    @Test
    void testPageQuery() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ge(User::getAge, 10);

        Page page = new Page(1, 1);
        Page<User> userPage = mapper.selectPage(page, lambdaQueryWrapper);
        List<User> records = userPage.getRecords();
        long total = userPage.getTotal();
        System.out.println(records);
        System.out.println(total);
    }

    @Transactional
    void testVersion() {
        User user = mapper.selectById(27L);
        User doubleSelect = mapper.selectById(27L);

        user.setAge(20);
        doubleSelect.setAge(21);

        mapper.updateById(user);
        int count = mapper.updateById(doubleSelect);
        if (count == 0) {
            System.out.println("Update failed");
        } else {
            System.out.println("Update success");
        }
    }

    @Test
    // Optimistic lock, the second update will fail(counter == 0)
    void testVersionExecutor () {
        testVersion();
    }
}
