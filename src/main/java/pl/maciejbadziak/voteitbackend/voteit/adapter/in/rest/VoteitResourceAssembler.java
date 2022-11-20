package pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest.resources.VoteitResource;
import pl.maciejbadziak.voteitbackend.voteit.domain.Tag;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VoteitResourceAssembler {

    public List<VoteitResource> assemble(final List<Voteit> voteits) {
        return voteits.stream()
                .map(this::assemble)
                .collect(Collectors.toList());
    }
    public VoteitResource assemble(final Voteit voteit) {
        return VoteitResource.builder()
                .id(voteit.getId().getValue())
                .title(voteit.getTitle().getValue())
                .description(voteit.getDescription().getValue())
                .url(voteit.getUrl().getValue())
                .thumbnail(voteit.getThumbnail().getValue())
                .votesUp(voteit.getVotesUp().getValue())
                .votesDown(voteit.getVotesDown().getValue())
                .tags(assembleTags(voteit.getTags()))
                .isForAdultOnly(voteit.isForAdultOnly())
                .creator(voteit.getCreator().getValue())
                .creationDate(voteit.getCreationDate().getValue())
                .build();
    }

    private Set<String> assembleTags(Set<Tag> tags) {
        return tags.stream()
                .map(Tag::getValue)
                .collect(Collectors.toSet());
    }
}
