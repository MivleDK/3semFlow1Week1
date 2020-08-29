package dto;

import entities.Employee;

public class EmployeeDTO {

    Long id;
    String name;
    String address;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.address = e.getAdress();
    }

    public EmployeeDTO() {
    }
    
    
    
    
}
