package pl.maciejbadziak.voteitbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciejbadziak.voteitbackend.dto.TagDto;
import pl.maciejbadziak.voteitbackend.mapper.TagMapper;
import pl.maciejbadziak.voteitbackend.repository.TagRepository;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagMapper tagMapper;

    public List<TagDto> getAll() {
        return tagMapper.tagsToTagDto(tagRepository.findAll());
    }
}
