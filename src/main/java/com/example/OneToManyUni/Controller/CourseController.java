package com.example.OneToManyUni.Controller;

import com.example.OneToManyUni.Entity.Course;
import com.example.OneToManyUni.Entity.Review;
import com.example.OneToManyUni.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return  courseService.Add(course);
    }
    @GetMapping("/getAll")
    public List<Course>getAll(){
    return courseService.getAll();
    }
    @GetMapping("/getById/{courseId}")
    public Optional<Course> getById(@PathVariable Long courseId){
        return courseService.getById(courseId);
    }
    @DeleteMapping("/deleteById/{courseId}")
    public void deleteById(@PathVariable Long courseId){
         courseService.deleteById(courseId);
    }
    @PutMapping("update/{CourseId}")
    public void updateCourse( @RequestBody Course course, @PathVariable Long courseId){
        courseService.updateCourse(course,courseId);
    }

}
