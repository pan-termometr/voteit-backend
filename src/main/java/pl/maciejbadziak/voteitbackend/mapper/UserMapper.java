package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.entity.User;

@Mapper(uses = {VoteitMapper.class})
public interface UserMapper {

    UserDto userToUserDto(User user);
}
