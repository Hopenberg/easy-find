package io.hopenberg.apps.easyfind.garage;

import io.hopenberg.apps.easyfind.customer.Customer;
import io.hopenberg.apps.easyfind.customer.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageRepository garageRepository;

    public GarageController(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @GetMapping
    List<Garage> showGarages() {
        return garageRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Garage> showGarage(@PathVariable int id) {
        return garageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Garage> addGarage(@RequestBody @Valid Garage toCreate) {
        Garage result = garageRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + + result.getId())).body(result);
    }
}
