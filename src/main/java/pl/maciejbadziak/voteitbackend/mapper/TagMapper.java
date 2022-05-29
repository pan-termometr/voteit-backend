package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.entity.Tag;

import java.util.List;

@Mapper(uses = {VoteitMapper.class})
public interface TagMapper {

    TagDto tagToTagDto(Tag tag);

    List<TagDto> tagsToTagDto(List<Tag> tagList);
}
