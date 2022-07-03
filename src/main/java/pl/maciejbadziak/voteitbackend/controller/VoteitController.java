package pl.maciejbadziak.voteitbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.service.VoteitService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("voteits")
public class VoteitController {

    private static final String APPLICATION_JSON_MEDIA_TYPE = "application/json";

    @Autowired
    private VoteitService voteitService;

    @GetMapping(produces = APPLICATION_JSON_MEDIA_TYPE)
    public ResponseEntity<List<VoteitDto>> getAllVoteits() {
        List<VoteitDto> allVoteits = voteitService.getAll();
        return new ResponseEntity<>(allVoteits, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_MEDIA_TYPE)
    public ResponseEntity<VoteitDto> getVoteitById(@PathVariable("id") final Long id) {
        VoteitDto voteit = voteitService.getById(id);
        return new ResponseEntity<>(voteit, HttpStatus.OK);
    }

}
