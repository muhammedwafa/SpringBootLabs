package com.basiony.controller;

import com.basiony.modle.Topic;
import com.basiony.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    //spring maps this request and get the return object and convert it to json automatically and return it to the
    // http request.

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }


    @GetMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable String id) {
        return ResponseEntity.ok( topicService.getTopic(id));
    }

    @PostMapping(value = "/topics")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
        topic = topicService.addTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(topic);
    }

    @PutMapping(value = "/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        Topic updateTopic = topicService.updateTopic(topic, id);
        return ResponseEntity.ok(updateTopic);
    }


    @DeleteMapping(value = "/topics/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
