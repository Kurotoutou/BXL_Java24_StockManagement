package be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.person;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "extern_type")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@Getter @Setter
public abstract class Extern extends Person {

    @Column(length = 17)
    private String phoneNumber;

    @Embedded
    private Address address;

    public Extern(UUID id, String firstName, String lastName, String email, String phoneNumber, Address address) {
        super(id, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
