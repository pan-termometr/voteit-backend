package pl.maciejbadziak.voteitbackend.tag.testdata;

import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;

public class TagEntityTestData {

    public static TagEntity newsTagEntity() {
        return TagEntity.builder()
                .tagname("news")
                .build();
    }

    public static TagEntity travelTagEntity() {
        return TagEntity.builder()
                .tagname("travel")
                .build();
    }
}
