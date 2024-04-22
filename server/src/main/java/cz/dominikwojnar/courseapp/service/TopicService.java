package cz.dominikwojnar.courseapp.service;

import cz.dominikwojnar.courseapp.dto.TopicDto;
import cz.dominikwojnar.courseapp.entity.TopicEntity;
import cz.dominikwojnar.courseapp.mapper.TopicDtoMapper;
import cz.dominikwojnar.courseapp.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public TopicEntity findById(Long topicId) {
        return topicRepository.findById(topicId).orElse(null);
    }

    public List<TopicDto> getAllTopics() {
        List<TopicEntity> topicEntity =  topicRepository.findAll();

        return topicEntity.stream()
                .map(TopicDtoMapper::maptoTopicDto)
                .collect(Collectors.toList());
    }

    // Example of using non-static method in a static context
    public static TopicEntity findXD(Long topicId) {
        // Create an instance of TopicService
        TopicService topicService = new TopicService();

        // Call the non-static method
        TopicEntity topic = topicService.findById(topicId);

        // Use the topic entity
        if (topic != null) {
            // Do something with the topic
        }

        return topic;
    }
}
