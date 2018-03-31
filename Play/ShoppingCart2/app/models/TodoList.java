package models;
import java.util.List;
import play.db.ebean.Model;

public class TodoList extends Model {
    public List<TodoItem> todoItems;


}