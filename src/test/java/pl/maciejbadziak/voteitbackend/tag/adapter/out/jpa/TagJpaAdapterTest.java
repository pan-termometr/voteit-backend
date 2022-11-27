package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.newsTag;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.travelTag;

@ExtendWith(MockitoExtension.class)
class TagJpaAdapterTest {

    @Mock
    private transient TagRepository tagRepositoryMock;

    @Mock
    private transient TagAssembler tagAssemblerMock;

    @InjectMocks
    private transient TagJpaAdapter tagJpaAdapter;

    @Test
    void shouldProvideTags() {
        // given
        final List<TagEntity> givenTags = of(newsTagEntity(), travelTagEntity());
        final List<Tag> expectedTags = of(newsTag(), travelTag());

        when(tagRepositoryMock.findAll()).thenReturn(givenTags);
        when(tagAssemblerMock.assemble(givenTags)).thenReturn(expectedTags);

        // when
        final List<Tag> result = tagJpaAdapter.findAll();

        // then
        assertThat(result).isEqualTo(expectedTags);
        verify(tagRepositoryMock, times(1)).findAll();
        verify(tagAssemblerMock, times(1)).assemble(givenTags);
    }
}
