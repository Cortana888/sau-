package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.Student;
import com.ruoyi.project.service.StudentService;
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
@Api("学生选课")
@RequestMapping("/project/stuandcou")
public class StudentControllerController extends BaseController {

    private String prefix = "project/stuandcou";

    @Autowired
    private StudentService studentService;


    @GetMapping("/optional")
    public String optional()
    {
        return prefix + "/optional";
    }

    @GetMapping("/selected")
    public String selected()
    {
        return prefix + "/selected";
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
     * 添加学生信息
     * @param student
     * @return
     */
    @PostMapping("/addStudent")
    @ApiOperation(value = "添加学生信息")
    @ResponseBody
    public AjaxResult addStudent(Student student){
        int Count = studentService.addStudent(student);
        if(Count > 0){
            return AjaxResult.success("添加学生信息成功");
        }
        return AjaxResult.warn("添加学生信息失败");
    }

    @PostMapping("/deleteStudent")
    @ApiOperation(value = "删除学生信息")
    @Transactional
    @ResponseBody
    public AjaxResult deleteStudent(@RequestParam(value = "ids") String studentId){
        int Count = studentService.deleteStudent(studentId);
        studentService.deleteStudent2(studentId);
        if(Count > 0){
            return AjaxResult.success("删除学生信息成功");
        }
        return AjaxResult.warn("删除学生信息失败");
    }


    /**
     * 修改角色
     */
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") Long studentId, ModelMap mmap)
    {
        mmap.put("student", studentService.selectStudentById(studentId));
        return prefix + "/edit";
    }



    @PostMapping("/updateStudent")
    @ApiOperation(value = "修改学生信息")
    @ResponseBody
    public AjaxResult updateStudent(Student student){
        int Count = studentService.updateStudent(student);
        if(Count > 0){
            return AjaxResult.success("修改学生信息成功");
        }
        return AjaxResult.warn("修改学生信息失败");
    }
    //@RequiresPermissions("system:role:view")
    @PostMapping("/selectStudent")
    @ApiOperation(value = "查找学生信息")
    @ResponseBody
    public TableDataInfo selectStudent(@RequestParam(value = "studentId",defaultValue = "0")long studentId,
                                       @RequestParam(value = "studentName",defaultValue = "") String studentName,
                                       @RequestParam(value = "departmentId",defaultValue = "0") long departmentId){
        //PageHelper.startPage(pageNum,pageSize);
        startPage();
        List<Map<String,Object>> list = studentService.selectStudent(studentId,studentName,departmentId);
        //PageInfo pageResult = new PageInfo(list);
        //return AjaxResult.success(pageResult);
        return getDataTable(list);
    }
}
