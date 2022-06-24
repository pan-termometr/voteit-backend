package pl.maciejbadziak.voteitbackend.testdata.dto;

import pl.maciejbadziak.voteitbackend.dto.TagDto;

public class TagDtoTestData {

    public static TagDto getPoliticsTagDto() {
        return TagDto.builder()
                .id(1L)
                .name("politics")
                .build();
    }

    public static TagDto getTravelTagDto() {
        return TagDto.builder()
                .id(2L)
                .name("travel")
                .build();
    }
}
