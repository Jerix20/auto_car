package co.edu.umanizales.vehiculo_luxury.controller;

import co.edu.umanizales.vehiculo_luxury.model.*;
import co.edu.umanizales.vehiculo_luxury.service.ManageUserService;
import co.edu.umanizales.vehiculo_luxury.service.ManageVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/vehicle_rentail")
public class RentailVehicleController {

    @Autowired
    private ManageUserService manageUserService;
    @Autowired
    private ManageVehicleService manageVehicleService;

    @PostMapping("/registeruser")
    public String registerUser(@RequestBody User user) {
        manageUserService.registerUsers(user);
        return "User added successfully";
    }

    @PostMapping("/registercustomer")
    public String registerCustomer(@RequestBody Customer customer) {
        manageUserService.registerCustomers(customer);
        return "Customer added successfully";
    }

    @GetMapping("/getusers")
    public List<User> getUsers() {
        return manageUserService.getUsers();
    }

    @GetMapping("/getcustomer")
    public List<Customer> getCustomers() {
        return manageUserService.getCustomers();
    }

    @PostMapping("/validateuser/{login}/{password}")
    public String validateUser(@PathVariable String login, @PathVariable String password) {
        return manageUserService.validateUser(login, password);
    }

    @PostMapping("/systemstars")
    public String systemStars(@RequestBody TypeUser typeUser) {
        return typeUser.systemAdvice();
    }

    @PostMapping("/addmotorcycle")
    public String addMotorcycle(@RequestBody Motorcycle motorcycle) {
        manageVehicleService.addVehicle(motorcycle);
        return motorcycle.getData();
    }

    @PostMapping("/addcar")
    public String addCar(@RequestBody Car car) {
        manageVehicleService.addVehicle(car);
        return car.getData();
    }

    @PostMapping("/addvan")
    public String addVan(@RequestBody Van van) {
        manageVehicleService.addVehicle(van);
        return van.getData();
    }

    @GetMapping("/getvehicle")
    public List<Vehicle> getVehicles() {
        return manageVehicleService.getVehicles();
    }

    @PostMapping("/getlstvehicles")
    public List<Vehicle> getlstVehicles() {
        return manageVehicleService.loadVehicles();
    }

    @GetMapping("/getvehiclesrental")
    public List<Vehicle> getVehiclesRental() {
        return manageVehicleService.getVehicleByRented();
    }

    @GetMapping("/getvehiclesnotrental")
    public List<Vehicle> getVehiclesNoRental() {
        return manageVehicleService.getVehicleNotRental();
    }

    List<RentailVehicle> rentailVehicles = new ArrayList<>();

    @PostMapping("/rentialvehicle")
    public String rentalVehicle(@RequestBody RentailVehicle rentailVehicle) {
        Car car = new Car();
        Van van = new Van();
        Motorcycle moto = new Motorcycle();
        String rentalMessage = null;

        if (rentailVehicle.getVehicle().equals("car")) {
            rentalMessage = car.rental();
        } else if (rentailVehicle.getVehicle().equals("van")) {
            rentalMessage = van.rental();
        } else if (rentailVehicle.getVehicle().equals("motorcycle")) {
            rentalMessage = moto.rental();
        }

        rentailVehicles.add(rentailVehicle);
        return rentalMessage;
    }

    @GetMapping("/getrentailvehicle")
    public List<RentailVehicle> getRentailVehicles() {
        return rentailVehicles;
    }

    @GetMapping("/getvehiclebytypeandrented/{type}/{rented}")
    public List<Vehicle> getVehiclesByTypeAndRented(@PathVariable String type, @PathVariable boolean rented) {
        return manageVehicleService.getVehycleBytypeAndRented(type, rented);
    }

    @DeleteMapping("/deletevehicle/{model}/{registration}")
    public String deleteVehicle(@PathVariable String model, @PathVariable String registration) {
        return manageVehicleService.deleteVehicle(model, registration);
    }

    @PostMapping("/returncar")
    public String returnVehicle(@RequestBody Car car) {
        double rentalCar = car.returnVehicle();
        return "Car rental cost: " + rentalCar;
    }

    @PostMapping("/returnvan")
    public String returnVan(@RequestBody Van van) {
        double rentalVan = van.returnVehicle();
        return "Motorcycle rental cost: " + rentalVan;
    }

    @PostMapping("/returnmotorcycle")
    public String returnMotorcycle(@RequestBody Motorcycle motorcycle) {
        double rentalMotorcycle = motorcycle.returnVehicle();
        return "Motorcycle rental cost: " + rentalMotorcycle;
    }
}