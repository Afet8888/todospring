package home.afet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    int id;
    String title;
    String text;
    String date;
    boolean isDone;



}
