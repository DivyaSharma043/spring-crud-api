package com.examplecourseapi.courseapi.controller;


import com.examplecourseapi.courseapi.services.TopicServices;
import com.examplecourseapi.courseapi.topics.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicServices topicServices;

    @RequestMapping("/topics")
    public List<Topics> getAllTopics()
    {
        return topicServices.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Optional<Topics> getTopics(@PathVariable String id)
    {
        return
                topicServices.getTopics(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopics(@RequestBody Topics topics)
    {
        topicServices.addTopics(topics);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopics(@RequestBody Topics topics, @PathVariable String id)
    {
        topicServices.updateTopics(id, topics);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopics(@PathVariable String id)
    {
        topicServices.deletetopics(id);
    }
}
