package pl.maciejbadziak.voteitbackend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.Set;

@Component
@Data
public class UserDto {

    private Long id;
    private Set<Voteit> voteits;
    private String username;
    private String email;
}
