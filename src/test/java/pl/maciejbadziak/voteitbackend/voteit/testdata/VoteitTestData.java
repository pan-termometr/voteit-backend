package pl.maciejbadziak.voteitbackend.voteit.testdata;

import pl.maciejbadziak.voteitbackend.voteit.domain.*;

import java.time.LocalDateTime;
import java.util.Set;

public class VoteitTestData {

    public static Voteit onetVoteit() {
        return Voteit.builder()
                .id(Id.of(1L))
                .title(Title.of("Onet"))
                .description(Description.of("News from Poland"))
                .url(Url.of("https://onet.pl"))
                .thumbnail(Thumbnail.of("/voteit-1.jpg"))
                .votesUp(Vote.of(900))
                .votesDown(Vote.of(13))
                .tags(Set.of(Tag.of("news")))
                .isForAdultOnly(false)
                .creator(Creator.of("termometr"))
                .creationDate(CreationDate.of(LocalDateTime.of(2022, 11, 11, 13, 13, 13)))
                .build();
    }

    public static Voteit adsVoteit() {
        return Voteit.builder()
                .id(Id.of(2L))
                .title(Title.of("Autostopem Dookoła Świata"))
                .description(Description.of("Blog podróżniczy"))
                .url(Url.of("https://autostopemdookolaswiata.pl"))
                .thumbnail(Thumbnail.of("/voteit-2.jpg"))
                .votesUp(Vote.of(1000))
                .votesDown(Vote.of(0))
                .tags(Set.of(Tag.of("travel")))
                .isForAdultOnly(false)
                .creator(Creator.of("termometr"))
                .creationDate(CreationDate.of(LocalDateTime.of(2022, 11, 11, 13, 13, 13)))
                .build();
    }
}
