package com.basiony.service;

import com.basiony.modle.Topic;
import com.basiony.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    //topic services class is by default singleton.

    @Autowired
    TopicRepository topicRepository;

    //get all topics
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add); //method reference to populate the list.
        return topics;
    }

    //get a topic by id
    public Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

    //add a topic
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }


    //update topic
    public void updateTopic(Topic topic, String id) {
        topicRepository.save(topic);
    }

    //remove specific topic.
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }


}
