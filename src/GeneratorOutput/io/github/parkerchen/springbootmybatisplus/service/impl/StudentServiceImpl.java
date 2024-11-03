package io.github.parkerchen.springbootmybatisplus.service.impl;

import io.github.parkerchen.springbootmybatisplus.entity.Student;
import io.github.parkerchen.springbootmybatisplus.mapper.StudentMapper;
import io.github.parkerchen.springbootmybatisplus.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
