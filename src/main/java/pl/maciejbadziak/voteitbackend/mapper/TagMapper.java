package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.entity.Tag;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {VoteitMapper.class})
public interface TagMapper {

    TagDto tagToTagDto(Tag tag);

    List<TagDto> tagsToTagDtos(Iterable<Tag> tagList);
}
