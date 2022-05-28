package pl.maciejbadziak.voteitbackend.mapper;

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
public class TagMapperTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    void should() {
        // given
        Tag tag = TagTestData.getPoliticsTag();

        // when
        TagDto result = tagMapper.tagToTagDto(tag);

        // then
        TagDtoAssert.assertThat(result)
                .hasName(tag.getName())
                .hasVoteits(tag.getVoteits());
    }
}
