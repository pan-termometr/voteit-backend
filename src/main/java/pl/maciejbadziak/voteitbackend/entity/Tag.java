package pl.maciejbadziak.voteitbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tags")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    @JsonBackReference
    private Set<Voteit> voteits = new HashSet<>();
    @Column(length = 20, nullable = false)
    private String name;
    @Builder
    public Tag(Long id, String name, Set<Voteit> voteits) {
        super(id);
        this.name = name;
        this.voteits = voteits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tag tag = (Tag) o;
        return name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
