package Kotasek.PhotoContracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer durationInHours;

    @OneToMany(mappedBy = "photoPackage")
    private List<OrderEntity> orders;
}
