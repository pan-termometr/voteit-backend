package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;
import pl.maciejbadziak.voteitbackend.tag.domain.Tagname;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagAssembler {

    public List<Tag> assemble(final List<TagEntity> tags) {
        return tags.stream()
                .map(this::assemble)
                .collect(Collectors.toList());
    }

    public Tag assemble(final TagEntity tag) {
        if (tag == null) {
            return null;
        }
        return Tag.builder()
                .tagname(Tagname.of(tag.getTagname()))
                .build();
    }
}
