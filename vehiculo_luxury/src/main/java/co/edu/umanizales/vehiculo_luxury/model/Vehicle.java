package co.edu.umanizales.vehiculo_luxury.model;

import co.edu.umanizales.vehiculo_luxury.model.interfaces.VehicleAble;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public abstract class Vehicle implements VehicleAble {
    private String type;
    private String model;
    private String registration;
    private int km;
    private boolean rented;
    private double rentalValue;

    public Vehicle() {}

    @Override
    public double calculateRental(int km) {
        return km * rentalValue;
    }

}
