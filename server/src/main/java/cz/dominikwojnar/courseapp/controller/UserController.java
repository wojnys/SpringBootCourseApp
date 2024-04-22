package cz.dominikwojnar.courseapp.controller;

import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import cz.dominikwojnar.courseapp.dto.User.UserDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.entity.UserEntity;
import cz.dominikwojnar.courseapp.mapper.Mapper;
import cz.dominikwojnar.courseapp.service.CourseService;
import cz.dominikwojnar.courseapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private Mapper<UserEntity, UserDto> userMapper;

    @GetMapping("/user")
    ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserEntity> usersEntity = userService.findAllUsers();

        List<UserDto> usersDto = usersEntity.stream().map(userMapper::mapTo).toList();
        usersDto.forEach(user -> System.out.println(user.getFirstname()));
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with id: " + id);
        userService.deleteUserById(id);
        return new ResponseEntity<>("User was successfully deleted", HttpStatus.OK);
    }

}
