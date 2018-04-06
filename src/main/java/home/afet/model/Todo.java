package home.afet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {

    int id;
    String title;
    String text;
    String date;
    boolean isDone;



}
