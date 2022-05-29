package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {VoteitMapper.class})
public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(Iterable<User> users);
}
