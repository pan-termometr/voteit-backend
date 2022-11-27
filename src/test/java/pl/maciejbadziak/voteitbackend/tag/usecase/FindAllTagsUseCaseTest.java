package pl.maciejbadziak.voteitbackend.tag.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;
import pl.maciejbadziak.voteitbackend.tag.port.FindAllTagsPort;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.newsTag;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.travelTag;

@ExtendWith(MockitoExtension.class)
class FindAllTagsUseCaseTest {

    @Mock
    private transient FindAllTagsPort findAllTagsPortMock;

    @InjectMocks
    private transient FindAllTagsUseCase findAllTagsUseCase;

    @Test
    void shouldProvideAllTags() {
        // given
        final List<Tag> tags = of(newsTag(), travelTag());

        when(findAllTagsPortMock.findAll()).thenReturn(tags);

        // when
        final List<Tag> result = findAllTagsUseCase.allTags();

        // then
        assertThat(result).isEqualTo(tags);
    }
}