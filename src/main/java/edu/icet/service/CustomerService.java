package edu.icet.service;

import edu.icet.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDto customer);
    void updateCustomr(CustomerDto customer);
    void deleteCustomer(String id);
    CustomerDto getAllCustomers(String id);
    List<CustomerDto> getCustomers();
}
