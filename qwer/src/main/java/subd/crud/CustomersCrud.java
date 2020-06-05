package subd.crud;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Customers;
import subd.repository.CustomersRepository;

public class CustomersCrud {
    public CustomersRepository customersRepository;

    public void createCustomers(Integer id , String last_name, String first_name, Integer phone_number) {
        Customers customers = new Customers(id,last_name,first_name,phone_number);
        customersRepository.save(customers);
    }

    public void readCustomers() {
        for ( Customers customers: customersRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(customers);
        }
    }
    public void deleteOrders() {
        customersRepository.deleteById(1);
    }

    public void updateCustomers(Integer id , String last_name, String first_name, Integer phone_number) {
        Customers customers = new Customers(id,last_name,first_name,phone_number);
        customersRepository.save(customers);
    }

}
