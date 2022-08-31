package exect.junit;

import exect.domain.Employee;
import exect.service.NameListService;
import exect.service.TeamException;
import org.junit.jupiter.api.Test;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service=new NameListService();
        Employee[] employees=service.getAllEmployees();
        for (Employee value : employees) {
            System.out.println(value);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService service=new NameListService();
        int id=101;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
