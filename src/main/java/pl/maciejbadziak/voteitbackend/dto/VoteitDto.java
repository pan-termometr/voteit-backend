package pl.maciejbadziak.voteitbackend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.entity.Tag;
import pl.maciejbadziak.voteitbackend.entity.User;

import java.time.LocalDateTime;
import java.util.Set;

@Component
@Data
public class VoteitDto {

    private Long id;
    private Set<Tag> tags;
    private String title;
    private String description;
    private String url;
    private String picture;
    private int voteUp;
    private int voteDown;
    private boolean isForAdult;
    private LocalDateTime creationDate;
    private User author;
}
