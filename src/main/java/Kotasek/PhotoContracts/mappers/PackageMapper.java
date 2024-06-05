package Kotasek.PhotoContracts.mappers;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.entities.PackageEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PackageMapper {

    public PackageDTO toDTO(PackageEntity packageEntity);

    public  PackageEntity toEntity(PackageDTO packageDTO);



}
