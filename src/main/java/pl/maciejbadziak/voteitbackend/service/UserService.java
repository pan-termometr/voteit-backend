package pl.maciejbadziak.voteitbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.mapper.UserMapper;
import pl.maciejbadziak.voteitbackend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getAll() {
        return userMapper.usersToUserDtos(userRepository.findAll());
    }
}
