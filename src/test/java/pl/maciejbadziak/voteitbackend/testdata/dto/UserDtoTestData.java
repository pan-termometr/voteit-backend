package pl.maciejbadziak.voteitbackend.testdata.dto;

import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.testdata.entity.VoteitTestData;

import java.util.Set;

public class UserDtoTestData {

    public static UserDto getAdminUserDto() {
        return UserDto.builder()
                .id(1L)
                .username("admin")
                .email("admin@voteit.com")
                .voteits(Set.of(VoteitTestData.getOnetVoteit()))
                .build();
    }

    public static UserDto getRandomUserDto() {
        return UserDto.builder()
                .id(2L)
                .username("random")
                .email("random@voteit.com")
                .voteits(Set.of(VoteitTestData.getOnetVoteit()))
                .build();
    }
}
