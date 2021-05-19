package com.basiony.service;

import com.basiony.exceptions.NotFoundException;
import com.basiony.modle.Topic;
import com.basiony.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//todo use interface for services "IOC"
public class TopicService {
    //topic services class is by default singleton.

    @Autowired
    TopicRepository topicRepository;
    // todo use java docs instead of comments
    // for all methods
    //get all topics
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        // todo find all return a list
        // why do you create a new one to add all elements to new list
        topicRepository.findAll().forEach(topics::add); //method reference to populate the list.
        return topics;
    }

    //get a topic by id
    public Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

    //add a topic
    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }


    //update topic
    public Topic updateTopic(Topic topic, String id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()){
            //todo map new topic to save
            topicRepository.save(topic);
        }
        throw new NotFoundException("topic not founded");
    }

    //remove specific topic.
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }


}
