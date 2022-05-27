package pl.maciejbadziak.voteitbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag extends CommonFields {

    @ManyToMany(mappedBy = "tags")
    final private Set<Voteit> voteitList = new HashSet<>();
    @Column(length = 20, nullable = false)
    private String name;
}
