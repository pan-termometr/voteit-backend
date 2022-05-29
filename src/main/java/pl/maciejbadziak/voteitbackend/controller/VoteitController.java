package pl.maciejbadziak.voteitbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejbadziak.voteitbackend.dto.VoteitDto;
import pl.maciejbadziak.voteitbackend.service.VoteitService;

import java.util.List;

@RestController
@RequestMapping("voteits")
public class VoteitController {

    @Autowired
    private VoteitService voteitService;

    @GetMapping(produces = "application/json")
    public List<VoteitDto> getVoteits() {
        return voteitService.getAll();
    }

}
