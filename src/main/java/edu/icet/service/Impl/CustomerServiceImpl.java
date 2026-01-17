package edu.icet.service.Impl;

import edu.icet.model.dto.CustomerDto;
import edu.icet.model.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDto customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        repository.save(customerEntity);
    }

    @Override
    public void updateCustomr(CustomerDto customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }

    @Override
    public CustomerDto getAllCustomers(String id) {
        return null;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<CustomerEntity> customerEntities = repository.findAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        customerEntities.forEach(customerEntity -> {
            CustomerDto customerDto = mapper.map(customerEntity, CustomerDto.class);
            customerDtos.add(customerDto);
        });
        return customerDtos;
    }
}
