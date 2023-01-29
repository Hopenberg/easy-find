package io.hopenberg.apps.easyfind.customer;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    List<Customer> showCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> showCustomer(@PathVariable int id) {
        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer toCreate) {
        Customer result = customerRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + + result.getId())).body(result);
    }
}
