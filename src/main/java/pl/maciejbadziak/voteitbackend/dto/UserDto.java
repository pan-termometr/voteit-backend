package pl.maciejbadziak.voteitbackend.dto;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDto {

    final private Set<Voteit> voteitList = new HashSet<>();
    private String user;
}
