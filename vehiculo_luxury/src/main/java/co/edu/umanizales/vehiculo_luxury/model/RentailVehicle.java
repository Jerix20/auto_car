package co.edu.umanizales.vehiculo_luxury.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class RentailVehicle {
    private String vehicle;
    private String model;
    private String registerUser;
    private String rentalDate;
    private String rentalReturn;
    private String customerName;
}
