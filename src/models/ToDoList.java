package models;

import enums.ToDoListStatus;

public class ToDoList {

    private  int id;
    private ToDoListStatus status;
    private String description;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public ToDoListStatus getStatus() {
        return status;
    }

    public void setStatus(ToDoListStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String status = getStatus().equals(ToDoListStatus.DONE)?"Выполнено":"Не выполнено";
        return "id: " + getId() + " - ["+ status +"]"+getDescription();
    }
}
