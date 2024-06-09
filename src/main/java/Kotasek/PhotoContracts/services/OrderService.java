package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    public OrderDTO addOrder(OrderDTO orderDTO);

    public OrderDTO deleteOrder(Long id);

    public List<OrderDTO> getAllOrders();

    public OrderDTO getOrder(Long id);

    public OrderDTO editOrder(Long id, OrderDTO newData);


}
