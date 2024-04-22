package cz.dominikwojnar.courseapp.service;

import cz.dominikwojnar.courseapp.entity.UserEntity;
import cz.dominikwojnar.courseapp.exception.Course.CourseNotFoundException;
import cz.dominikwojnar.courseapp.exception.User.UserNotFoundException;
import cz.dominikwojnar.courseapp.repository.CourseRepository;
import cz.dominikwojnar.courseapp.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(id);
    }
}
