package pl.maciejbadziak.voteitbackend.tag.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;
import pl.maciejbadziak.voteitbackend.tag.port.FindAllTagsPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllTagsUseCase {

    private final FindAllTagsPort findAllTagsUsePort;

    public List<Tag> allTags() { return findAllTagsUsePort.findAll(); }
}
