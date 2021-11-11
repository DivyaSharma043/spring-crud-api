package com.examplecourseapi.courseapi.controller;

import com.examplecourseapi.courseapi.services.CourseServices;
import com.examplecourseapi.courseapi.topics.Courses;
import com.examplecourseapi.courseapi.topics.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @RequestMapping("/topics/{id}/courses")
    public List<Courses> getAllCourses(@PathVariable String id)
    {
        return courseServices.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Courses> getCourses(@PathVariable String id)
    {
        return
                courseServices.getCourses(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourses(@RequestBody Courses course, @PathVariable String topicId)
    {
        course.setTopics(new Topics(topicId,"",""));
        courseServices.addCourses(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourses(@RequestBody Courses course,@PathVariable String topicId, @PathVariable String id)
    {
        courseServices.updateCourses(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourses(@PathVariable String id)
    {
        courseServices.deleteCourses(id);
    }
}