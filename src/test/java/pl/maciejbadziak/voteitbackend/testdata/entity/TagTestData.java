package pl.maciejbadziak.voteitbackend.testdata.entity;

import pl.maciejbadziak.voteitbackend.entity.Tag;

public class TagTestData {

    public static Tag getPoliticsTag() {
        return Tag.builder()
                .id(1L)
                .name("politics")
                .build();
    }

    public static Tag getTravelTag() {
        return Tag.builder()
                .id(2L)
                .name("travel")
                .build();
    }
}
