package main.lld.behavioral.chainofresponsibility;

import lombok.Data;

import static main.lld.behavioral.chainofresponsibility.LeaveApplication.LeaveType.SickLeave;

public class Lead extends Employee{
    Lead(LeaveApprover successor){
        super("Lead",successor);
    }
    @Override
    public boolean processRequest(LeaveApplication leaveApplication) {
        if(SickLeave.equals(leaveApplication.getLeaveType()) && leaveApplication.getDuration() <= 2){
            approve(leaveApplication);
            return true;
        }
        return false;
    }
}
