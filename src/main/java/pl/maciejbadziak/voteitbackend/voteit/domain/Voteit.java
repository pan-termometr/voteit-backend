package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
@EqualsAndHashCode
public final class Voteit {

    private final Id id;
    private final Title title;
    private final Description description;
    private final Url url;
    private final Thumbnail thumbnail;
    private final Vote votesUp;
    private final Vote votesDown;
    private final Set<Tag> tags;
    private final boolean isForAdultOnly;
    private final Creator creator;
    private final CreationDate creationDate;
}
