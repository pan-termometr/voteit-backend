package pl.maciejbadziak.voteitbackend.tag.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Tag {

    private final Tagname tagname;
}
