package Kotasek.PhotoContracts.dto;

import Kotasek.PhotoContracts.entities.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {


    private Long id;

    private String description;

    private Double price;

    private String name;

    private Integer durationInHours;



}
