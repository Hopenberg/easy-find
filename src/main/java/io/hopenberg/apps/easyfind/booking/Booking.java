package io.hopenberg.apps.easyfind.booking;

import io.hopenberg.apps.easyfind.customer.Customer;
import io.hopenberg.apps.easyfind.garage.Garage;
import jakarta.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime beginning;
    private int duration;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    protected Booking() {
    }

    public Booking(LocalDateTime beginning, int duration, Garage garage, Customer customer) {
        this.beginning = beginning;
        this.duration = duration;
        this.garage = garage;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDateTime beginning) {
        this.beginning = beginning;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
