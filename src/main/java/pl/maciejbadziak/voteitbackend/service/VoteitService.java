package pl.maciejbadziak.voteitbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.exception.VoteitDoesNotExistException;
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

    public VoteitDto getById(Long id) {
        return voteitMapper.voteitToVoteitDto(voteitRepository.findById(id).orElseThrow(() -> new VoteitDoesNotExistException("No voteit found with id: " + id)));
    }
}
