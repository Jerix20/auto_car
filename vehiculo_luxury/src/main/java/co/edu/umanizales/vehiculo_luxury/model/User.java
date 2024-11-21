package co.edu.umanizales.vehiculo_luxury.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String identification;
    private String name;
    private String login;
    private String password;
}
