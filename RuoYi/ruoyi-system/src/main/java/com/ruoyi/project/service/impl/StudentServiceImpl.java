package com.ruoyi.project.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.domain.Student;
import com.ruoyi.project.mapper.StudentMapper;
import com.ruoyi.project.service.StudentService;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Maxj
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    /**
     * 删除学生信息
     * @param studentId
     * @return
     */
    @Override
    public int deleteStudent(String studentId) {
        Long[] userIds = Convert.toLongArray(studentId);
        for (Long userId : userIds)
        {
            checkUserAllowed(new SysUser(userId));
        }
        return studentMapper.deleteStudent(userIds);
    }

    /**
     * 删除与该学生相关的课程信息
     * @param studentId
     */
    @Override
    public void deleteStudent2(String studentId) {
        Long[] userIds = Convert.toLongArray(studentId);
        for (Long userId : userIds)
        {
            checkUserAllowed(new SysUser(userId));
        }
        studentMapper.deleteStudent2(userIds);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    /**
     * 查询学生信息
     * @param studentId
     * @param studentName
     * @param departmentId
     * @return
     */
    @Override
    public List<Map<String,Object>> selectStudent(long studentId, String studentName, long departmentId) {
        return studentMapper.selectStudent(studentId,studentName,departmentId);
    }

    @Override
    public Student selectStudentById(long studentId) {
        return studentMapper.selectStudentById(studentId);
    }


    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    public void checkUserAllowed(SysUser user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && user.isAdmin())
        {
            throw new BusinessException("不允许操作超级管理员用户");
        }
    }
}
