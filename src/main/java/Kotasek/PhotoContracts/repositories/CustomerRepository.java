package Kotasek.PhotoContracts.repositories;

import Kotasek.PhotoContracts.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
