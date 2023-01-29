package io.hopenberg.apps.easyfind.booking;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    List<Booking> showBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Booking> showBooking(@PathVariable int id) {
        return bookingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Booking> addBooking(@RequestBody @Valid Booking toCreate) {
        Booking result = bookingRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + + result.getId())).body(result);
    }
}
