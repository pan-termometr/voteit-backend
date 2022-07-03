package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {UserMapper.class, TagMapper.class})
public interface VoteitMapper {

    @Mapping(target="author", source = "voteit.author.username")
    @Mapping(target="tags", source = "voteit.tags")
    VoteitDto voteitToVoteitDto(Voteit voteit);

    List<VoteitDto> voteitsToVoteitDtos(Iterable<Voteit> voteit);
}
