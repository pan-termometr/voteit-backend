package pl.maciejbadziak.voteitbackend.voteit.testdata;

import pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa.VoteitEntity;

import java.time.LocalDateTime;
import java.util.Set;

import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTagEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;

public class VoteitEntityTestData {

    public static VoteitEntity onetVoteitEntity() {
        return VoteitEntity.builder()
                .id(1L)
                .title("Onet")
                .description("News from Poland")
                .url("https://onet.pl")
                .thumbnail("/voteit-1.jpg")
                .votesUp(900)
                .votesDown(13)
                .tags(Set.of(newsTagEntity()))
                .isForAdultOnly(false)
                .creator(termometrUserEntity())
                .creationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }

    public static VoteitEntity adsVoteitEntity() {
        return VoteitEntity.builder()
                .id(2L)
                .title("Autostopem Dookoła Świata")
                .description("Blog podróżniczy")
                .url("https://autostopemdookolaswiata.pl")
                .thumbnail("/voteit-2.jpg")
                .votesUp(1000)
                .votesDown(0)
                .tags(Set.of(travelTagEntity()))
                .isForAdultOnly(false)
                .creator(termometrUserEntity())
                .creationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }
}
