	package com.zgcns.lms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgcns.lms.model.Employee;
import com.zgcns.lms.model.LeaveRequest;
import com.zgcns.lms.repositories.LeaveRequestRepository;

@Service
public class LeaveRequestService {
	@Autowired
    private final LeaveRequestRepository leaveRequestRepository;

    
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public Optional<LeaveRequest> getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeaveRequestById(Long id) {
        leaveRequestRepository.deleteById(id);
    }

    public List<LeaveRequest> getLeaveRequestsByEmployee(Employee employee) {
        return leaveRequestRepository.findByEmployee(employee);
    }
    
    public List<LeaveRequest>getAllLeaveRequestByEmployeeId(Long empId){
    	return leaveRequestRepository.findAllByEmpId(empId);
    }
    
}
