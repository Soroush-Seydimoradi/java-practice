import java.util.ArrayList;
import java.util.List;

public class DatabaseDemo {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.connect();

        Employee e1 = new Employee(null, "soroush", 27, 22200000l);
        Employee e2 = new Employee(null, "soroushSeydimoradi", 28, 1000000000l);
        Employee e3 = new Employee(null, "Seydimoradi", 29, 454500000000l);

//        Long e1Id = employeeDAO.insertNewEmployee(e1);
//        System.out.println("e1Id"+ e1Id);
//        Long e2Id = employeeDAO.insertNewEmployee(e2);
//        System.out.println("e2Id"+ e2Id);
//        Long e3Id = employeeDAO.insertNewEmployee(e3);
//        System.out.println("e3Id"+ e3Id);
//        int result = employeeDAO.updateEmployee(1l, 75000l);
//        System.out.println("update result:"+result);
        List<Employee> employees = employeeDAO.filterByAge(25);
//        System.out.println(employees);
        List<Employee> allEmployees = employeeDAO.getAll();
        Employee filterEmpById = employeeDAO.getById(2l);
        int deleteResult = employeeDAO.deleteEmployee(4l);




        System.out.println(deleteResult);
    }
}
