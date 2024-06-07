package Kotasek.PhotoContracts.controllers;

import Kotasek.PhotoContracts.dto.CustomerDTO;
import Kotasek.PhotoContracts.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping("/customer")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
    return customerService.addCustomer(customerDTO);
}

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomer(Long id) {

    return customerService.getCustomer(id);
}

    @DeleteMapping("/customer/{id}")
    public CustomerDTO deleteCustomer(@PathVariable Long id) {

    return customerService.deleteCustomer(id);
}

    @PutMapping("/customer/{id}")
    public CustomerDTO editCustomer(Long id, CustomerDTO data){

    return customerService.editCustomer(id,data);
}

    @GetMapping("/customers")
    public List<CustomerDTO> getCustomers(){
    return customerService.getAllCustomers();
}

}
