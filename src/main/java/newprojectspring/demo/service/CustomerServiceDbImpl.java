package newprojectspring.demo.service;

import lombok.extern.slf4j.Slf4j;
import newprojectspring.demo.model.Customer;
import newprojectspring.demo.repository.CustomerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("!old")
@Service
@Scope("prototype")
@Slf4j
public class CustomerServiceDbImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceDbImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
        if (customerRepository.existsById(id)){
            customer.setCustomerId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public List<Customer> createBatchOfPersonnel(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public boolean removeCustomerById(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}
