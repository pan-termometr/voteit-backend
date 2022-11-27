package pl.maciejbadziak.voteitbackend.tag.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.resources.TagResource;
import pl.maciejbadziak.voteitbackend.tag.usecase.FindAllTagsUseCase;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
public class TagRestController {

    private static final String TAGS = "voteits";

    @Autowired
    private TagResourceAssembler tagResourceAssembler;

    @Autowired
    private FindAllTagsUseCase findAllTagsUseCase;

    @Cacheable(TAGS)
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TagResource> allTags() {
        return tagResourceAssembler.assemble(findAllTagsUseCase.allTags());
    }
}
