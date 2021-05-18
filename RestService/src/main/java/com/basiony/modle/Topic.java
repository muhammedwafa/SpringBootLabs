package com.basiony.modle;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "topic_table")
public class Topic {
    @Id()
    @Column(name = "topicId")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Topic() {
    }
    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
