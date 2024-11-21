package co.edu.umanizales.vehiculo_luxury.model;

import co.edu.umanizales.vehiculo_luxury.model.interfaces.VehicleAble;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Motorcycle extends Vehicle implements VehicleAble {
    private boolean helmet;

    public Motorcycle(String type,String model, String registration, int km, boolean rented, double rentalValue, boolean helmet) {
        super(type,model, registration, km, rented, rentalValue);
        this.helmet = helmet;
    }

    public Motorcycle() {

    }
    @Override
    public String rental() {
        return "You have rented the motorcycle";
    }

    @Override
    public double returnVehicle() {
        return calculateRental(getKm());
    }

    @Override
    public double calculateRental(int km) {
        double totalRentalMot=0;
        if(helmet)
            totalRentalMot= (km*getRentalValue())*1.5;
        else
            totalRentalMot= km*getRentalValue();
        return totalRentalMot;
    }

    @Override
    public String getData() {
        String data ="You have registered the following vehicle:"+ "\n"+
                "Type: " + getType() + "\n" +
                "Model: " + getModel() + "\n" +
                "Registration: " + getRegistration() + "\n" +
                "Mileage: " + getKm() + "\n" +
                "Rented: " + (isRented() ? "Yes" : "No") + "\n" +
                "Rental rate per kilometer: $" + getRentalValue() + "\n" +
                "Extra features: " + (helmet ? "Yes" : "No");
        System.out.println(data); ;
        return data;
    }
}