package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;

import pojos.ReimbursementForm;
import service.ReimbursementFormService;

public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReimbursementFormService formService = new ReimbursementFormService();

    public ReimbursementServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getRequestURI();
		
		if (param.equalsIgnoreCase("/trms/reimbursement")) {
			
			//TODO if employee it should only return theirs
			response.getWriter().append("This should return all");
		} else {
			response.getWriter().append("This should return a single one" + param);
		}		
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String formJson = req.getReader().readLine();
		
		ReimbursementForm form = new GsonBuilder().create().fromJson(formJson, ReimbursementForm.class);
		try {
			
			formService.addReimbursementForm(form);
			resp.getWriter().write("Success");
			
		} catch (Exception e) {
			resp.setStatus(resp.SC_INTERNAL_SERVER_ERROR);
			resp.getWriter().write("Car could not be created");
		}
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
