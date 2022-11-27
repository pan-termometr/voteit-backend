package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.resources.TagResource;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;
import pl.maciejbadziak.voteitbackend.tag.usecase.FindAllTagsUseCase;

import java.util.List;

import static java.util.List.of;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagResourceTestData.newsTagResource;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagResourceTestData.travelTagResource;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.newsTag;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.travelTag;

@ExtendWith(MockitoExtension.class)
class TagRestControllerTest {

    @Mock
    private transient FindAllTagsUseCase findAllTagsUseCaseMock;

    @Mock
    private transient TagResourceAssembler tagResourceAssemblerMock;

    @InjectMocks
    private transient TagRestController tagRestController;

    @Test
    void shouldProvideAllTags() {
        // given
        final List<Tag> tags = of(newsTag(), travelTag());
        final List<TagResource> tagResources = of(newsTagResource(), travelTagResource());

        when(findAllTagsUseCaseMock.allTags()).thenReturn(tags);
        when(tagResourceAssemblerMock.assemble(tags)).thenReturn(tagResources);

        // when
        final List<TagResource> result = tagRestController.allTags();

        // then
        Assertions.assertThat(result).isEqualTo(tagResources);
        verify(findAllTagsUseCaseMock, times(1)).allTags();
        verify(tagResourceAssemblerMock, times(1)).assemble(tags);
    }
}
