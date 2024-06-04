package Kotasek.PhotoContracts.repositories;

import Kotasek.PhotoContracts.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
