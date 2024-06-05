package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.entities.PackageEntity;

public interface PackageService {

    public PackageDTO addPackage(PackageDTO packageDTO);

    public PackageDTO deletePackage(Long id);

}
