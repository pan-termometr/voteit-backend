package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.Tag;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;

class VoteitAssemblerTest {

    @Test
    void shouldAssemblerVoteit() {
        // given
        final VoteitEntity voteitEntity = onetVoteitEntity();

        // when
        final Voteit result = new VoteitAssembler().assemble(voteitEntity);

        // then
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
        assertThat(result.getTags()).extracting(
                Tag::getValue
        ).contains(
                voteitEntity.getTags().stream().findFirst().get().getName()
        );
    }
}
