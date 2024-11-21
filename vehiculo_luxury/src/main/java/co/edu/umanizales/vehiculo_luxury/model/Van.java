package co.edu.umanizales.vehiculo_luxury.model;

import co.edu.umanizales.vehiculo_luxury.model.interfaces.VehicleAble;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Van extends Vehicle implements VehicleAble {
    private short capacity;

    public Van(String type,String model, String registration, int km, boolean rented, double rentalValue, short capacity) {
        super(type,model, registration, km, rented, rentalValue);
        this.capacity=capacity;
    }

    public Van() {

    }

    //metodo rentar que lanza un mensaje de alquilado
    @Override
    public String rental() {
        return"You have rented the van";
    }

    //metodo para que a la hora de retornar un vehiculo este haga el llamado a calcular alquiler
    @Override
    public double returnVehicle() {
        return calculateRental(getKm());
    }

    //calcula el arriendo de acuerdo al numeros de kilometros el costo de arriendo y su capacidad
    @Override
    public double calculateRental(int km) {
        double totalRentalVan = 0;
        if(capacity >= 0){
            totalRentalVan = (km*getRentalValue())*(capacity*0.5);
        }
        else
            totalRentalVan = km*getRentalValue();
        return totalRentalVan;
    }

    //imprime los datos de los atributos
    @Override
    public String getData() {
        String data ="You have registered the following vehicle:"+ "\n"+
                "Type: " + getType() + "\n" +
                "Model: " + getModel() + "\n" +
                "Registration: " + getRegistration() + "\n" +
                "Mileage: " + getKm() + "\n" +
                "Rented: " + (isRented() ? "Yes" : "No") + "\n" +
                "Rental rate per kilometer: $" + getRentalValue() + "\n" +
                "Extra features: " + getCapacity() + "\n";
        System.out.println(data); ;
        return data;
    }
}
