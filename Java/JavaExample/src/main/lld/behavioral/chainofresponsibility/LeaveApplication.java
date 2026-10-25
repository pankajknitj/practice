package main.lld.behavioral.chainofresponsibility;

import lombok.Data;

@Data
public class LeaveApplication {
    public enum LeaveType {SickLeave, CasualLeave, EarnedLeave, MaternityLeave, PaternityLeave}

    private LeaveType leaveType;
    private int duration;
    private String  approvedBy;
    private boolean isApproved;

}
