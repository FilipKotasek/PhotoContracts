package Kotasek.PhotoContracts.services;

import Kotasek.PhotoContracts.dto.CustomerDTO;
import Kotasek.PhotoContracts.entities.CustomerEntity;
import Kotasek.PhotoContracts.mappers.CustomerMapper;
import Kotasek.PhotoContracts.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public CustomerDTO addCustomer(CustomerDTO customer) {
        CustomerEntity newCustomer=customerMapper.toEntity(customer);

        return customerMapper.toDTO(customerRepository.save(newCustomer));
    }

    @Override
    public CustomerDTO deleteCustomer(Long id) {
        CustomerEntity customerToDelete=customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        CustomerDTO deletedCustomer=customerMapper.toDTO(customerToDelete);
        customerRepository.delete(customerToDelete);
        return deletedCustomer;
    }

    @Override
    public CustomerDTO getCustomer(Long id) {

        CustomerEntity customer=customerRepository.getReferenceById(id);

        return customerMapper.toDTO(customer);
    }


    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<CustomerEntity> allCustomers=customerRepository.findAll();

        return customerMapper.toDTOS(allCustomers);
    }

    @Override
    public CustomerDTO editCustomer(Long id, CustomerDTO newData) {
        CustomerEntity customerEntity=customerRepository.getReferenceById(id);
        customerEntity.setId(id);
        return customerMapper.toDTO(customerRepository.save(customerEntity));

    }
}
