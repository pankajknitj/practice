package main.lld.behavioral.chainofresponsibility;

import lombok.Data;

import static main.lld.behavioral.chainofresponsibility.LeaveApplication.LeaveType.PaternityLeave;
import static main.lld.behavioral.chainofresponsibility.LeaveApplication.LeaveType.SickLeave;

public class Director extends Employee{
    Director(LeaveApprover successor){
        super("Director",successor);
    }
    @Override
    public boolean processRequest(LeaveApplication leaveApplication) {
        if(PaternityLeave.equals(leaveApplication.getLeaveType())){
            approve(leaveApplication);
            return true;
        }
        return false;
    }
}
