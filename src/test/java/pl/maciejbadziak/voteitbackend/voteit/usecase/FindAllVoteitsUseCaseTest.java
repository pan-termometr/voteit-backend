package pl.maciejbadziak.voteitbackend.voteit.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;
import pl.maciejbadziak.voteitbackend.voteit.port.FindAllVoteitsPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.adsVoteit;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.onetVoteit;

@ExtendWith(MockitoExtension.class)
class FindAllVoteitsUseCaseTest {

    @Mock
    private transient FindAllVoteitsPort findAllVoteitsPortMock;

    @InjectMocks
    private transient FindAllVoteitsUseCase findAllVoteitsUseCase;

    @Test
    void shouldProvideAllVoteits() {
        // given
        final List<Voteit> voteits = List.of(onetVoteit(), adsVoteit());

        when(findAllVoteitsPortMock.findAll()).thenReturn(voteits);

        // when
        final List<Voteit> result = findAllVoteitsUseCase.allVoteits();

        // then
        assertThat(result).isEqualTo(voteits);
    }
}
