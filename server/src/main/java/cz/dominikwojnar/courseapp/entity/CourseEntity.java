package cz.dominikwojnar.courseapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.observation.ObservationFilter;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_course",
//            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id",
//                    referencedColumnName = "id"))
//    private List<UserEntity> users;


    @ManyToMany(mappedBy = "courses", cascade = CascadeType.REMOVE)
    private List<UserEntity> users;

}
