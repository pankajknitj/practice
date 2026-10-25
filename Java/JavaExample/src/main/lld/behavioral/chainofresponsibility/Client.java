package main.lld.behavioral.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        LeaveApplicationHandlerFactory leaveApplicationHandlerFactory = new LeaveApplicationHandlerFactory();
        LeaveApprover leaveApprover = leaveApplicationHandlerFactory.getLeaveApplicationHandler();

        LeaveApplication leaveApplication1 = new LeaveApplication();
        leaveApplication1.setLeaveType(LeaveApplication.LeaveType.SickLeave);
        leaveApplication1.setDuration(2);

        leaveApprover.processLeaveApplication(leaveApplication1);
        System.out.println("Leave Application 1: " + leaveApplication1);

        LeaveApplication leaveApplication2 = new LeaveApplication();
        leaveApplication2.setLeaveType(LeaveApplication.LeaveType.CasualLeave);
        leaveApplication2.setDuration(5);

        leaveApprover.processLeaveApplication(leaveApplication2);
        System.out.println("Leave Application 2: " + leaveApplication2);

        LeaveApplication leaveApplication3 = new LeaveApplication();
        leaveApplication3.setLeaveType(LeaveApplication.LeaveType.EarnedLeave);
        leaveApplication3.setDuration(10);

        leaveApprover.processLeaveApplication(leaveApplication3);
        System.out.println("Leave Application 3: " + leaveApplication3);
    }
}
