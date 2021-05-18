package com.basiony.controller;

import com.basiony.modle.Course;
import com.basiony.service.CourseService;
import com.basiony.modle.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    //spring maps this request and get the return object and convert it to json automatically and return it to the
    // http request.

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses();
    }


    @GetMapping("/topics/{id}/courses/{courseId}")
    public Course getCourse(@PathVariable String id, @PathVariable String courseId) {
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicID}/courses/{courseId}", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicID) {
        course.setTopic(new Topic(topicID,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "",""));

        courseService.updateCourse(course);
    }


    @RequestMapping(value = "/courses/{id}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
