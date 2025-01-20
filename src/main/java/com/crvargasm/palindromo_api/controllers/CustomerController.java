package com.crvargasm.palindromo_api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.crvargasm.palindromo_api.domain.Customer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * Controlador REST para POJO Customer
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
  private List<Customer> customers = new ArrayList<>(Arrays.asList(
      new Customer(123, "Gerardo López", "gerardol", "1234"),
      new Customer(456, "Alejandra García", "alejandrag", "4321"),
      new Customer(789, "Laura Sánchez", "lauras", "as123"),
      new Customer(234, "Carlos Martinez", "carlosm", "0osadlk")));

  @GetMapping
  public List<Customer> getCustomers() {
    return customers;
  }

  // @RequestMapping("/{username}", method=RequestMethod.GET)
  @GetMapping("/{username}")
  public Customer getCustomer(@PathVariable String username) {
    for (Customer customer : customers) {
      if (customer.getUsername().equalsIgnoreCase(username)) {
        return customer;
      }
    }
    return null;
  }

  @PostMapping
  public Customer postCustomer(@RequestBody Customer newCustomer) {
    customers.add(newCustomer);
    return newCustomer;
  }

  @PutMapping
  public Customer putCustomer(@RequestBody Customer editCustomer) {
    for (Customer customer : customers) {
      if (customer.getId() == editCustomer.getId()) {
        customer.setName(editCustomer.getName());
        customer.setUsername(editCustomer.getUsername());
        customer.setPassword(editCustomer.getPassword());
        return customer;
      }
    }
    return null;
  }

  @PatchMapping
  public Customer patchCustomer(@RequestBody Customer editCustomer) {
    for (Customer customer : customers) {
      if (customer.getId() == editCustomer.getId()) {
        if (editCustomer.getName() != null) {
          customer.setName(editCustomer.getName());
        }
        if (editCustomer.getUsername() != null) {
          customer.setUsername(editCustomer.getUsername());
        }
        if (editCustomer.getPassword() != null) {
          customer.setPassword(editCustomer.getPassword());
        }
        return customer;
      }
    }
    return null;
  }

  @DeleteMapping("/{idCustomer}")
  public Customer deleteCustomer(@PathVariable int idCustomer) {
    for (Customer customer : customers) {
      if (customer.getId() == idCustomer) {
        customers.remove(customer);
        return customer;
      }
    }
    return null;
  }
}
