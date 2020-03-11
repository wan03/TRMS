package service;

import java.util.List;

import DAO.ReimbursementFormDAO;
import pojos.ReimbursementForm;

public class ReimbursementFormService {
	
	private ReimbursementFormDAO formDao = new ReimbursementFormDAO();
	
	public void addReimbursementForm(ReimbursementForm form) {
		formDao.insertForm(form);
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
		
		formDao.updateForm("status", value, id);
	}
	
	public void informationRequest (String value, int id) {
		
		formDao.updateForm("information_request", value, id);
	}
	
	public void determineAvailableReimbursement() {
		
	}

}
