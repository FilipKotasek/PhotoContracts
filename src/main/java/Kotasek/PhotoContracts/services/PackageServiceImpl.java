package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.entities.PackageEntity;
import Kotasek.PhotoContracts.mappers.PackageMapper;
import Kotasek.PhotoContracts.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.PackedColorModel;

@Service
public class PackageServiceImpl implements PackageService{

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    PackageMapper packageMapper;
    @Override
    public PackageDTO addPackage(PackageDTO packageDTO) {
        PackageEntity entity= packageMapper.toEntity(packageDTO);
        PackageEntity savedEntity=packageRepository.save(entity);
       return packageMapper.toDTO(savedEntity);
    }

    @Override
    public PackageDTO deletePackage(Long id) {
        PackageEntity entity=packageRepository.getReferenceById(id);
        PackageDTO deletedPackage=packageMapper.toDTO(entity);
        packageRepository.deleteById(id);
        return deletedPackage;

    }
}
