package Kotasek.PhotoContracts.repositories;

import Kotasek.PhotoContracts.entities.OrderEntity;
import Kotasek.PhotoContracts.specification.OrderSpecification;
import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Arrays;

public interface OrderRepository extends JpaRepository<OrderEntity,Long>, JpaSpecificationExecutor<OrderEntity> {


}
