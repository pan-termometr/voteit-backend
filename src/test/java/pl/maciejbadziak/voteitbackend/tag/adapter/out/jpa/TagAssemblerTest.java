package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTagEntity;

class TagAssemblerTest {

    @Test
    void shouldAssemblerTag() {
        // given
        final TagEntity tagEntity = newsTagEntity();

        // when
        final Tag result = new TagAssembler().assemble(tagEntity);

        // then
        assertThat(result.getTagname().getValue()).isEqualTo(tagEntity.getTagname());
    }

    @Test
    void shouldAssemblerTags() {
        // given
        final List<TagEntity> tagEntities = List.of(newsTagEntity(), travelTagEntity());

        // when
        final List<Tag> result = new TagAssembler().assemble(tagEntities);

        // then
        assertThat(result).hasSameSizeAs(tagEntities);
    }

    @Test
    void shouldReturnNullForNullableEntity() {
        // given
        // when
        final Tag result = new TagAssembler().assemble((TagEntity) null);

        // then
        assertThat(result).isNull();
    }
}
