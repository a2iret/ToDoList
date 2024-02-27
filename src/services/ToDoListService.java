package services;

import enums.ToDoListStatus;
import models.ToDoList;
import repository.ToDoListRepo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToDoListService {

    ToDoListRepo repo = new ToDoListRepo();
    Connection connection = repo.createConnection();

    public void createToDoList(String description){
        try {
            Statement st =  connection.createStatement();
            st.execute("INSERT INTO toDoList(status, description)VALUES('"+ ToDoListStatus.IN_PROCESS.name() + "', '"+ description +"')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String updateToDoList(int id, String description){
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE toDoList SET description = '"+description+"' WHERE id = '"+id+"'");
            return "\nЗадача успешно отредактирована!\n";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return "Oшибка!";
    }

    public String deleteToDoList(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE toDoList  SET status = '"+ToDoListStatus.DELETED.name()+"' WHERE id = '"+id+"'");
            return "\nВаша задача под идентификатором "+id+" успешно удаленна!\n";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return "Ошибка!";
    }

    public String  showAllNotes(){
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT id, description, "
                    + "CASE WHEN status = 'DONE' THEN '[выполнено]'"
                    + " WHEN status = 'IN_PROCESS' THEN '[не выполнено]' END AS status"
                    + " FROM toDoList");
            while (res.next()){
                int id = res.getInt("id");
                String description = res.getString("description");
                String status = res.getString("status");
                if (status == null)
                    continue;
                System.out.println("id: " + id + " "+ status+""+description);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String completeTask(int id){
        try {
            Statement st = connection.createStatement();
            st.execute("UPDATE toDoList SET status ='"+ToDoListStatus.DONE.name()+"' WHERE id = '"+id+"'");
            return "\nМолодец!Ты выполнил(-а) задание! под идентификатором: " + id + "\n";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return "Ошибка!";
    }
}
