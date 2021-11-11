package com.examplecourseapi.courseapi.services;

import com.examplecourseapi.courseapi.topics.TopicRepository;
import com.examplecourseapi.courseapi.topics.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServices {

    @Autowired
    private TopicRepository topicRepository;

    // Getting all Topics
    public List<Topics> getAllTopics() {
        // return topics;

        //With crud repository
        List<Topics> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    // Getting topics from specific id
    public Optional<Topics> getTopics(String id) {
        //return topics.stream().filter(t -> t.getId()==(id)).findFirst().get();

        // With crud repository
        return topicRepository.findById(id);
    }

    public void addTopics(Topics topics) {
        //this.topics.add(topics);

        // With crud repository
        topicRepository.save(topics);
    }

    public void updateTopics(String id, Topics topics) {
//        for(int i =0 ; i< this.topics.size(); i++)
//        {
//            Topics t = this.topics.get(i);
//            if(t.getId()==id)
//            {
//                this.topics.set(i, topics);
//                return;
//            }
//    }

        // With crud repository
        topicRepository.save(topics);

    }

    public void deletetopics(String id) {

//        topics.removeIf(t -> t.getId()==id);

        // With crud repository
        topicRepository.deleteById(id);
    }
}