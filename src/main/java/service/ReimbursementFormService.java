package service;

import DAO.ReimbursementFormDAO;
import pojos.ReimbursementForm;

public class ReimbursementFormService {
	
	private ReimbursementFormDAO formDao = new ReimbursementFormDAO();
	
	public void addReimbursementForm(ReimbursementForm form) {
		formDao.insertForm(form);
	}

}
