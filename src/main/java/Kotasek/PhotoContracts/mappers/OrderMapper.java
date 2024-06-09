package Kotasek.PhotoContracts.mappers;

import Kotasek.PhotoContracts.dto.OrderDTO;
import Kotasek.PhotoContracts.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "customerId",source = "customer.id")
    @Mapping(target= "photoPackageId", source = "photoPackage.id")
    public OrderDTO toDTO(OrderEntity entity);
    @Mapping(target = "photoPackage",ignore = true)
    @Mapping(target = "customer", ignore = true)
    public OrderEntity toEntity(OrderDTO dto);
    public List<OrderDTO> toDTOS(List<OrderEntity> entityList);
    public List<OrderEntity> toEntities(List<OrderDTO> orderDTOList);

}
