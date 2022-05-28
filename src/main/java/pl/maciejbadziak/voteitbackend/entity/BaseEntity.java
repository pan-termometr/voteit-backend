package pl.maciejbadziak.voteitbackend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private long id;

}
