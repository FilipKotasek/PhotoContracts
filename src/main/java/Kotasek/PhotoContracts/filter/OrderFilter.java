package Kotasek.PhotoContracts.filter;

import lombok.Data;

import java.time.LocalDate;

//podle ceho budu filtrovat

@Data
public class OrderFilter {

    private Long customerId;
    private Long packageId;
    private Double minPrice;
    private Double maxPrice;
    private boolean status;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int limit=20;

}
