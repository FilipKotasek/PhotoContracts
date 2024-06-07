package Kotasek.PhotoContracts.mappers;

import Kotasek.PhotoContracts.dto.CustomerDTO;
import Kotasek.PhotoContracts.entities.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(CustomerEntity entity);
    CustomerEntity toEntity(CustomerDTO dto);

    List<CustomerDTO> toDTOS(List<CustomerEntity> customers);


}
