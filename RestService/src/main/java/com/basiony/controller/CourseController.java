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
    // FIXME unused path variable
    // use a query to find all courses attached to specific topic
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses();
    }


    @GetMapping("/topics/{id}/courses/{courseId}")
    // FIXME unused path var courseId
    public Course getCourse(@PathVariable String id, @PathVariable String courseId) {
        return courseService.getCourse(id);
    }

    @PostMapping(value = "/topics/{topicID}/courses/{courseId}")
    // FIXME unused path var courseId
    // use ResponseEntity to return right http status code
    public void addCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicID) {
        course.setTopic(new Topic(topicID,"",""));
        courseService.addCourse(course);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{courseId}")
    // FIXME unused path var courseId
    // use ResponseEntity to return right http status code
    public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "",""));

        courseService.updateCourse(course);
    }

    // fixme use   @DeleteMapping
    @RequestMapping(value = "/courses/{id}",method = RequestMethod.DELETE)
    // use ResponseEntity to return right http status code
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
