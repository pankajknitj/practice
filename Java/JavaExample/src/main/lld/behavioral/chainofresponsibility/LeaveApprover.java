package main.lld.behavioral.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class LeaveApprover {
    protected LeaveApprover nextApprover;
    private String role;

    public void processLeaveApplication(LeaveApplication leaveApplication){
        if(!processRequest(leaveApplication) && nextApprover != null){
            nextApprover.processLeaveApplication(leaveApplication);
        }
    }

    public void approve(LeaveApplication leaveApplication){
        leaveApplication.setApproved(true);
        leaveApplication.setApprovedBy(getRole());
    }

    public abstract boolean processRequest(LeaveApplication leaveApplication);
}
