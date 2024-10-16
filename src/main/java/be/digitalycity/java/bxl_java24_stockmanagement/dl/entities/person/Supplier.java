package be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.person;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@DiscriminatorValue("supplier")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Supplier extends Extern {

    public Supplier(UUID id, String firstName, String lastName, String email, String phoneNumber, Address address) {
        super(id, firstName, lastName, email, phoneNumber, address);
    }
}
