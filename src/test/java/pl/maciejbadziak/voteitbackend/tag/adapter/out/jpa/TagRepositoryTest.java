package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.maciejbadziak.voteitbackend.IntegrationTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;

class TagRepositoryTest extends IntegrationTest {

    @Autowired
    private transient TagRepository tagRepository;

    @BeforeEach
    public void init() {
        tagRepository.deleteAll();
    }

    @Test
    void shouldReturnTag() {
        // given
        final TagEntity tagEntity = newsTagEntity();

        tagRepository.save(tagEntity);

        // when
        final List<TagEntity> result = tagRepository.findAll();

        // then
        assertThat(result)
                .hasSize(1)
                .flatExtracting(
                        TagEntity::getTagname
                ).containsExactly(
                        tagEntity.getTagname()
                );
    }
}
