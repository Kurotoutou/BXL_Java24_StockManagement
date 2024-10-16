package be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.person;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class User extends Person {

    @Column(nullable = false)
    @Getter @Setter
    private String password;

    @ManyToMany
    private final Set<Role> roles = new HashSet<>();

    public User(UUID id, String firstName, String lastName, String email, String password) {
        super(id, firstName, lastName, email);
        this.password = password;
    }

    public Set<Role> getRoles() {
        return Set.copyOf(roles);
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }
}
