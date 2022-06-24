package pl.maciejbadziak.voteitbackend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.entity.Tag;
import pl.maciejbadziak.voteitbackend.mapper.TagMapper;
import pl.maciejbadziak.voteitbackend.repository.TagRepository;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.testdata.dto.TagDtoTestData.getPoliticsTagDto;
import static pl.maciejbadziak.voteitbackend.testdata.dto.TagDtoTestData.getTravelTagDto;
import static pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData.getPoliticsTag;
import static pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData.getTravelTag;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TagService.class})
class TagServiceTest {

    @Mock
    private TagRepository tagRepositoryMock;
    @Mock
    private TagMapper tagMapperMock;
    @InjectMocks
    private TagService tagService;

    @Test
    void shouldReturnAllTags() {
        // given
        Set<Tag> tags = Set.of(getPoliticsTag(), getTravelTag());
        List<TagDto> tagDtos = List.of(getPoliticsTagDto(), getTravelTagDto());
        when(tagRepositoryMock.findAll()).thenReturn(tags);
        when(tagMapperMock.tagsToTagDtos(tags)).thenReturn(tagDtos);

        // when
        List<TagDto> result = tagService.getAll();

        // then
        assertEquals(tagDtos, result);
        verify(tagRepositoryMock, times(1)).findAll();
        verify(tagMapperMock, times(1)).tagsToTagDtos(tags);
    }
}
