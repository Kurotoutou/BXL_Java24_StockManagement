package be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.person;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Role extends BaseEntity {

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    public Role(UUID id, String name) {
        super(id);
        this.name = name;
    }
}
