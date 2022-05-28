package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.entity.Tag;

@Mapper(uses = {VoteitMapper.class})
public abstract class TagMapper {

    public abstract TagDto tagToTagDto(Tag tag);
}
