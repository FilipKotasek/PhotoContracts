package Kotasek.PhotoContracts.repositories;

import Kotasek.PhotoContracts.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageEntity,Long> {
}
