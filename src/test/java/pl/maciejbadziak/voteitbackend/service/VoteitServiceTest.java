package pl.maciejbadziak.voteitbackend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.entity.Voteit;
import pl.maciejbadziak.voteitbackend.mapper.VoteitMapper;
import pl.maciejbadziak.voteitbackend.repository.VoteitRepository;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.testdata.dto.VoteitDtoTestData.getAdsVoteitDto;
import static pl.maciejbadziak.voteitbackend.testdata.dto.VoteitDtoTestData.getOnetVoteitDto;
import static pl.maciejbadziak.voteitbackend.testdata.entity.VoteitTestData.getAdsVoteit;
import static pl.maciejbadziak.voteitbackend.testdata.entity.VoteitTestData.getOnetVoteit;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {VoteitService.class})
class VoteitServiceTest {

    @Mock
    private VoteitRepository voteitRepositoryMock;
    @Mock
    private VoteitMapper voteitMapperMock;
    @InjectMocks
    private VoteitService voteitService;

    @Test
    void shouldReturnAllVoteits() {
        // given
        Set<Voteit> voteits = Set.of(getOnetVoteit(), getAdsVoteit());
        List<VoteitDto> voteitDtos = List.of(getAdsVoteitDto(), getOnetVoteitDto());
        when(voteitRepositoryMock.findAll()).thenReturn(voteits);
        when(voteitMapperMock.voteitsToVoteitDtos(voteits)).thenReturn(voteitDtos);

        // when
        List<VoteitDto> result = voteitService.getAll();

        // then
        assertEquals(voteitDtos, result);
        verify(voteitRepositoryMock, times(1)).findAll();
        verify(voteitMapperMock, times(1)).voteitsToVoteitDtos(voteits);
    }
}
