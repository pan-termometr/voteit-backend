package pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest.resources.VoteitResource;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;
import pl.maciejbadziak.voteitbackend.voteit.usecase.FindAllVoteitsUseCase;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitResourceTestData.adsVoteitResource;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitResourceTestData.onetVoteitResource;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.adsVoteit;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitTestData.onetVoteit;

@ExtendWith(MockitoExtension.class)
class VoteitRestControllerTest {

    @Mock
    private transient VoteitResourceAssembler voteitResourceAssembler;

    @Mock
    private transient FindAllVoteitsUseCase findAllVoteitsUseCase;

    @InjectMocks
    private transient VoteitRestController voteitRestController;

    @Test
    void shouldProvideAllVoteits() {
        // given
        final List<Voteit> voteits = of(onetVoteit(), adsVoteit());
        final List<VoteitResource> voteitResources = of(onetVoteitResource(), adsVoteitResource());

        when(findAllVoteitsUseCase.allVoteits()).thenReturn(voteits);
        when(voteitResourceAssembler.assemble(voteits)).thenReturn(voteitResources);

        // when
        final List<VoteitResource> result = voteitRestController.allVoteits();

        // then
        assertThat(result).isEqualTo(voteitResources);
        verify(findAllVoteitsUseCase, times(1)).allVoteits();
        verify(voteitResourceAssembler, times(1)).assemble(voteits);
    }
}
