package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;
import pl.maciejbadziak.voteitbackend.voteit.domain.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VoteitAssembler {

    public List<Voteit> assemble(final List<VoteitEntity> voteits) {
        return voteits.stream()
                .map(this::assemble)
                .collect(Collectors.toList());
    }

    public Voteit assemble(final VoteitEntity voteit) {
        return Voteit.builder()
                .id(Id.of(voteit.getId()))
                .title(Title.of(voteit.getTitle()))
                .description(Description.of(voteit.getDescription()))
                .url(Url.of(voteit.getUrl()))
                .thumbnail(Thumbnail.of(voteit.getThumbnail()))
                .votesUp(Vote.of(voteit.getVotesUp()))
                .votesDown(Vote.of(voteit.getVotesDown()))
                .tags(mapToTag(voteit.getTags()))
                .isForAdultOnly(voteit.isForAdultOnly())
                .creator(Creator.of(voteit.getCreator().getUsername()))
                .creationDate(CreationDate.of(voteit.getCreationDate()))
                .build();
    }

    private Set<Tag> mapToTag(final Set<TagEntity> tags) {
        return tags.stream()
                .map(TagEntity::getName)
                .map(Tag::of)
                .collect(Collectors.toSet());
    }
}
