package Kotasek.PhotoContracts.specification;

import Kotasek.PhotoContracts.entities.*;
import Kotasek.PhotoContracts.entities.CustomerEntity_;
import Kotasek.PhotoContracts.entities.OrderEntity_;
import Kotasek.PhotoContracts.entities.PackageEntity_;
import Kotasek.PhotoContracts.filter.OrderFilter;
import jakarta.persistence.criteria.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OrderSpecification implements Specification<OrderEntity> {

    private final OrderFilter filter;



    @Override
    public Predicate toPredicate(Root<OrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates=new ArrayList<>();

        if (filter.getPackageId() != null) {

            Join<OrderEntity, PackageEntity> joinPackage= root.join(OrderEntity_.PHOTO_PACKAGE);
            predicates.add(criteriaBuilder.equal(joinPackage.get(PackageEntity_.ID),filter.getPackageId()));
        }

        if (filter.getMinPrice() !=null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(OrderEntity_.TOTAL_PRICE), filter.getMinPrice()));
        }

        if (filter.isStatus()) {

            predicates.add(criteriaBuilder.equal(root.get(OrderEntity_.STATUS),filter.isStatus()));

        }

        if (filter.getMaxPrice() != null) {

            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(OrderEntity_.TOTAL_PRICE),filter.getMaxPrice()));

        }

        if (filter.getFromDate() != null) {

            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(OrderEntity_.ORDER_DATE),filter.getFromDate()));

        }

        if (filter.getToDate() != null){

            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(OrderEntity_.ORDER_DATE),filter.getFromDate()));

        }

        if (filter.getCustomerId() !=  null) {

            Join<CustomerEntity,OrderEntity> customerJoin=root.join(OrderEntity_.CUSTOMER);
            predicates.add(criteriaBuilder.equal(customerJoin.get(CustomerEntity_.ID),filter.getCustomerId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
