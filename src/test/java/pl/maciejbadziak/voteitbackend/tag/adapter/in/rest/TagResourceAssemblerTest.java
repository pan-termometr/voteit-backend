package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.resources.TagResource;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.newsTag;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagTestData.travelTag;

class TagResourceAssemblerTest {

    @Test
    void shouldAssembleTag() {
        // given
        final Tag tag = newsTag();

        // when
        final TagResource result = new TagResourceAssembler().assemble(tag);

        // then
        assertThat(result.getTagname()).isEqualTo(tag.getTagname().getValue());
    }

    @Test
    void shouldAssembleTags() {
        // given
        final List<Tag> tags = of(newsTag(), travelTag());

        // when
        final List<TagResource> result = new TagResourceAssembler().assemble(tags);

        // then
        assertThat(result).hasSameSizeAs(tags);
    }

    @Test
    void shouldReturnNullForNullableTag() {
        // given
        // when
        final TagResource result = new TagResourceAssembler().assemble((Tag) null);

        // then
        assertThat(result).isNull();
    }
}
