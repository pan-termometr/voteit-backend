package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@JsonInclude(NON_EMPTY)
public class TagResource {

    private final String tagname;
}
