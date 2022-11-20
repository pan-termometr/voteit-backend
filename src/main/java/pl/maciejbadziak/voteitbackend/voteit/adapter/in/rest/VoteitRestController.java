package pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejbadziak.voteitbackend.voteit.adapter.in.rest.resources.VoteitResource;
import pl.maciejbadziak.voteitbackend.voteit.usecase.FindAllVoteitsUseCase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/voteits")
public class VoteitRestController {

    private static final String VOTEITS = "voteits";

    private final FindAllVoteitsUseCase findAllVoteitsUseCase;

    private final VoteitResourceAssembler assembler;

    @Cacheable(VOTEITS)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VoteitResource> allVoteits() {
        return assembler.assemble(findAllVoteitsUseCase.allVoteits());
    }

}
