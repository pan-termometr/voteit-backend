package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

@Mapper(uses = {UserMapper.class, TagMapper.class})
public abstract class VoteitMapper {

    public abstract VoteitDto voteitToVoteitDto(Voteit voteit);
}
