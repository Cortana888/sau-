package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.Course;
import com.ruoyi.project.domain.Student;
import com.ruoyi.project.domain.Teacher;
import com.ruoyi.project.service.CourseService;
import com.ruoyi.project.service.StudentService;
import com.ruoyi.project.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Maxj
 */
@Controller
@Api("课程信息管理")
@RequestMapping("/project/course")
public class CourseController extends BaseController {

    private String prefix = "project/course";

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;


    @GetMapping()
    public String role()
    {
        return prefix + "/course";
    }

    /**
     * 新增角色
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 添加课程信息
     * @param course
     * @return
     */
    @PostMapping("/addCourse")
    @ApiOperation(value = "添加课程信息")
    @ResponseBody
    public AjaxResult addCourse(Course course){
        Teacher teacher = teacherService.selectTeacherById(course.getTeacherId());
        if(teacher == null){
            return AjaxResult.warn("教师信息不存在");
        }
        course.setTeacherName(teacher.getTeacherName());
        int Count = courseService.addCourse(course);
        if(Count > 0){
            return AjaxResult.success("添加课程信息成功");
        }
        return AjaxResult.warn("添加课程信息失败");
    }

    @PostMapping("/deleteCourse")
    @ApiOperation(value = "删除课程信息")
    @Transactional
    @ResponseBody
    public AjaxResult deleteCourse(@RequestParam(value = "ids") String courseId){
        int Count = courseService.deleteCourse(courseId);
        courseService.deleteCourse2(courseId);
        if(Count > 0){
            return AjaxResult.success("删除课程信息成功");
        }
        return AjaxResult.warn("删除课程信息失败");
    }


    /**
     * 修改角色
     */
    @GetMapping("/edit/{courseId}")
    public String edit(@PathVariable("courseId") Long courseId, ModelMap mmap)
    {
        mmap.put("course", courseService.selectCourseById(courseId));
        return prefix + "/edit";
    }



    @PostMapping("/updateCourse")
    @ApiOperation(value = "修改课程信息")
    @ResponseBody
    public AjaxResult updateCourse(Course course){
        int Count = courseService.updateCourse(course);
        if(Count > 0){
            return AjaxResult.success("修改课程信息成功");
        }
        return AjaxResult.warn("修改课程信息失败");
    }

    @PostMapping("/selectCourse")
    @ApiOperation(value = "查找课程信息")
    @ResponseBody
    public TableDataInfo selectCourse(@RequestParam(value = "courseId",defaultValue = "0")long courseId,
                                       @RequestParam(value = "courseName",defaultValue = "") String courseName,
                                       @RequestParam(value = "teacherName",defaultValue = "") String teacherName){
        startPage();
        List<Map<String,Object>> list = courseService.selectCourse(courseId,courseName,teacherName);
        return getDataTable(list);
    }
}
