package pl.maciejbadziak.voteitbackend.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    private Long id;
    private String name;
}
