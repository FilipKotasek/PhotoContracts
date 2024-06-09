package Kotasek.PhotoContracts.dto;

import Kotasek.PhotoContracts.entities.OrderEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private String name;

    @NotNull
    private Integer durationInHours;



}
