package com.ruoyi.project.domain;

/**
 * @author Maxj
 */
public class StuAndCou {

    /**
     * id
     */
    private long curriculaId;

    /**
     * 学生学号
     */
    private long studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 课程号
     */
    private long courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 职工号
     */
    private long teacherId;

    /**
     * 职工姓名
     */
    private String teacherName;

    /**
     * 成绩
     */
    private double score;

    /**
     * 状态
     * 1：有 2：无
     */
    private int state;

    public long getCurriculaId() {
        return curriculaId;
    }

    public void setCurriculaId(long curriculaId) {
        this.curriculaId = curriculaId;
    }

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StuAndCou{" +
                "curriculaId=" + curriculaId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", score=" + score +
                ", state=" + state +
                '}';
    }
}
