package pl.maciejbadziak.voteitbackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.dto.TagDtoAssert;
import pl.maciejbadziak.voteitbackend.entity.Tag;
import pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData;

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
        Assertions.assertNull(result);
    }
    @Test
    void shouldMapTagToTagDto() {
        // given
        Tag tag = TagTestData.getPoliticsTag();

        // when
        TagDto result = tagMapper.tagToTagDto(tag);

        // then
        Assertions.assertEquals(tag.getId(), result.getId());
        TagDtoAssert.assertThat(result)
                .hasName(tag.getName())
                .hasVoteits(tag.getVoteits());
    }
}
