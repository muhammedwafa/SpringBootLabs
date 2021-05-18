package com.basiony.modle;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "course_table")
public class Course {
    @Id()
    @Column(name ="courseId")
    private String courseId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String courseId, String name, String description, String topicId) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId,"","");
    }


}
