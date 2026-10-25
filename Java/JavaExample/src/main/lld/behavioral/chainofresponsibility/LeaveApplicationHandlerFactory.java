package main.lld.behavioral.chainofresponsibility;

public class LeaveApplicationHandlerFactory {
    LeaveApprover director = new Director(null);
    LeaveApprover manager = new Manger(director);
    LeaveApprover lead = new Lead(manager);


    public LeaveApprover getLeaveApplicationHandler() {
        return lead;
    }

}
