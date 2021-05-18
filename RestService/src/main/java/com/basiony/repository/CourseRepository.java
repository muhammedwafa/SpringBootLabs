package com.basiony.repository;

import com.basiony.modle.Course;
import com.basiony.modle.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {


    public List<Course> findByName(String name);
    public List<Course> findByDescription(String description);
    public List<Course> findByTopicId(String description); // find all courses that relates to specific topic.

    public List<Topic> getCourseByTopic(String topicId);
}
