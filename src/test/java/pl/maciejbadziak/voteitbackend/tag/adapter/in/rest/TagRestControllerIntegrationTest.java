package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest;

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

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTagEntity;

@AutoConfigureMockMvc
class TagRestControllerIntegrationTest extends IntegrationTest {

    @Autowired
    private transient MockMvc mvc;

    @Autowired
    private transient TagRepository tagRepository;

    @BeforeEach
    public void init() {
        tagRepository.deleteAll();
    }

    @Test
    void shouldProvideTags() throws Exception {
        // given
        final TagEntity newsTagEntity = newsTagEntity();
        final TagEntity travelTagEntity = travelTagEntity();
        final List<TagEntity> tagEntities = List.of(newsTagEntity, travelTagEntity);

        tagRepository.saveAll(tagEntities);

        // when
        final ResultActions result = mvc.perform(get("/tags"));

        // then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].tagname", is(newsTagEntity.getTagname())))
                .andExpect(jsonPath("$[1].tagname", is(travelTagEntity.getTagname())));

    }
}
