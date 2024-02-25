package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ToDoListRepo {

    public Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/toDoList", "postgres", "admin");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
