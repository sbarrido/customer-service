package edu.iu.c322.customerservice.repository;

import edu.iu.c322.customerservice.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo {
    private List<Customer> cusRepo = new ArrayList<>();

    public List<Customer> findAll() { return cusRepo; }

    public int create(Customer customer) {
        int id = cusRepo.size() + 1;
        customer.setId(id);
        cusRepo.add(customer);

        return id;
    }

   public void update(Customer customer, int id) {
        Customer target = getCusByID(id);
        if(target != null) {
            target.setName(customer.getName());
            target.setEmail(customer.getEmail());
        }
   }

   public void delete(int id) {
        Customer target = getCusByID(id);
        if(target != null) {
            cusRepo.remove(target);
        }
   }
   private Customer getCusByID(int id) {
        return cusRepo.stream().filter(target -> target.getId() == id).findAny().orElse(null);
   }
}
