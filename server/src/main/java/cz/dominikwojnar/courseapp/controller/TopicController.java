package cz.dominikwojnar.courseapp.controller;


import cz.dominikwojnar.courseapp.dto.TopicDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.entity.TopicEntity;
import cz.dominikwojnar.courseapp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topic")
    List<TopicDto> getAllCourses() {
        return topicService.getAllTopics();
    }
}
