package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.OrderDTO;
import Kotasek.PhotoContracts.entities.CustomerEntity;
import Kotasek.PhotoContracts.entities.OrderEntity;
import Kotasek.PhotoContracts.filter.OrderFilter;
import Kotasek.PhotoContracts.mappers.OrderMapper;
import Kotasek.PhotoContracts.repositories.CustomerRepository;
import Kotasek.PhotoContracts.repositories.OrderRepository;
import Kotasek.PhotoContracts.repositories.PackageRepository;
import Kotasek.PhotoContracts.specification.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PackageRepository packageRepository;


    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {

        OrderEntity order=orderMapper.toEntity(orderDTO);
        order.setCustomer(customerRepository.getReferenceById(orderDTO.getCustomerId()));
        order.setPhotoPackage(packageRepository.getReferenceById(orderDTO.getPhotoPackageId()));



        return orderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    public OrderDTO deleteOrder(Long id) {
        OrderEntity deletedEntity=orderRepository.findById(id).orElseThrow();
        OrderDTO deletedOrder=orderMapper.toDTO(deletedEntity);
        orderRepository.deleteById(id);
        return deletedOrder;
    }

    @Override
    public List<OrderDTO> getAllOrders(OrderFilter filter) {
        OrderSpecification orderSpecification=new OrderSpecification(filter);

        return orderRepository.findAll(orderSpecification,PageRequest.of(0, filter.getLimit()))
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());




    }

    @Override
    public OrderDTO getOrder(Long id) {
        OrderEntity order = orderRepository.getReferenceById(id);
        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO editOrder(Long id, OrderDTO newData) {
        OrderEntity order=orderMapper.toEntity(newData);
        order.setId(id);
        order.setCustomer(customerRepository.getReferenceById(newData.getCustomerId()));
        order.setPhotoPackage(packageRepository.getReferenceById(newData.getPhotoPackageId()));
        OrderEntity saved=orderRepository.save(order);
        OrderDTO editedOrder=orderMapper.toDTO(saved);
        return editedOrder;
    }
}
