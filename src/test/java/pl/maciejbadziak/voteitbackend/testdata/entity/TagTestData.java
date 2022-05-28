package pl.maciejbadziak.voteitbackend.testdata.entity;

import pl.maciejbadziak.voteitbackend.entity.Tag;

import java.util.Set;

public class TagTestData {

    public static Tag getPoliticsTag() {
        return Tag.builder()
                .id(1L)
                .name("politics")
                .voteits(Set.of(VoteitTestData.getVoteitOnet()))
                .build();
    }
}
