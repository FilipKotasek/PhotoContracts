package Kotasek.PhotoContracts.controllers;

import Kotasek.PhotoContracts.dto.OrderDTO;
import Kotasek.PhotoContracts.filter.OrderFilter;
import Kotasek.PhotoContracts.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;
    @GetMapping("/orders")
    public List<OrderDTO> getOrders(OrderFilter filter) {

    return orderService.getAllOrders(filter);

    }

    @PostMapping("/order")
    public OrderDTO addOrder(@RequestBody OrderDTO newOrder) {

    return orderService.addOrder(newOrder);

    }

    @DeleteMapping("/order/{id}")
    public OrderDTO deleteOrder(@PathVariable Long id) {
        return  orderService.deleteOrder(id);
    }

    @GetMapping("/order/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {

        return orderService.getOrder(id);
    }

    @PutMapping("/order/{id}")
    public OrderDTO editOrder(@PathVariable Long id, OrderDTO editedData) {
        return orderService.editOrder(id,editedData);
    }

}
