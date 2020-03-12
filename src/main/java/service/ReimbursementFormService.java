package service;

import java.util.List;
import DAO.ReimbursementFormDAO;
import DAO.UserDAOImpl;
import pojos.Employee;
import pojos.ReimbursementForm;

public class ReimbursementFormService {
	
	private ReimbursementFormDAO formDao = new ReimbursementFormDAO();
	private static UserDAOImpl userDao = new UserDAOImpl();
	
	public void addReimbursementForm(ReimbursementForm form) {
		int userId = form.getUserId();
		Employee employee = (Employee) userDao.readUser(userId);
		double availableReimbursment = employee.getAvailableReimbursment();
		double pendingReimbursment = employee.getPendingReimbursment();
		double currentAvailable = availableReimbursment - pendingReimbursment;
		double requestedReimbursment = form.getReimbursementAmount();
		if (currentAvailable - requestedReimbursment >= 0) {
			double currentPending = pendingReimbursment + requestedReimbursment;
			formDao.insertForm(form);
			userDao.updateUser(employee, "pending_reimbursement", currentPending);
		} else {
			double deficit = currentAvailable - requestedReimbursment;
			double updatedReimbursement = requestedReimbursment - deficit;
			form.setReimbursementAmount(updatedReimbursement);
			double currentPending = pendingReimbursment + updatedReimbursement;
			formDao.insertForm(form);
			userDao.updateUser(employee, "pending_reimbursement", currentPending);
		}
		
		
	}
	
	public List<ReimbursementForm> getAllReimbursements(){
		
		List <ReimbursementForm> forms = formDao.retrieveForms();
		
		return forms;
		
	}
	
	public ReimbursementForm getReimbursementById(int reimId) {
		
		ReimbursementForm form = formDao.retrieveForm(reimId);
		return form;
	}
	
	public List<ReimbursementForm> getReimbursementByUserId(int userId) {
		
		List<ReimbursementForm> forms = formDao.retrieveForms(userId);
		return forms;
	}
	
	public void approveReimbursement (String value, int id) {
		if (value.equals("approved")) {
			ReimbursementForm form = formDao.retrieveForm(id);
			Employee employee = (Employee) userDao.readUser(form.getReimbursementId());
			double currentReimbursement = employee.getAvailableReimbursment() - form.getReimbursementAmount();
			userDao.updateUser(employee, "available_reimbursemnt", currentReimbursement);
			formDao.updateForm("status", value, id);
		} else {
			
			formDao.updateForm("status", value, id);
		}
		
	}
	
	public void informationRequest (String value, int id) {
		
		formDao.updateForm("information_request", value, id);
	}
	


}
