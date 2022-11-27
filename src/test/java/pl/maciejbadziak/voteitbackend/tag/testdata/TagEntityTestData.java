package pl.maciejbadziak.voteitbackend.tag.testdata;

import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;

public class TagEntityTestData {

    public static TagEntity newsTagEntity() {
        return TagEntity.builder()
                .id(1L)
                .tagname("news")
                .build();
    }

    public static TagEntity travelTagEntity() {
        return TagEntity.builder()
                .id(2L)
                .tagname("travel")
                .build();
    }
}
