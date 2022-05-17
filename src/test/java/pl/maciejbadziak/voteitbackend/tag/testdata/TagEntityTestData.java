package pl.maciejbadziak.voteitbackend.tag.testdata;

import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;

public class TagEntityTestData {

    public static TagEntity newsTag() {
        return TagEntity.builder()
                .id(1L)
                .name("news")
                .build();
    }

    public static TagEntity travelTag() {
        return TagEntity.builder()
                .id(2L)
                .name("travel")
                .build();
    }
}
