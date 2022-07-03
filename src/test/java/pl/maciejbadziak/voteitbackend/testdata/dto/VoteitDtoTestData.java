package pl.maciejbadziak.voteitbackend.testdata.dto;

import pl.maciejbadziak.voteitbackend.dto.VoteitDto;

import java.time.LocalDateTime;

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
                .author("random")
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
                .author("admin")
                .creationDate(LocalDateTime.now())
                .build();
    }
}
