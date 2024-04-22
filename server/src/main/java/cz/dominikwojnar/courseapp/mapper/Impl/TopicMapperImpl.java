package cz.dominikwojnar.courseapp.mapper.Impl;

import cz.dominikwojnar.courseapp.dto.TopicDto;
import cz.dominikwojnar.courseapp.entity.TopicEntity;
import cz.dominikwojnar.courseapp.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TopicMapperImpl implements Mapper<TopicEntity, TopicDto> {

    private ModelMapper modelMapper;

    public TopicMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TopicDto mapTo(TopicEntity topicEntity) {
        return modelMapper.map(topicEntity, TopicDto.class);
    }

    @Override
    public TopicEntity mapFrom(TopicDto topicDto) {
        return modelMapper.map(topicDto, TopicEntity.class);
    }
}
