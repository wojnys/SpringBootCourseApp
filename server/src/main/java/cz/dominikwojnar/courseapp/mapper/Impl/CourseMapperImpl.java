package cz.dominikwojnar.courseapp.mapper.Impl;

import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapperImpl implements Mapper<CourseEntity, CourseDto> {

    private ModelMapper modelMapper;

    public CourseMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDto mapTo(CourseEntity courseEntity) {
        return modelMapper.map(courseEntity, CourseDto.class);
    }

    @Override
    public CourseEntity mapFrom(CourseDto courseDto) {
        return modelMapper.map(courseDto, CourseEntity.class);
    }
}
