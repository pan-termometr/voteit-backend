package pl.maciejbadziak.voteitbackend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.service.TagService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.testdata.dto.TagDtoTestData.getPoliticsTagDto;
import static pl.maciejbadziak.voteitbackend.testdata.dto.TagDtoTestData.getTravelTagDto;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TagController.class})
class TagControllerTest {

    @Mock
    private TagService tagServiceMock;
    @InjectMocks
    private TagController tagController;

    @Test
    void shouldGetAllTags() {
        // given
        List<TagDto> tagDtos = List.of(getPoliticsTagDto(), getTravelTagDto());
        when(tagServiceMock.getAll()).thenReturn(tagDtos);

        // when
        ResponseEntity<List<TagDto>> result = tagController.getAllTags();

        // then
        assertEquals(tagDtos, result.getBody());
        verify(tagServiceMock, times(1)).getAll();
    }
}
