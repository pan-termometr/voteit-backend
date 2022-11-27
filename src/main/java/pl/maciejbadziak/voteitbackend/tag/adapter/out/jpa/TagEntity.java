package pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tag")
public class TagEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tagname", length = 30, nullable = false, unique = true)
    private String tagname;
}
