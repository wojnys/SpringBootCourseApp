package cz.dominikwojnar.courseapp.mapper;

import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.entity.TopicEntity;
import cz.dominikwojnar.courseapp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import cz.dominikwojnar.courseapp.dto.Course.CoursePostDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.entity.TopicEntity;
import cz.dominikwojnar.courseapp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoursePostDtoMapper {
    @Autowired
    private TopicService topicService;

    public static CoursePostDto maptoCoursePostDto(CourseEntity courseEntity) {
        return new CoursePostDto(
                courseEntity.getId(),
                courseEntity.getName(),
                courseEntity.getDescription(),
                courseEntity.getPrice(),
                courseEntity.getTopic().getId()
        );
    }

    public static CourseEntity maptoCourseEntity(CoursePostDto coursePostDto, TopicEntity topicEntity) {
        return new CourseEntity(
                coursePostDto.getId(),
                coursePostDto.getName(),
                coursePostDto.getDescription(),
                coursePostDto.getPrice(),
                topicEntity,
                null
        );
    }
}
