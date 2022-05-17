package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VoteTest {

    private static final int ONE = 1;

    @Test
    void shouldCreateVote() {
        // given
        // when
        // then
        assertThat(Vote.of(ONE).getValue()).isEqualTo(ONE);
    }
}
