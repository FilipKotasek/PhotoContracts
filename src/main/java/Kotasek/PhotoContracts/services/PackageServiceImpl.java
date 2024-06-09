package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.entities.PackageEntity;
import Kotasek.PhotoContracts.mappers.PackageMapper;
import Kotasek.PhotoContracts.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.image.PackedColorModel;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PackageDTO> getAllPackages() {
        List<PackageEntity> packages=packageRepository.findAll();
        List<PackageDTO> packageDTOS=new ArrayList<>();
        for (PackageEntity onePackage: packages
             ) {
                packageDTOS.add(packageMapper.toDTO(onePackage));

        }
        return packageDTOS;
    }

    @Override
    public List<PackageDTO> getFilteredPackages(int limit) {
        Page<PackageEntity> PageOfPackages = packageRepository.findAll(PageRequest.of(0,limit));
        List<PackageEntity> result=PageOfPackages.getContent();
        return packageMapper.toDTOS(result);
    }

    @Override
    public PackageDTO getPackage(Long id) {
        PackageEntity entity=packageRepository.getReferenceById(id);

        return packageMapper.toDTO(entity);
    }

    @Override
    public PackageDTO editPackage(Long id, PackageDTO newData) {
        PackageEntity entity=packageRepository.getReferenceById(id);
        PackageEntity newDataEntity=packageMapper.toEntity(newData);
        newDataEntity.setId(entity.getId());
        PackageDTO updatedData=packageMapper.toDTO(packageRepository.save(newDataEntity));
        return updatedData;
    }
}
