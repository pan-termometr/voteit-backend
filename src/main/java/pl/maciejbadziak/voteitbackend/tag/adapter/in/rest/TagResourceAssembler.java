package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.resources.TagResource;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagResourceAssembler {

    public List<TagResource> assemble(final List<Tag> tags) {
        return tags.stream()
                .map(this::assemble)
                .collect(Collectors.toList());
    }

    public TagResource assemble(final Tag tag) {
        if (tag == null) {
            return null;
        }
        return TagResource.builder()
                .tagname(tag.getTagname().getValue())
                .build();
    }
}
