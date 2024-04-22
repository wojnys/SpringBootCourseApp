package cz.dominikwojnar.courseapp.dto.User;



import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long phone;

    private List<CourseDto> courses;
}