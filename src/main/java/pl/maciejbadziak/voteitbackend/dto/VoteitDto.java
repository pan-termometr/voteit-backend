package pl.maciejbadziak.voteitbackend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.entity.Tag;
import pl.maciejbadziak.voteitbackend.entity.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
@Data
public class VoteitDto {

    final private Set<Tag> tags = new HashSet<>();
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
