package cz.dominikwojnar.courseapp.mapper.Impl;

import cz.dominikwojnar.courseapp.dto.User.UserDto;
import cz.dominikwojnar.courseapp.entity.UserEntity;
import cz.dominikwojnar.courseapp.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity mapFrom(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
