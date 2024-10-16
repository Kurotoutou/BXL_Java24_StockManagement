package be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, OrderLine.OrderLineId> {
}
