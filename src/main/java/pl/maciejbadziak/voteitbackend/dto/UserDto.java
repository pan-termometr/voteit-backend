package pl.maciejbadziak.voteitbackend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.HashSet;
import java.util.Set;

@Component
@Data
public class UserDto {

    final private Set<Voteit> voteits = new HashSet<>();
    private String username;
    private String email;
}
