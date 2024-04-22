package cz.dominikwojnar.courseapp.dto.Course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.dominikwojnar.courseapp.dto.TopicDto;
import cz.dominikwojnar.courseapp.dto.User.UserDto;
import cz.dominikwojnar.courseapp.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;

    private TopicDto topic; // Change from Long topicId to TopicDto topic TYHIS FOR MAPPER

    @JsonIgnore
    private List<UserDto> users;
}
