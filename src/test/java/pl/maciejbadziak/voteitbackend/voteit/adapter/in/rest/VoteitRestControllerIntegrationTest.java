package pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.maciejbadziak.voteitbackend.IntegrationTest;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagRepository;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserRepository;
import pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa.VoteitEntity;
import pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa.VoteitRepository;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTag;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;

@AutoConfigureMockMvc
class VoteitRestControllerIntegrationTest extends IntegrationTest {

    @Autowired
    private transient MockMvc mvc;

    @Autowired
    private transient UserRepository userRepository;

    @Autowired
    private transient TagRepository tagRepository;

    @Autowired
    private transient VoteitRepository voteitRepository;

    @BeforeEach
    public void init() {
        userRepository.deleteAll();
        tagRepository.deleteAll();
        voteitRepository.deleteAll();
    }

    @Test
    void shouldProvideVoteits() throws Exception {
        // given
        final VoteitEntity voteitEntity = onetVoteitEntity();
        final TagEntity tagEntity = newsTag();
        final UserEntity userEntity = termometrUserEntity();

        userRepository.save(userEntity);
        tagRepository.save(tagEntity);
        voteitRepository.save(voteitEntity);

        // when
        final ResultActions result = mvc.perform(get("/voteits"));

        // then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(voteitEntity.getId().intValue())))
                .andExpect(jsonPath("$[0].title", is(voteitEntity.getTitle())))
                .andExpect(jsonPath("$[0].description", is(voteitEntity.getDescription())))
                .andExpect(jsonPath("$[0].url", is(voteitEntity.getUrl())))
                .andExpect(jsonPath("$[0].thumbnail", is(voteitEntity.getThumbnail())))
                .andExpect(jsonPath("$[0].votesUp", is(voteitEntity.getVotesUp())))
                .andExpect(jsonPath("$[0].votesDown", is(voteitEntity.getVotesDown())))
                .andExpect(jsonPath("$[0].tags[0]", is(tagEntity.getName())))
                .andExpect(jsonPath("$[0].forAdultOnly", is(voteitEntity.isForAdultOnly())))
                .andExpect(jsonPath("$[0].creator", is(voteitEntity.getCreator().getUsername())))
                .andExpect(jsonPath("$[0].creationDate", is(voteitEntity.getCreationDate().toString())));
    }
}
