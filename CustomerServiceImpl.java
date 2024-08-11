package com.ToyotaWeb.Toyota.Service.impl;
import com.ToyotaWeb.Toyota.Model.Customer;
import com.ToyotaWeb.Toyota.Repository.CustomerRepository;
import com.ToyotaWeb.Toyota.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setVehicle_id(customer.getVehicle_id());
        existingCustomer.setPurchase_date(customer.getPurchase_date());
        existingCustomer.setPurchase_location(customer.getPurchase_location());
        existingCustomer.setPayment_method(customer.getPayment_method());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.deleteById(id);
    }
}
