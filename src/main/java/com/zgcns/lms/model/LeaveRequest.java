package com.zgcns.lms.model;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leaveRequest")
public class LeaveRequest {
		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
	    @ManyToOne
	    @JoinColumn(name = "employee_id", nullable = false)
	    private Employee employee;
	    
	    @Column(name = "startDate")
	    private LocalDate startDate;
	    
	    @Column(name = "endDate")
	    private LocalDate endDate;
	    
	    @Column(name = "status")
	    private LeaveStatus status;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public LeaveStatus getStatus() {
			return status;
		}
		public void setStatus(LeaveStatus status) {
			this.status = status;
		}
		public LeaveRequest(Long id, Employee employee, LocalDate startDate, LocalDate endDate, LeaveStatus status) {
			super();
			this.id = id;
			this.employee = employee;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
		}
		public LeaveRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "LeaveRequest [id=" + id + ", employee=" + employee + ", startDate=" + startDate + ", endDate="
					+ endDate + ", status=" + status + "]";
		}
	    
	    
}

