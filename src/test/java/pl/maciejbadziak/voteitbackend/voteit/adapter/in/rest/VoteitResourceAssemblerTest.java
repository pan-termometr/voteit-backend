package pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest.resources.VoteitResource;
import pl.maciejbadziak.voteitbackend.voteit.domain.Tag;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.adsVoteit;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.onetVoteit;

class VoteitResourceAssemblerTest {

    @Test
    void shouldAssembleVoteit() {
        // given
        final Voteit voteit = onetVoteit();

        // when
        final VoteitResource result = new VoteitResourceAssembler().assemble(voteit);

        // then
        assertThat(voteit.getThumbnail()).isNotNull();
        assertThat(result).extracting(
                VoteitResource::getId,
                VoteitResource::getTitle,
                VoteitResource::getDescription,
                VoteitResource::getUrl,
                VoteitResource::getThumbnail,
                VoteitResource::getVotesUp,
                VoteitResource::getVotesDown,
                VoteitResource::isForAdultOnly,
                VoteitResource::getCreator,
                VoteitResource::getCreationDate
        ).containsExactly(
                voteit.getId().getValue(),
                voteit.getTitle().getValue(),
                voteit.getDescription().getValue(),
                voteit.getUrl().getValue(),
                voteit.getThumbnail().getValue(),
                voteit.getVotesUp().getValue(),
                voteit.getVotesDown().getValue(),
                voteit.isForAdultOnly(),
                voteit.getCreator().getValue(),
                voteit.getCreationDate().getValue()
        );
        assertTags(result.getTags(), voteit.getTags());
    }

    private void assertTags(Set<String> resultTags, Set<Tag> expectedTags) {
        final Optional<Tag> expectedTag = expectedTags.stream().findAny();

        assertThat(expectedTag).isPresent();
        assertThat(resultTags)
                .contains(expectedTag.get().getValue());
    }

    @Test
    void shouldAssembleVoteits() {
        // given
        final List<Voteit> voteits = of(onetVoteit(), adsVoteit());

        // when
        final List<VoteitResource> result = new VoteitResourceAssembler().assemble(voteits);

        // then
        assertThat(result).hasSameSizeAs(voteits);
    }

    @Test
    void shouldReturnNullForNullableVoteit() {
        // given
        // when
        final VoteitResource result = new VoteitResourceAssembler().assemble((Voteit) null);

        // then
        assertThat(result).isNull();
    }
}
