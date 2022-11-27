package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;
import pl.maciejbadziak.voteitbackend.voteit.domain.Tag;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.adsVoteitEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;

class VoteitAssemblerTest {

    @Test
    void shouldAssemblerVoteit() {
        // given
        final VoteitEntity voteitEntity = onetVoteitEntity();

        // when
        final Voteit result = new VoteitAssembler().assemble(voteitEntity);

        // then
        assertThat(result.getThumbnail()).isNotNull();
        assertThat(result).extracting(
                voteit -> result.getId().getValue(),
                voteit -> result.getTitle().getValue(),
                voteit -> result.getDescription().getValue(),
                voteit -> result.getUrl().getValue(),
                voteit -> result.getThumbnail().getValue(),
                voteit -> result.getVotesUp().getValue(),
                voteit -> result.getVotesDown().getValue(),
                voteit -> result.isForAdultOnly(),
                voteit -> result.getCreator().getValue(),
                voteit -> result.getCreationDate().getValue()
        ).containsExactly(
                voteitEntity.getId(),
                voteitEntity.getTitle(),
                voteitEntity.getDescription(),
                voteitEntity.getUrl(),
                voteitEntity.getThumbnail(),
                voteitEntity.getVotesUp(),
                voteitEntity.getVotesDown(),
                voteitEntity.isForAdultOnly(),
                voteitEntity.getCreator().getUsername(),
                voteitEntity.getCreationDate()
        );
        assertTags(result.getTags(), voteitEntity.getTags());
    }

    @Test
    void shouldAssemblerVoteits() {
        // given
        final List<VoteitEntity> voteitEntities = of(onetVoteitEntity(), adsVoteitEntity());

        // when
        final List<Voteit> result = new VoteitAssembler().assemble(voteitEntities);

        // then
        assertThat(result).hasSameSizeAs(voteitEntities);
    }

    @Test
    void shouldReturnNullForNullableEntity() {
        // given
        // when
        final Voteit result = new VoteitAssembler().assemble((VoteitEntity) null);

        // then
        assertThat(result).isNull();
    }

    private void assertTags(final Set<Tag> resultTags, final Set<TagEntity> expectedTags) {
        final Optional<TagEntity> expectedTagEntity = expectedTags.stream().findAny();

        assertThat(expectedTagEntity).isPresent();
        assertThat(resultTags).extracting(
                Tag::getValue
        ).contains(
                expectedTagEntity.get().getTagname()
        );
    }
}
