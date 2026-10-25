package main.lld.behavioral.chainofresponsibility;

import lombok.Data;

import static main.lld.behavioral.chainofresponsibility.LeaveApplication.LeaveType.CasualLeave;
import static main.lld.behavioral.chainofresponsibility.LeaveApplication.LeaveType.SickLeave;

public class Manger extends Employee{
    Manger(LeaveApprover successor){
        super("Manger",successor);
    }
    @Override
    public boolean processRequest(LeaveApplication leaveApplication) {
        if(CasualLeave.equals(leaveApplication.getLeaveType()) && leaveApplication.getDuration() <= 2){
            approve(leaveApplication);
            return true;
        }
        return false;
    }
}
