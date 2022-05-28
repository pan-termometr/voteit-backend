package pl.maciejbadziak.voteitbackend.testdata.entity;

import pl.maciejbadziak.voteitbackend.entity.User;

import java.util.Set;

public class UserTestData {

    public static User getAdminUser() {
        return User.builder()
                .username("admin")
                .password("password")
                .email("admin@voteit.com")
                .voteits(Set.of(VoteitTestData.getVoteitOnet()))
                .build();
    }
}
