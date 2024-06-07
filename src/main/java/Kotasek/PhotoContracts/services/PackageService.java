package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.entities.PackageEntity;

import java.util.List;

public interface PackageService {

    public PackageDTO addPackage(PackageDTO packageDTO);

    public PackageDTO deletePackage(Long id);

    public List<PackageDTO> getAllPackages();

    public  PackageDTO getPackage(Long id);

    public PackageDTO editPackage(Long id,PackageDTO newData);

}
