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

import java.util.List;

import static java.util.List.of;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTagEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.adsVoteitEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;

@AutoConfigureMockMvc
class VoteitRestControllerIntegrationTest extends IntegrationTest {

    private static final String VOTEIT_URL = "/voteit";

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
    void shouldProvideAllVoteits() throws Exception {
        // given
        final UserEntity termometrUserEntity = termometrUserEntity();

        userRepository.save(termometrUserEntity);

        final TagEntity newsTagEntity = newsTagEntity();
        final TagEntity travelTagEntity = travelTagEntity();
        final VoteitEntity onetVoteitEntity = onetVoteitEntity().withCreator(termometrUserEntity);
        final VoteitEntity adsVoteitEntity = adsVoteitEntity().withCreator(termometrUserEntity);
        final List<TagEntity> tagEntities = of(newsTagEntity, travelTagEntity);
        final List<VoteitEntity> voteitEntities = of(onetVoteitEntity, adsVoteitEntity);

        tagRepository.saveAll(tagEntities);
        voteitRepository.saveAll(voteitEntities);

        // when
        final ResultActions result = mvc.perform(get(VOTEIT_URL));

        // then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is(onetVoteitEntity.getTitle())))
                .andExpect(jsonPath("$[0].description", is(onetVoteitEntity.getDescription())))
                .andExpect(jsonPath("$[0].url", is(onetVoteitEntity.getUrl())))
                .andExpect(jsonPath("$[0].thumbnail", is(onetVoteitEntity.getThumbnail())))
                .andExpect(jsonPath("$[0].votesUp", is(onetVoteitEntity.getVotesUp())))
                .andExpect(jsonPath("$[0].votesDown", is(onetVoteitEntity.getVotesDown())))
                .andExpect(jsonPath("$[0].tags[0]", is(newsTagEntity.getTagname())))
                .andExpect(jsonPath("$[0].forAdultOnly", is(onetVoteitEntity.isForAdultOnly())))
                .andExpect(jsonPath("$[0].creator", is(onetVoteitEntity.getCreator().getUsername())))
                .andExpect(jsonPath("$[0].creationDate", is(onetVoteitEntity.getCreationDate().toString())))
                .andExpect(jsonPath("$[1].title", is(adsVoteitEntity.getTitle())))
                .andExpect(jsonPath("$[1].description", is(adsVoteitEntity.getDescription())))
                .andExpect(jsonPath("$[1].url", is(adsVoteitEntity.getUrl())))
                .andExpect(jsonPath("$[1].thumbnail", is(adsVoteitEntity.getThumbnail())))
                .andExpect(jsonPath("$[1].votesUp", is(adsVoteitEntity.getVotesUp())))
                .andExpect(jsonPath("$[1].votesDown", is(adsVoteitEntity.getVotesDown())))
                .andExpect(jsonPath("$[1].tags[0]", is(travelTagEntity.getTagname())))
                .andExpect(jsonPath("$[1].forAdultOnly", is(adsVoteitEntity.isForAdultOnly())))
                .andExpect(jsonPath("$[1].creator", is(adsVoteitEntity.getCreator().getUsername())))
                .andExpect(jsonPath("$[1].creationDate", is(adsVoteitEntity.getCreationDate().toString())));
    }
}
