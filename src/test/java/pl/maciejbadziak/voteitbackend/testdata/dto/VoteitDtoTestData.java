package pl.maciejbadziak.voteitbackend.testdata.dto;

import pl.maciejbadziak.voteitbackend.dto.VoteitDto;

import java.time.LocalDateTime;

import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getAdminUser;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getRandomUser;

public class VoteitDtoTestData {

    public static VoteitDto getOnetVoteitDto() {
        return VoteitDto.builder()
                .id(1L)
                .title("Onet")
                .description("News from Poland")
                .url("https://onet.pl")
                .thumbnail("/cover/1")
                .votesUp(900)
                .votesDown(13)
                .isForAdult(false)
                .author(getRandomUser())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public static VoteitDto getAdsVoteitDto() {
        return VoteitDto.builder()
                .id(2L)
                .title("Autostopem Dookoła Świata")
                .description("Blog podróżniczy")
                .url("https://autostopemdookolaswiata.pl")
                .thumbnail("/cover/2")
                .votesUp(1000)
                .votesDown(0)
                .isForAdult(false)
                .author(getAdminUser())
                .creationDate(LocalDateTime.now())
                .build();
    }
}
