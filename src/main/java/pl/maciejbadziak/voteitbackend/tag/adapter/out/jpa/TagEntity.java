package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "tag")
public class TagEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tagname", length = 30, nullable = false, unique = true)
    private String tagname;
}
