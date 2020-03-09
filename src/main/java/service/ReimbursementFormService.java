package service;

import java.util.List;

import DAO.ReimbursementFormDAO;
import pojos.ReimbursementForm;

public class ReimbursementFormService {
	
	private ReimbursementFormDAO formDao = new ReimbursementFormDAO();
	
	public void addReimbursementForm(ReimbursementForm form) {
		formDao.insertForm(form);
	}
	
	public List<ReimbursementForm> getReimbursements(){
		
		List <ReimbursementForm> forms = formDao.retrieveForms();
		
		return forms;
		
	}

}
