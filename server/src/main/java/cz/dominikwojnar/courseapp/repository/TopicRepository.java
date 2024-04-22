package cz.dominikwojnar.courseapp.repository;

import cz.dominikwojnar.courseapp.dto.TopicDto;
import cz.dominikwojnar.courseapp.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {

//    List<TopicEntity> getAllTopics();
}
