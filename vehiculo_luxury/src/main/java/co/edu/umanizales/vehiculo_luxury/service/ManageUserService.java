package co.edu.umanizales.vehiculo_luxury.service;

import co.edu.umanizales.vehiculo_luxury.model.Customer;
import co.edu.umanizales.vehiculo_luxury.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Data
@Service
public class ManageUserService {

    private List<User> user = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    //creamos una lista de usuarios antes de ejecutar el Api
    public void lstUsers(){
        user.add(new User("001","Isabel Trujillo",
                "isabelt@rentail.com","isabelita2230"));
        user.add(new User("002","Maria Alejandra Sanabria",
                "malejandras@rentail.com","malejandra1910"));
        user.add(new User("003","Jeronimo Soto",
                "jeros@rentail.com","jerito1910"));
        user.add(new User("004","Sebastian Loaiza",
                "sebasl@rentail.com","sebitas2519"));
        user.add(new User("005","Maria Fernanda Grisales",
                "mfernandag@rential.com","mafesita2320"));
    }

    //creamos una lista de clientes antes de ejecutar el Api
    public void lstCustomers(){
        customers.add(new Customer("439","Samuel Vanegas"));
        customers.add(new Customer("937","Lucas Rueda"));
        customers.add(new Customer("725","Leonardo Aguilar"));
        customers.add(new Customer("932","Juan José Giraldo"));
        customers.add(new Customer("982","Andres Guerra"));
    }

    public void registerUsers(User user1) {
        user.add(user1);
    }

    public void registerCustomers(Customer customer1) {
        customers.add(customer1);
    }
    public List<User> getUsers() {
        lstUsers();
        return user;
    }

    public List<Customer> getCustomers() {
        lstCustomers();
        return customers;
    }

    //metodo para validar un usuario verificando si el login y el password son iguales o sino de cada usuario
    //en la lista
    public String validateUser(String login, String password) {
        for (User user : user) {
            /*al recorrer la lista verifica si el login y password son iguales para retornar un mensaje de
            bienvenida*/
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return "Welcome back user";
            }
        }
        return "Email or password incorrect";
    }

}
