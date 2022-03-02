package LessonTwenty;

import LessonTwenty.dto.Department;
import LessonTwenty.dto.Employee;
import LessonTwenty.dto.EmployeeWrapper;
import LessonTwenty.dto.Position;
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EmployeeRunner {
    private static final List<Department> DEPARTMENTS = List.of(new Department("R&A", "SPb"),
            new Department("Sales", "SPb"),
            new Department("Commercial", "SPb"));

    private static final List<Position> POSITIONS = List.of(new Position("Comm Director", new BigDecimal(40000)),
            new Position("Manager", new BigDecimal(30000)),
            new Position("Jr.Manager", new BigDecimal(20000)),
            new Position("Administrator", new BigDecimal(10000)),
            new Position("Staff", new BigDecimal(5000)));

    private static int COUNTER = 1;


    public static void main(String[] args) {
        System.out.println("Запуск программы");


        EmployeeWrapper employees =
                new EmployeeWrapper(List.of(
                        getEmployee("Попов Руслан Витальевич"),
                        getEmployee("Синев Вячеслав Геннадьевич"),
                        getEmployee("Зарубин Анатолий Витальевич"),
                        getEmployee("Кашубин Роман Владимирович")));
        Path path = Paths.get("C:\\test\\employee.xml");
        Path parentPath = path.getParent();
        System.out.printf("Попытка создания родительской директории %s/n", parentPath);

        if (!parentPath.toFile().exists()) {
            path.getParent().toFile().mkdirs();
        }
        System.out.printf("Маршалинг данных в файл %s/n", path.getFileName());
        JAXB.marshal(employees, path.toFile());
        Document document = getDocument(path.toFile());
        Integer averageSalary = getAverageSalary(document);
        System.out.printf("Сотрудники с зарплатой выше среднего %d\n", averageSalary);
        List<Employee> employeeList = searchEmployeeWithMoreAverageSalary(document, averageSalary);
    }
    private static Employee getEmployee(String fullName) {

        return new Employee().setLogin("user" + COUNTER++)
                .setFullName("Попов Руслан Витальевич")
                .setTabNumber(new Random().nextInt(100_000) + "")
                .setDepartment(DEPARTMENTS.get(new Random().nextInt(DEPARTMENTS.size())))
                .setPosition(POSITIONS.get(new Random().nextInt(POSITIONS.size())));

    }

    @SneakyThrows
    private static List<Employee> searchEmployeeWithMoreAverageSalary(Document doc,int salary) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        NodeList nodeList = (NodeList) xPathFactory.newXPath().compile("//employee/position[@salary >"
                +salary+"]/ancestor::employee").evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength();i++){
            Node item = nodeList.item(i);
            if (item.getNodeType()== Node.ELEMENT_NODE){
                System.out.println(((Element)item).getTextContent());
            }
        }

        return Collections.emptyList();
    }
    @SneakyThrows
    private static Integer getAverageSalary(Document doc) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        Double result = (Double) xPathFactory.newXPath().compile("sum(//position/@salary)div count(//position)")
                .evaluate(doc, XPathConstants.NUMBER);
        return result != null ? result.intValue() : 0;

    }

    @SneakyThrows
    private static Document getDocument(File file)  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        return documentBuilder.parse(file);
    }
}

