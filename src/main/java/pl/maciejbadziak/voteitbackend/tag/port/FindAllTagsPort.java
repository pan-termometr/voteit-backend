package pl.maciejbadziak.voteitbackend.tag.port;

import pl.maciejbadziak.voteitbackend.tag.domain.Tag;

import java.util.List;

public interface FindAllTagsPort {

    List<Tag> findAll();
}
