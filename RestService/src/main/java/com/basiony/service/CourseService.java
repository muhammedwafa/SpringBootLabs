package com.basiony.service;

import com.basiony.modle.Course;
import com.basiony.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    //get all Courses
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add); //method reference to populate the list.
        return courses;
    }

    //get a Course by id
    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    //add a Course
    public void addCourse(Course course) {
        courseRepository.save(course);
    }


    //update Course
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    //remove specific Course.
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }


}
