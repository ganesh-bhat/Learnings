package models;

import java.lang.Long;
import java.lang.String;
import play.db.ebean.Model;
import javax.

@Entity
public class TodoItem extends Model{
    public String text;
    public Long id;
}
