package cz.dominikwojnar.courseapp.mapper;


import cz.dominikwojnar.courseapp.dto.TopicDto;
import cz.dominikwojnar.courseapp.entity.TopicEntity;

public class TopicDtoMapper {
    public static TopicDto maptoTopicDto(TopicEntity topicEntity) {
        return new TopicDto(
                topicEntity.getId(),
                topicEntity.getName()
        );
    }

//    public static TopicEntity mapToTopic(TopicDto topicDto) {
//       return new TopicEntity(
//               topicDto.getId(),
//               topicDto.getName(),
//               null
//       );
//    }
}
