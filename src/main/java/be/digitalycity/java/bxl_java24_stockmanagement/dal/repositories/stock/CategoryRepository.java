package be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
