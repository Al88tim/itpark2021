package LessonTwenty.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Employee {
    ;
    private String tabNumber;
    private String login;
    private String fullName;
    private Department department;
    private Position position;


}
