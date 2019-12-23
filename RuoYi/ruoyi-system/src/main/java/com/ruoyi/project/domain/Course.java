package com.ruoyi.project.domain;

/**
 * @author Maxj
 */
public class Course {

    /**
     * 课程号
     */
    private long courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 任课教师号
     */
    private long teacherId;

    /**
     * 任课教师姓名
     */
    private String teacherName;

    /**
     * 学时
     */
    private double courseTime;

    /**
     * 学分
     */
    private double coursePoint;

    /**
     * 状态
     */
    private int state;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public double getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(double courseTime) {
        this.courseTime = courseTime;
    }

    public double getCoursePoint() {
        return coursePoint;
    }

    public void setCoursePoint(double coursePoint) {
        this.coursePoint = coursePoint;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", courseTime=" + courseTime +
                ", coursePoint=" + coursePoint +
                ", state=" + state +
                '}';
    }
}
