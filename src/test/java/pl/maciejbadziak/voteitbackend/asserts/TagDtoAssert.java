package pl.maciejbadziak.voteitbackend.asserts;

import org.assertj.core.api.AbstractAssert;
import pl.maciejbadziak.voteitbackend.dto.TagDto;

public class TagDtoAssert extends AbstractAssert<TagDtoAssert, TagDto> {

    public TagDtoAssert(TagDto actual) {
        super(actual, TagDtoAssert.class);
    }

    public static TagDtoAssert assertThat(TagDto actual) {
        return new TagDtoAssert(actual);
    }

    public TagDtoAssert hasId(Long id) {
        isNotNull();
        if(!actual.getId().equals(id)) {
            failWithMessage("Expected tag to have id %s but was %s.",
                    id,
                    actual.getId());
        }
        return this;
    }

    public TagDtoAssert hasName(String name) {
        isNotNull();
        if (!actual.getName().equals(name)) {
            failWithMessage("Expected person to have name %s but was %s.",
                    name,
                    actual.getName());
        }
        return this;
    }
}
