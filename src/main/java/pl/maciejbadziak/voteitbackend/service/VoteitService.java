package pl.maciejbadziak.voteitbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.mapper.VoteitMapper;
import pl.maciejbadziak.voteitbackend.repository.VoteitRepository;

import java.util.List;

@Service
public class VoteitService {

    @Autowired
    private VoteitRepository voteitRepository;

    @Autowired
    private VoteitMapper voteitMapper;

    public List<VoteitDto> getAll() {
        return voteitMapper.voteitsToVoteitDtos(voteitRepository.findAll());
    }

}
