package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pojos.ReimbursementForm;
import service.ReimbursementFormService;

public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReimbursementFormService formService = new ReimbursementFormService();

    public ReimbursementServlet() {
        super();
    }


	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) {
		String param = request.getPathInfo();
		
		if (param == null) {
			
			List<ReimbursementForm> forms = formService.getReimbursements();
			 String formsJSON = new Gson().toJson(forms);
			
			//TODO if employee it should only return theirs
			response.getWriter().write(formsJSON);
		} else {
			response.getWriter().append("This should return a single one" + param);
		}
		}else {
			response.getWriter().write("User not logged in");
			response.setStatus(response.SC_UNAUTHORIZED);
		}
		
	}


	@SuppressWarnings({ "static-access" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) {
		String formJson = request.getReader().readLine();
		
		ReimbursementForm form = new GsonBuilder().create().fromJson(formJson, ReimbursementForm.class);
		form.setSubmitted(LocalDate.now());
		try {
			
			formService.addReimbursementForm(form);
			response.getWriter().write("Success");
			
		} catch (Exception e) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("Car could not be created");
		}
		}else {
			response.getWriter().write("User not logged in");
			response.setStatus(response.SC_UNAUTHORIZED);
		}
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
