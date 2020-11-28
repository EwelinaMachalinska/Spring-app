package newprojectspring.demo.service;

import newprojectspring.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer createNewCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomerById(Long id,Customer customer);

    List<Customer> createBatchOfPersonnel(List<Customer> customers);

    boolean removeCustomerById(Long id);

}
