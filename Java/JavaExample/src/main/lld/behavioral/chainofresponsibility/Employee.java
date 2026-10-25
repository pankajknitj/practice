package main.lld.behavioral.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class Employee extends LeaveApprover{
    private String name;

    Employee(String name, LeaveApprover successor){
        super(successor,name);
        this.name = name;
    }
}
