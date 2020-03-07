package pojos;

public class Employee extends User {
	private String supervisor;
	private String departmentHead;
	private double availableReimbursment;
	private double pendingReimbursment;
	
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}
	public double getAvailableReimbursment() {
		return availableReimbursment;
	}
	public void setAvailableReimbursment(double availableReimbursment) {
		this.availableReimbursment = availableReimbursment;
	}
	public double getPendingReimbursment() {
		return pendingReimbursment;
	}
	public void setPendingReimbursment(double pendingReimbursment) {
		this.pendingReimbursment = pendingReimbursment;
	}
	public Employee(int id, String firstName, String lastName, String username, String password, String userType,
			String position, String supervisor, String departmentHead, double availableReimbursment,
			double pendingReimbursment) {
		super(id, firstName, lastName, username, password, userType, position);
		this.supervisor = supervisor;
		this.departmentHead = departmentHead;
		this.availableReimbursment = availableReimbursment;
		this.pendingReimbursment = pendingReimbursment;
	}
	
	public Employee(String firstName, String lastName, String username, String password, String userType,
			String position, String supervisor, String departmentHead, double availableReimbursment,
			double pendingReimbursment) {
		super(firstName, lastName, username, password, userType, position);
		this.supervisor = supervisor;
		this.departmentHead = departmentHead;
		this.availableReimbursment = availableReimbursment;
		this.pendingReimbursment = pendingReimbursment;
	}
	@Override
	public String toString() {
		return "Employee [id=" + getUserId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", username=" + getUsername() 
				+ ", password=" + getPassword() + ", userType=" + getUserType() + ", position=" + getPosition() + "supervisor=" + supervisor + ", departmentHead=" + departmentHead + ", availableReimbursment="
				+ availableReimbursment + ", pendingReimbursment=" + pendingReimbursment + "]";
	}
	
	
	

}
