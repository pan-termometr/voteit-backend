package pl.maciejbadziak.voteitbackend.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.Set;

@Component
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private Set<Voteit> voteits;
    private String username;
    private String email;
}
