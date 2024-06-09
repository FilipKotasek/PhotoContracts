package Kotasek.PhotoContracts.dto;

import Kotasek.PhotoContracts.entities.CustomerEntity;
import Kotasek.PhotoContracts.entities.PackageEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {

    @NotNull
    private Long id;
    private boolean status;
    private Double totalPrice;

    private LocalDate orderDate;

    @NotNull
    private Long photoPackageId;

    @NotNull
    private Long customerId;

    private PackageDTO photoPackage;
    private CustomerDTO customer;


}
