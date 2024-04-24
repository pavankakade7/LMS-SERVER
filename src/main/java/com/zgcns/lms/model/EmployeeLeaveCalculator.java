package com.zgcns.lms.model;

import java.util.HashMap;
import java.util.Map;

public class EmployeeLeaveCalculator {
	
	private Long employeeId;
    private Map<String, Integer> leaveTypes; // e.g., "Casual", "Medical", "Privileged"

    public EmployeeLeaveCalculator(Long employeeId) {
        this.employeeId = employeeId;
        this.leaveTypes = new HashMap<>();
    }

    public void setLeave(String type, int amount) {
        leaveTypes.put(type, amount);
    }

    public int getLeave(String type) {
        return leaveTypes.getOrDefault(type, 0);
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Map<String, Integer> getLeaveTypes() {
        return leaveTypes;
    }

    public boolean applyLeave(String type, int amount) {
        int available = getLeave(type);
        if (available >= amount) {
            leaveTypes.put(type, available - amount);
            return true;
        }
        return false; // Not enough leave available
    }
}
