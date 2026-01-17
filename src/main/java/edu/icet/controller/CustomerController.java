package edu.icet.controller;

import edu.icet.model.dto.CustomerDto;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @PostMapping("/add")
    public void addCUstomer(@RequestBody CustomerDto customer){
        customerService.addCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody CustomerDto customer){
        customerService.updateCustomr(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomr(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @GetMapping("/search")
    public List<CustomerDto> getAllCustomer(){
        return customerService.getCustomers();
    }

    @GetMapping("search-by-id/{id}")
    public CustomerDto getCustomerById(@PathVariable String id){
        return customerService.getAllCustomers(id);
    }
}
