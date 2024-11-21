package co.edu.umanizales.vehiculo_luxury.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Objects;

@AllArgsConstructor
@Data

public class TypeUser {
    private String code;
    private String name;
    private String description;

    public String systemAdvice(){
        if(Objects.equals(description, "administrator")){
            return "Welcome administrator " + name + " your functions are: " + "\n"+
                    "1. Manage vehicle data"+"\n"+
                    "2. Register vehicle data"+"\n"+
                    "3. Register and delete user data";
        }
        if (Objects.equals(description, "user")){
            return "Welcome " + name + " your role as a user is: " + "\n"+
                    "1. Manipulate vehicle data if it is rented or not"+"\n"+
                    "2. Calculate the total rental for each customer"+"\n"+
                    "3. Rent vehicles for each customer";
        }
        if (Objects.equals(description, "client")){
            return "Welcome client " + name + " you can do the following:" + "\n"+
                    "1. View rented vehicle data"+"\n"+
                    "2. View vehicle data by type"+"\n"+
                    "3. Request a rental from the user ";
        }
        return "Invalid user";
    }
}