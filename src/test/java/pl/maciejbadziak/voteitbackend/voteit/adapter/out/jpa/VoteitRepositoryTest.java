package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.maciejbadziak.voteitbackend.IntegrationTests;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagRepository;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserRepository;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.newsTag;
import static pl.maciejbadziak.voteitbackend.tag.testdata.TagEntityTestData.travelTag;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUser;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.adsVoteitEntity;
import static pl.maciejbadziak.voteitbackend.voteit.testdata.VoteitEntityTestData.onetVoteitEntity;

class VoteitRepositoryTest extends IntegrationTests {

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
        final VoteitEntity voteitEntity = onetVoteitEntity();
        final TagEntity tagEntity = newsTag();
        final UserEntity userEntity = termometrUser();

        userRepository.save(userEntity);
        tagRepository.save(tagEntity);
        voteitRepository.save(voteitEntity);

        // when
        final List<VoteitEntity> result = voteitRepository.findAll();

        // then
        assertThat(result)
                .hasSize(1)
                .flatExtracting(
                        VoteitEntity::getId,
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
                        voteitEntity.getId(),
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
        final List<VoteitEntity> entities = of(onetVoteitEntity(), adsVoteitEntity());
        final List<TagEntity> tagEntities = of(newsTag(), travelTag());
        final UserEntity userEntity = termometrUser();

        userRepository.save(userEntity);
        tagRepository.saveAll(tagEntities);
        voteitRepository.saveAll(entities);

        // when
        final List<VoteitEntity> result = voteitRepository.findAll();

        // then
        assertThat(result).hasSameSizeAs(entities);
    }
}
