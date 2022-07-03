package pl.maciejbadziak.voteitbackend.asserts;

import org.assertj.core.api.AbstractAssert;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class VoteitDtoAssert extends AbstractAssert<VoteitDtoAssert, VoteitDto> {

    public VoteitDtoAssert(VoteitDto actual) {
        super(actual, VoteitDtoAssert.class);
    }

    public static VoteitDtoAssert assertThat(VoteitDto actual) {
        return new VoteitDtoAssert(actual);
    }

    public VoteitDtoAssert hasId(Long id) {
        isNotNull();
        if (!actual.getId().equals(id)) {
            failWithMessage("Expected voteit to have id %s but was %s.",
                    id,
                    actual.getId());
        }
        return this;
    }

    public VoteitDtoAssert hasTagsSize(int tagsSize) {
        isNotNull();
        int actualTagsSize = actual.getTags().size();
        if (actualTagsSize != tagsSize) {
            failWithMessage("Expected voteit to have tags size %s but was %s.",
                    tagsSize,
                    actual.getTags().size());
        }
        return this;
    }

    public VoteitDtoAssert hasTitle(String title) {
        isNotNull();
        if (!actual.getTitle().equals(title)) {
            failWithMessage("Expected voteit to have title %s but was %s.",
                    title,
                    actual.getTitle());
        }
        return this;
    }

    public VoteitDtoAssert hasDescription(String description) {
        isNotNull();
        if (!actual.getDescription().equals(description)) {
            failWithMessage("Expected voteit to have description %s but was %s.",
                    description,
                    actual.getDescription());
        }
        return this;
    }

    public VoteitDtoAssert hasUrl(String url) {
        isNotNull();
        if (!actual.getUrl().equals(url)) {
            failWithMessage("Expected voteit to have url %s but was %s.",
                    url,
                    actual.getUrl());
        }
        return this;
    }

    public VoteitDtoAssert hasThumbnail(String thumbnail) {
        isNotNull();
        if (!actual.getThumbnail().equals(thumbnail)) {
            failWithMessage("Expected voteit to have thumbnail %s but was %s.",
                    thumbnail,
                    actual.getThumbnail());
        }
        return this;
    }

    public VoteitDtoAssert hasVotesUp(int votesUp) {
        isNotNull();
        if (actual.getVotesUp() != votesUp) {
            failWithMessage("Expected voteit to have votesUp %s but was %s.",
                    votesUp,
                    actual.getVotesUp());
        }
        return this;
    }

    public VoteitDtoAssert hasVotesDown(int votesDown) {
        isNotNull();
        if (actual.getVotesDown() != votesDown) {
            failWithMessage("Expected voteit to have votesDown %s but was %s.",
                    votesDown,
                    actual.getVotesDown());
        }
        return this;
    }

    public VoteitDtoAssert isForAdult(boolean isForAdult) {
        isNotNull();
        if (actual.isForAdult() != isForAdult) {
            failWithMessage("Expected voteit to be for Adult %s but was %s.",
                    isForAdult,
                    actual.isForAdult());
        }
        return this;
    }

    public VoteitDtoAssert hasCreationDate(LocalDateTime creationDate) {
        isNotNull();
        if (ChronoUnit.NANOS.between(actual.getCreationDate(), creationDate) > 1000) {
            failWithMessage("Expected voteit to have creation date %s but was %s.",
                    creationDate,
                    actual.getCreationDate());
        }
        return this;
    }

    public VoteitDtoAssert hasAuthor(Long id) {
        isNotNull();
        Long authorId = actual.getAuthor().getId();
        if (!authorId.equals(id)) {
            failWithMessage("Expected voteit to have author id %s but was %s.",
                    id,
                    actual.getAuthor().getId());
        }
        return this;
    }
}
