package cz.dominikwojnar.courseapp.controller;

import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import cz.dominikwojnar.courseapp.dto.Course.CoursePostDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;

import cz.dominikwojnar.courseapp.mapper.CoursePostDtoMapper;
import cz.dominikwojnar.courseapp.mapper.Mapper;
import cz.dominikwojnar.courseapp.service.CourseService;
import cz.dominikwojnar.courseapp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private Mapper<CourseEntity, CourseDto> courseMapper;

    @Autowired
    private Mapper<CourseEntity, CoursePostDto> courseMapperPostDto;

    @Autowired
    private TopicService topicService;

    @PostMapping("/course")
    ResponseEntity<String> createCourse(@RequestBody CoursePostDto coursePostDto) {
        CourseEntity course = CoursePostDtoMapper.maptoCourseEntity(coursePostDto, topicService.findById(coursePostDto.getTopicId()));
        courseService.saveCourse(course);
        return new ResponseEntity<>("Was successfully created", HttpStatus.OK);
    }

    @GetMapping("/course")
    ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseEntity> coursesEntity = courseService.findAllCourses();
        List<CourseDto> coursesDto = coursesEntity.stream().map(courseMapper::mapTo).toList();
        return new ResponseEntity<>(coursesDto, HttpStatus.OK);
    }

    // with ampper tutorial
    @PostMapping("/course-tutorial")
    ResponseEntity<String> createCourseTutorial(@RequestBody CoursePostDto coursePostDto) {
        System.out.println(coursePostDto.getTopicId());
        CourseEntity course = courseMapperPostDto.mapFrom(coursePostDto);
        System.out.println(course.getTopic().getId());
        CourseEntity savedCourse = courseService.createCourse(course);

        courseMapperPostDto.mapTo(savedCourse);
        return new ResponseEntity<>("Was successfully created", HttpStatus.OK);
    }
    // with a mmaper tutorial
    @GetMapping("/course/{id}")
    ResponseEntity<CourseDto> getCourse(@PathVariable Long id) {
        CourseEntity course = courseService.getCourseById(id);
        CourseDto courseDto = courseMapper.mapTo(course);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }
    // with a mmaper tutorial
    @PutMapping("/course/{id}")
    ResponseEntity<String> updateCourse(@RequestBody CourseEntity newCourse, @PathVariable Long id) {
        courseService.updateCourse(newCourse, id);
        return new ResponseEntity<>("Was successfully edited", HttpStatus.OK);
    }
}
