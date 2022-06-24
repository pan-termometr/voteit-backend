package pl.maciejbadziak.voteitbackend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.service.VoteitService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.testdata.dto.VoteitDtoTestData.getAdsVoteitDto;
import static pl.maciejbadziak.voteitbackend.testdata.dto.VoteitDtoTestData.getOnetVoteitDto;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {VoteitController.class})
class VoteitControllerTest {

    @Mock
    private VoteitService voteitServiceMock;
    @InjectMocks
    private VoteitController voteitController;

    @Test
    void shouldGetAllVoteits() {
        // given
        List<VoteitDto> voteitDtos = List.of(getAdsVoteitDto(), getOnetVoteitDto());
        when(voteitServiceMock.getAll()).thenReturn(voteitDtos);

        // when
        ResponseEntity<List<VoteitDto>> result = voteitController.getAllVoteits();

        // then
        assertEquals(voteitDtos, result.getBody());
        verify(voteitServiceMock, times(1)).getAll();
    }
}
