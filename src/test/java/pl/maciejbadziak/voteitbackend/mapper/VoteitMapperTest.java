package pl.maciejbadziak.voteitbackend.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static pl.maciejbadziak.voteitbackend.asserts.VoteitDtoAssert.assertThat;
import static pl.maciejbadziak.voteitbackend.testdata.entity.VoteitTestData.getAdsVoteit;
import static pl.maciejbadziak.voteitbackend.testdata.entity.VoteitTestData.getOnetVoteit;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = VoteitMapperImpl.class)
class VoteitMapperTest {

    @Autowired
    private VoteitMapper voteitMapper;

    @Test
    void shouldMapToNullForNullVoteit() {
        // given
        // when
        VoteitDto result = voteitMapper.voteitToVoteitDto(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldMapVoteitToVoteitDto() {
        // given
        Voteit voteit = getAdsVoteit();

        // when
        VoteitDto result = voteitMapper.voteitToVoteitDto(voteit);

        // then
        assertThat(result)
                .hasId(voteit.getId())
                .hasTagsSize(voteit.getTags().size())
                .hasTitle(voteit.getTitle())
                .hasDescription(voteit.getDescription())
                .hasUrl(voteit.getUrl())
                .hasThumbnail(voteit.getThumbnail())
                .hasVotesUp(voteit.getVotesUp())
                .hasVotesDown(voteit.getVotesDown())
                .isForAdult(voteit.isForAdult())
                .hasCreationDate(voteit.getCreationDate())
                .hasAuthor(voteit.getAuthor().getId());
    }

    @Test
    void shouldMapToNullForNullVoteits() {
        // given
        // when
        List<VoteitDto> result = voteitMapper.voteitsToVoteitDtos(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldMapVoteitsToVoteitDtos() {
        // given
        Set<Voteit> voteits = Set.of(getAdsVoteit(), getOnetVoteit());

        // when
        List<VoteitDto> result = voteitMapper.voteitsToVoteitDtos(voteits);

        // then
        assertEquals(2, result.size());
    }
}
