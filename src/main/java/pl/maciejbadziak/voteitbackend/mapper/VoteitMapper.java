package pl.maciejbadziak.voteitbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = {UserMapper.class, TagMapper.class})
public interface VoteitMapper {

    VoteitDto voteitToVoteitDto(Voteit voteit);

    List<VoteitDto> voteitsToVoteitDtos(Iterable<Voteit> voteit);
}
