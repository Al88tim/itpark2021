package LessonTwenty.dto;

import LessonTwenty.dto.EmployeeWrapper.Fields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldNameConstants
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = Fields.employees)
public class EmployeeWrapper {
    @XmlElement (name = "employee")
    private List<Employee> employees;

}
