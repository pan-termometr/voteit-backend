package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.maciejbadziak.voteitbackend.IntegrationTest;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagRepository;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserRepository;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTagEntity;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTagEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.adsVoteitEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;

class VoteitRepositoryTest extends IntegrationTest {

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
    void shouldReturnVoteit() {
        // given
        final UserEntity userEntity = termometrUserEntity();

        userRepository.save(userEntity);

        final TagEntity tagEntity = newsTagEntity();
        final VoteitEntity voteitEntity = onetVoteitEntity();

        tagRepository.save(tagEntity);
        voteitRepository.save(voteitEntity.withCreator(userEntity));

        // when
        final List<VoteitEntity> result = voteitRepository.findAll();

        // then
        assertThat(result)
                .hasSize(1)
                .flatExtracting(
                        VoteitEntity::getTitle,
                        VoteitEntity::getDescription,
                        VoteitEntity::getUrl,
                        VoteitEntity::getThumbnail,
                        VoteitEntity::getVotesUp,
                        VoteitEntity::getVotesDown,
                        VoteitEntity::isForAdultOnly,
                        VoteitEntity::getCreationDate
                )
                .containsExactly(
                        voteitEntity.getTitle(),
                        voteitEntity.getDescription(),
                        voteitEntity.getUrl(),
                        voteitEntity.getThumbnail(),
                        voteitEntity.getVotesUp(),
                        voteitEntity.getVotesDown(),
                        voteitEntity.isForAdultOnly(),
                        voteitEntity.getCreationDate()
                );
    }

    @Test
    void shouldReturnAllVoteits() {
        // given
        final UserEntity userEntity = termometrUserEntity();

        userRepository.save(userEntity);

        final List<TagEntity> tagEntities = of(newsTagEntity(), travelTagEntity());
        final List<VoteitEntity> entities = of(onetVoteitEntity().withCreator(userEntity), adsVoteitEntity().withCreator(userEntity));

        tagRepository.saveAll(tagEntities);
        voteitRepository.saveAll(entities);

        // when
        final List<VoteitEntity> result = voteitRepository.findAll();

        // then
        assertThat(result).hasSameSizeAs(entities);
    }

    @Test
    void shouldReturnEmptyListForNoVoteits() {
        // given
        // when
        final List<VoteitEntity> result = voteitRepository.findAll();

        // then
        assertThat(result).isEmpty();
    }
}
