package pl.maciejbadziak.voteitbackend.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.dto.VoteitDtoAssert;
import pl.maciejbadziak.voteitbackend.entity.Voteit;
import pl.maciejbadziak.voteitbackend.testdata.entity.VoteitTestData;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = VoteitMapperImpl.class)
public class VoteitMapperTest {

    @Autowired
    private VoteitMapper voteitMapper;

    @Test
    void should() {
        // given
        Voteit voteit = VoteitTestData.getVoteitOnet();

        // when
        VoteitDto result = voteitMapper.voteitToVoteitDto(voteit);

        // then
        VoteitDtoAssert.assertThat(result)
                .hasTitle(voteit.getTitle())
                .hasDescription(voteit.getDescription())
                .hasUrl(voteit.getUrl())
                .isNotForAdult();
    }
}
