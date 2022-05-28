package pl.maciejbadziak.voteitbackend.testdata.entity;

import pl.maciejbadziak.voteitbackend.entity.Voteit;

public class VoteitTestData {

    public static Voteit getVoteitOnet() {
        return Voteit.builder()
                .title("Onet")
                .description("News from Poland")
                .url("https://onet.pl")
                .isForAdult(false)
                .build();
    }
}
