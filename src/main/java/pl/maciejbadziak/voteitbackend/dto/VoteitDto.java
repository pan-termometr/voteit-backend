package pl.maciejbadziak.voteitbackend.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteitDto {

    private Long id;
    private Set<String> tags;
    private String title;
    private String description;
    private String url;
    private String thumbnail;
    private int votesUp;
    private int votesDown;
    private boolean isForAdult;
    private LocalDateTime creationDate;
    private String author;
}
