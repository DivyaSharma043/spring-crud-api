package com.examplecourseapi.courseapi.topics;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Courses, String> {

    public List<Courses> findByTopicId(String topicId);
}
