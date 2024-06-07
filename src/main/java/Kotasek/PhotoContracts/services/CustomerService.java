package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO addCustomer(CustomerDTO customer);
    CustomerDTO deleteCustomer(Long id);

    CustomerDTO getCustomer(Long id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO editCustomer(Long id, CustomerDTO newData);

}
