package be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.person;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.person.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
}
