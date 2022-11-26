package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.adsVoteitEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.adsVoteit;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.onetVoteit;

@ExtendWith(MockitoExtension.class)
class VoteitJpaAdapterTest {

    @Mock
    private transient VoteitRepository voteitRepositoryMock;

    @Mock
    private transient VoteitAssembler voteitAssemblerMock;

    @InjectMocks
    private transient VoteitJpaAdapter voteitJpaAdapter;

    @Test
    void shouldProvideVoteits() {
        // given
        final List<VoteitEntity> givenVoteits = of(onetVoteitEntity(), adsVoteitEntity());
        final List<Voteit> expectedVoteits = of(onetVoteit(), adsVoteit());

        when(voteitRepositoryMock.findAll()).thenReturn(givenVoteits);
        when(voteitAssemblerMock.assemble(givenVoteits)).thenReturn(expectedVoteits);

        // when
        final List<Voteit> result = voteitJpaAdapter.findAll();

        // then
        assertThat(result).isEqualTo(expectedVoteits);
        verify(voteitRepositoryMock, times(1)).findAll();
        verify(voteitAssemblerMock, times(1)).assemble(givenVoteits);
    }
}
