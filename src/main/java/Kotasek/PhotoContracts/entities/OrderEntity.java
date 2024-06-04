package Kotasek.PhotoContracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private boolean status;

    @Column(nullable = true)
    private Double totalPrice;

    @Column(nullable = false)
    private LocalDate orderDate;

    @ManyToOne
    private PackageEntity photoPackage;

    @ManyToOne
    private CustomerEntity customer;
}
