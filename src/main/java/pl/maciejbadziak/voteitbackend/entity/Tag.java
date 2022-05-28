package pl.maciejbadziak.voteitbackend.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tag")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    @ManyToMany(mappedBy = "tags")
    private Set<Voteit> voteits;
    @Column(length = 20, nullable = false)
    private String name;
}
