package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import pojos.ReimbursementForm;
import pojos.User;
import service.ReimbursementFormService;

public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReimbursementFormService formService = new ReimbursementFormService();
	private ObjectMapper mapper = new ObjectMapper();

    public ReimbursementServlet() {
        super();
    }


	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) {
			User user = (User) sess.getAttribute("user");
			String param = request.getPathInfo();
		
			if (param == null) {
			
				String userType = user.getUserType();
				if (userType.equalsIgnoreCase("department head")) {
					List<ReimbursementForm> forms = formService.getAllReimbursements();
					String formsJSON = new Gson().toJson(forms);
					response.getWriter().write(formsJSON);
				} else if (userType.equalsIgnoreCase("supervisor")) {
					List<ReimbursementForm> forms = formService.getAllReimbursements();
					String formsJSON = new Gson().toJson(forms);
					response.getWriter().write(formsJSON);
				} else if (userType.equalsIgnoreCase("employee")) {
					List<ReimbursementForm> forms = formService.getReimbursementByUserId(user.getUserId());
					String formsJSON = new Gson().toJson(forms);
					response.getWriter().write(formsJSON);
				} else {
					List<ReimbursementForm> forms = formService.getAllReimbursements();
					String formsJSON = new Gson().toJson(forms);
					response.getWriter().write(formsJSON);
				}
			} else {
				int id = Integer.parseInt(param.substring(1));
				ReimbursementForm form = formService.getReimbursementById(id);
				String formJSON = new Gson().toJson(form);
				response.getWriter().write(formJSON);
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
			
			System.out.println(formJson);		
			ReimbursementForm form = mapper.readValue(formJson, ReimbursementForm.class);
			form.setSubmitted(LocalDate.now());
			try {
			
				formService.addReimbursementForm(form);
				response.getWriter().write("Success");
			
			} catch (Exception e) {
				response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().write("Form could not be created");
			}
		}else {
			response.getWriter().write("User not logged in");
			response.setStatus(response.SC_UNAUTHORIZED);
		}
	}


	@SuppressWarnings("static-access")
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) {
			User user = (User) sess.getAttribute("user");
			String formJson = request.getReader().readLine();
			ReimbursementForm form = new Gson().fromJson(formJson, ReimbursementForm.class);
			int id = form.getReimbursementId();
			String status;
			if (user.getUserType().equals("supervisor")) {
				 status = "approved by supervisor";
			}else if (user.getUserType().equals("department head")) {
				status = "approved by DH";
			} else if (user.getUserType().equals("benco")) {
				status = "approved";
			} else {
				status = "pending";
			}
			
			try {
			
				if (form.getInformationRequest() != null) {
					formService.informationRequest(form.getInformationRequest(), id);
				} else {
				formService.approveReimbursement(status, id);
				response.getWriter().write("Success");
				}
			} catch (Exception e) {
				response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().write("Form could not be created");
			}
		}else {
			response.getWriter().write("User not logged in");
			response.setStatus(response.SC_UNAUTHORIZED);
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
