package cz.dominikwojnar.courseapp.service;

import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.exception.Course.CourseNotFoundException;
import cz.dominikwojnar.courseapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void saveCourse(CourseEntity course) {
        courseRepository.save(course);
    }

    // new tutorial
    public CourseEntity createCourse(CourseEntity course) {
        return courseRepository.save(course);
    }
    // new tutorial
    public CourseEntity getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }
    public List<CourseEntity> findAllCourses() {
        List<CourseEntity> coursesEntity =  courseRepository.findAll();
        return coursesEntity;
    }

    public void updateCourse(CourseEntity newCourse, Long id) {
        courseRepository.findById(id)
                .map(course -> {
                    course.setDescription(newCourse.getDescription());
                    course.setName(newCourse.getName());
                    course.setPrice(newCourse.getPrice());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new CourseNotFoundException(id));
    }
}
