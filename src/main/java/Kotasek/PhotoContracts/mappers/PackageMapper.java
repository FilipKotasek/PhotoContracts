package Kotasek.PhotoContracts.mappers;

import Kotasek.PhotoContracts.dto.PackageDTO;
import Kotasek.PhotoContracts.entities.PackageEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PackageMapper {

    public PackageDTO toDTO(PackageEntity packageEntity);

    public  PackageEntity toEntity(PackageDTO packageDTO);

    public List<PackageDTO> toDTOS(List<PackageEntity> entity);



}
