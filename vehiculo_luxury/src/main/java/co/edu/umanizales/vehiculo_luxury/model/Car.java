package co.edu.umanizales.vehiculo_luxury.model;

import co.edu.umanizales.vehiculo_luxury.model.interfaces.VehicleAble;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Car extends Vehicle implements VehicleAble {
    private boolean extra;
    public Car(String type,String model, String registration, int km, boolean rented,
               double rentalValue, boolean extra) {
        super(type,model, registration, km, rented, rentalValue);
        this.extra = extra;
    }

    public Car() {

    }

    @Override
    public String rental() {

        return "You have rented the car";
    }

    @Override
    public double returnVehicle() {
        return calculateRental(getKm());
    }

    @Override
    public double calculateRental(int km){
        double totalRentalCar= 0;
        if (extra)
            totalRentalCar= (km*getRentalValue())*1.5;
        else
            totalRentalCar= km*getRentalValue();
        return totalRentalCar;
    }

    @Override
    public String getData() {
        String data ="You have registered the following vehicle"+ "\n"+
                "Type: " + getType() + "\n" +
                "Model: " + getModel() + "\n" +
                "Registration: " + getRegistration() + "\n" +
                "Mileage: " + getKm() + "\n" +
                "Rented: " + (isRented() ? "Yes" : "No") + "\n" +
                "Rental rate per kilometer: $" + getRentalValue() + "\n" +
                "Extra features: " + (extra ? "Yes" : "No");
        System.out.println(data); ;
        return data;
    }
}
