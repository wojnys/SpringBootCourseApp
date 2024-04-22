package cz.dominikwojnar.courseapp.dto.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursePostDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Long topicId;
}
