package pl.maciejbadziak.voteitbackend.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.entity.Tag;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static pl.maciejbadziak.voteitbackend.asserts.TagDtoAssert.assertThat;
import static pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData.getPoliticsTag;
import static pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData.getTravelTag;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TagMapperImpl.class)
class TagMapperTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    void shouldMapToNullForNullTag() {
        // given
        // when
        TagDto result = tagMapper.tagToTagDto(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldMapTagToTagDto() {
        // given
        Tag tag = getPoliticsTag();

        // when
        TagDto result = tagMapper.tagToTagDto(tag);

        // then
        assertEquals(tag.getId(), result.getId());
        assertThat(result)
                .hasId(tag.getId())
                .hasName(tag.getName());
    }

    @Test
    void shouldMapToNullForNullTags() {
        // given
        // when
        List<TagDto> result = tagMapper.tagsToTagDtos(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldMapTagsToTagDtos() {
        // given
        Set<Tag> tags = Set.of(getPoliticsTag(), getTravelTag());

        // when
        List<TagDto> result = tagMapper.tagsToTagDtos(tags);

        // then
        assertEquals(2, result.size());
    }
}
