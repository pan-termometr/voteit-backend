package pl.maciejbadziak.voteitbackend.testdata.entity;

import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.time.LocalDateTime;
import java.util.Set;

import static pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData.getPoliticsTag;
import static pl.maciejbadziak.voteitbackend.testdata.entity.TagTestData.getTravelTag;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getAdminUser;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getRandomUser;

public class VoteitTestData {

    public static Voteit getOnetVoteit() {
        return Voteit.builder()
                .id(1L)
                .tags(Set.of(getPoliticsTag()))
                .title("Onet")
                .description("News from Poland")
                .url("https://onet.pl")
                .thumbnail("/voteit-1.jpg")
                .votesUp(900)
                .votesDown(13)
                .isForAdult(false)
                .author(getRandomUser())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public static Voteit getAdsVoteit() {
        return Voteit.builder()
                .id(2L)
                .tags(Set.of(getPoliticsTag(), getTravelTag()))
                .title("Autostopem Dookoła Świata")
                .description("Blog podróżniczy")
                .url("https://autostopemdookolaswiata.pl")
                .thumbnail("/voteit-2")
                .votesUp(1000)
                .votesDown(0)
                .isForAdult(false)
                .author(getAdminUser())
                .creationDate(LocalDateTime.now())
                .build();
    }
}
