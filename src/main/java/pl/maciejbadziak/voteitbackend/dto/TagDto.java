package pl.maciejbadziak.voteitbackend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TagDto {

    private Long id;
    private String name;
}
