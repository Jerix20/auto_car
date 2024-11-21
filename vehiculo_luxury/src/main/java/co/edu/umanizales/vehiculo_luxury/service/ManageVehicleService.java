package co.edu.umanizales.vehiculo_luxury.service;

import co.edu.umanizales.vehiculo_luxury.model.Car;
import co.edu.umanizales.vehiculo_luxury.model.Motorcycle;
import co.edu.umanizales.vehiculo_luxury.model.Van;
import co.edu.umanizales.vehiculo_luxury.model.Vehicle;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
@Service
public class ManageVehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();
    //creamos una lista de vehiculos antes de ejecutar el Api
    public void lstVehicles() {
        vehicles.add(new Car("Car","Dodge", "LPT666", 30000, false,
                50000.0, true));
        vehicles.add(new Van("Van","Miniban", "KNS735", 10000, true,
                50000.0, (short) 8));
        vehicles.add(new Motorcycle("Motorcycle","Suzuki", "DDD67F", 5000, true,
                50000.0, true ));
        vehicles.add(new Car("Car","Toyota", "JVS348", 10500, true,
                50000.0, true));
        vehicles.add(new Van("Van","Cargo C35", "BDE892", 10000, true,
                50000.0, (short) 8));
        vehicles.add(new Motorcycle("Motorcycle","Nmax", "GHT88E", 2000, false,
                50000.0, true ));

    }
    //metodo que hace llamado a la lista de vehiculos para que esta sea cargado en el API
    public List<Vehicle> loadVehicles(){
        lstVehicles();
        return vehicles;
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);

    }

    public List<Vehicle> getVehicleByRented(){
        List<Vehicle> vehiclesRented = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            //isRented verifica si el boolean es true
            if (vehicle.isRented()) {
                vehiclesRented.add(vehicle);
            }
        }
        return vehiclesRented;
    }
    public List<Vehicle> getVehicleNotRental(){
        List<Vehicle> vehiclesNotRented = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            //el signo de interrogacion sirve para identificar un valor diferente a tru en este caso false
            if (!vehicle.isRented()) {
                vehiclesNotRented.add(vehicle);
            }
        }
        return vehiclesNotRented;
    }
    //metodo para obtener vehiculo por tipo y si esta o no alquilado
    public List<Vehicle> getVehycleBytypeAndRented(String type, boolean rented){
        List<Vehicle> vehiclesType = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            //condicional que dice que si el tipo es igual al dado lo mismo para el rented
            if (vehicle.getType().equals(type)&& vehicle.isRented() == rented) {
                vehiclesType.add(vehicle);
            }
        }
        return vehiclesType;
    }
    //metodo que borra un vehiculo de el arraylist
    public String deleteVehicle(String model, String registration) {
        for (int i = vehicles.size() - 1; i >= 0; i--) { //obtiene el vehiculo en esa posicion para eliminarlo
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getModel().equals(model) && vehicle.getRegistration().equals(registration)) {
                vehicles.remove(i);
                return "Vehicle deleted successfully";
            }
        }
        return "Vehicle not found";
    }

}