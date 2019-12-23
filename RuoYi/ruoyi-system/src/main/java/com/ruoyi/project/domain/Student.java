package com.ruoyi.project.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 学生基本信息类
 * @author Maxj
 */
public class Student {

    /**
     * 学生学号
     */
    private long studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别
     * (1：男 2：女 3：未知)
     */
    private int studentSex;

    /**
     * 出生日期
     */
    private String studentBirthday;

    /**
     * 入学成绩
     */
    private  double studentGrade;

    /**
     * 所在系号
     */
    private long departmentId;

    /**
     * 状态
     * 1：有 2：无
     */
    private int state;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(int studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
