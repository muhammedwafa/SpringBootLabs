package com.basiony.repository;

import com.basiony.modle.Course;
import com.basiony.modle.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// fixme use @Repository to mark this class
public interface CourseRepository extends CrudRepository<Course, String> {

// fixme no need to write public in the interface
    public List<Course> findByName(String name);
    public List<Course> findByDescription(String description);
    public List<Course> findByTopicId(String description); // find all courses that relates to specific topic.
    // fixme this will throw can't convert Topic to Course exception
    public List<Topic> getCourseByTopic(String topicId);
}
