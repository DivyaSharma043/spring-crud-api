package com.examplecourseapi.courseapi.services;

import com.examplecourseapi.courseapi.topics.CourseRepository;
import com.examplecourseapi.courseapi.topics.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {

    @Autowired
    private CourseRepository courseRepository;


    public List<Courses> getAllCourses(String topicId) {

        List<Courses> course = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(course::add);
        return course;
    }

    public Optional<Courses> getCourses(String id) {

        return courseRepository.findById(id);
    }

    public void addCourses(Courses course) {

        courseRepository.save(course);
    }

    public void updateCourses(Courses course) {

        courseRepository.save(course);

    }

    public void deleteCourses(String id) {

        courseRepository.deleteById(id);
    }


}
