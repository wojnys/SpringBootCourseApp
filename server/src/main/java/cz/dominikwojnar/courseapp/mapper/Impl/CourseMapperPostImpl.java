package cz.dominikwojnar.courseapp.mapper.Impl;

import cz.dominikwojnar.courseapp.dto.Course.CourseDto;
import cz.dominikwojnar.courseapp.dto.Course.CoursePostDto;
import cz.dominikwojnar.courseapp.entity.CourseEntity;
import cz.dominikwojnar.courseapp.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapperPostImpl implements Mapper<CourseEntity, CoursePostDto> {

    private ModelMapper modelMapper;

    public CourseMapperPostImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CoursePostDto mapTo(CourseEntity courseEntity) {
        return modelMapper.map(courseEntity, CoursePostDto.class);
    }

    @Override
    public CourseEntity mapFrom(CoursePostDto coursePostDto) {
        return modelMapper.map(coursePostDto, CourseEntity.class);
    }
}
