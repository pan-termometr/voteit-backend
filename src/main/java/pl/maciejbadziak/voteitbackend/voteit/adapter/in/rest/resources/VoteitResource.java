package pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@JsonInclude(NON_EMPTY)
public class VoteitResource {

    private final Long id;
    private final String title;
    private final String description;
    private final String url;
    private final String thumbnail;
    private final int votesUp;
    private final int votesDown;
    private final Set<String> tags;
    private final boolean isForAdultOnly;
    private final String creator;
    private final LocalDateTime creationDate;
}
