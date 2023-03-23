package edu.iu.c322.customerservice.controller;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepo cusRepo;

    public CustomerController(CustomerRepo repo) {
        this.cusRepo = repo;
    }
    @GetMapping()
    public List<Customer> findAll() { return cusRepo.findAll(); }
    @PostMapping()
    public int create(@RequestBody Customer customer) { return cusRepo.create(customer); }

    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer, @PathVariable int id) {
        cusRepo.update(customer, id);
    }
}
