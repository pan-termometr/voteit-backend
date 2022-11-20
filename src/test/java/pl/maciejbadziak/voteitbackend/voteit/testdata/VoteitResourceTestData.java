package pl.maciejbadziak.voteitbackend.voteit.testdata;

import pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest.resources.VoteitResource;

import java.time.LocalDateTime;
import java.util.Set;

public class VoteitResourceTestData {

    public static VoteitResource onetVoteitResource() {
        return VoteitResource.builder()
                .id(1L)
                .title("Onet")
                .description("News from Poland")
                .url("https://onet.pl")
                .thumbnail("/voteit-1.jpg")
                .votesUp(900)
                .votesDown(13)
                .tags(Set.of("news"))
                .isForAdultOnly(false)
                .creator("termometr")
                .creationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }

    public static VoteitResource adsVoteitResource() {
        return VoteitResource.builder()
                .id(2L)
                .title("Autostopem Dookoła Świata")
                .description("Blog podróżniczy")
                .url("https://autostopemdookolaswiata.pl")
                .thumbnail("/voteit-2.jpg")
                .votesUp(1000)
                .votesDown(0)
                .tags(Set.of("travel"))
                .isForAdultOnly(false)
                .creator("termometr")
                .creationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }
}
