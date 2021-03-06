package pojos;

import java.time.LocalDate;
import util.DateHandler;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ReimbursementForm {
	
	private int reimbursementId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private int userId;
	private String email;
	private String institutionName;
	private String institutionaddress;
	private String institutioncity;
	private String institutionstate;
	private String institutionzip;
	private String programName;
	@JsonDeserialize(using = DateHandler.class)
	private LocalDate startDate;
	@JsonDeserialize(using = DateHandler.class)
	private LocalDate endDate;
	private String weekDays;
	private String timeBlock;
	private String description;
	private double cost;
	private String gradeFormat;
	private String eventType;
	private double reimbursementAmount;
	private String justification;
	private String status;
	private String informationRequest;
	private LocalDate submitted;
	private String file;
	
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getInstitutionaddress() {
		return institutionaddress;
	}
	public void setInstitutionaddress(String institutionaddress) {
		this.institutionaddress = institutionaddress;
	}
	public String getInstitutioncity() {
		return institutioncity;
	}
	public void setInstitutioncity(String institutioncity) {
		this.institutioncity = institutioncity;
	}
	public String getInstitutionstate() {
		return institutionstate;
	}
	public void setInstitutionstate(String institutionstate) {
		this.institutionstate = institutionstate;
	}
	public String getInstitutionzip() {
		return institutionzip;
	}
	public void setInstitutionzip(String institutionzip) {
		this.institutionzip = institutionzip;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
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
	public String getWeekDays() {
		return weekDays;
	}
	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}
	public String getTimeBlock() {
		return timeBlock;
	}
	public void setTimeBlock(String timeBlock) {
		this.timeBlock = timeBlock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getGradeFormat() {
		return gradeFormat;
	}
	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInformationRequest() {
		return informationRequest;
	}
	public void setInformationRequest(String informationRequest) {
		this.informationRequest = informationRequest;
	}
	public LocalDate getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDate submitted) {
		this.submitted = submitted;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public ReimbursementForm(int reimbursementId, String firstName, String lastName, String address, String city, String state,
			String zip, int userId, String email, String institutionName, String institutionaddress, String institutioncity,
			String institutionstate, String institutionzip, String programName, LocalDate startDate, LocalDate endDate,
			String weekDays, String timeBlock, String description, double cost, String gradeFormat,
			String eventType, double reimbursementAmount, String justification, String status, String informationRequest, LocalDate submitted, String file) {
		super();
		this.reimbursementId = reimbursementId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.userId = userId;
		this.email = email;
		this.institutionName = institutionName;
		this.institutionaddress = institutionaddress;
		this.institutioncity = institutioncity;
		this.institutionstate = institutionstate;
		this.institutionzip = institutionzip;
		this.programName = programName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.weekDays = weekDays;
		this.timeBlock = timeBlock;
		this.description = description;
		this.cost = cost;
		this.gradeFormat = gradeFormat;
		this.eventType = eventType;
		this.reimbursementAmount = reimbursementAmount;
		this.justification = justification;
		this.status = status;
		this.informationRequest = informationRequest;
		this.submitted = submitted;
		this.file = file;
	}
	
	public ReimbursementForm(int reimbursementId, String firstName, String lastName, String address, String city, String state,
			String zip, int userId, String email, String institutionName, String institutionaddress,
			String institutionstate, String institutioncity, String institutionzip, String programName, LocalDate startDate, LocalDate endDate,
			String weekDays, String timeBlock, String description, double cost, String gradeFormat,
			String eventType, double reimbursementAmount, String justification, String status, LocalDate submitted) {
		super();
		this.reimbursementId = reimbursementId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.userId = userId;
		this.email = email;
		this.institutionName = institutionName;
		this.institutionaddress = institutionaddress;
		this.institutioncity = institutioncity;
		this.institutionstate = institutionstate;
		this.institutionzip = institutionzip;
		this.programName = programName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.weekDays = weekDays;
		this.timeBlock = timeBlock;
		this.description = description;
		this.cost = cost;
		this.gradeFormat = gradeFormat;
		this.eventType = eventType;
		this.reimbursementAmount = reimbursementAmount;
		this.justification = justification;
		this.status = status;
		this.submitted = submitted;
	}
	public ReimbursementForm() {
		super();
	}

	
	
	
	

}
