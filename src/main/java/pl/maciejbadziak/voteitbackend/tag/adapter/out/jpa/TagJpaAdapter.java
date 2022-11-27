package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejbadziak.voteitbackend.tag.domain.Tag;
import pl.maciejbadziak.voteitbackend.tag.port.FindAllTagsPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TagJpaAdapter implements FindAllTagsPort {

    private final TagRepository repository;

    private final TagAssembler assembler;

    @Transactional
    @Override
    public List<Tag> findAll() {
        final List<TagEntity> tagEntities = repository.findAll();
        return assembler.assemble(tagEntities);
    }
}
