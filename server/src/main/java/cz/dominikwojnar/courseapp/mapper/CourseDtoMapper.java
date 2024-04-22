//package cz.dominikwojnar.courseapp.mapper;
//
//
//import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
//import cz.dominikwojnar.courseapp.entity.CourseEntity;
//import cz.dominikwojnar.courseapp.entity.TopicEntity;
//import cz.dominikwojnar.courseapp.service.TopicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CourseDtoMapper {
//
//    @Autowired
//    private TopicService topicService;
//
//    public static CourseDto maptoCourseDto(CourseEntity courseEntity) {
//
//
//        return new CourseDto(
//                courseEntity.getId(),
//                courseEntity.getName(),
//                courseEntity.getDescription(),
//                courseEntity.getPrice(),
//                null
////                courseEntity.getTopic().getId()
//        );
//    }
//
//    public static CourseEntity maptoCourseEntity(CourseDto courseDto, TopicEntity topicEntity) {
//        return new CourseEntity(
//                courseDto.getId(),
//                courseDto.getName(),
//                courseDto.getDescription(),
//                courseDto.getPrice(),
//                topicEntity,
//                null
//        );
//    }
//}
