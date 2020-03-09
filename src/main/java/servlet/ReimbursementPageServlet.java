package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReimbursementPageServlet
 */
public class ReimbursementPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReimbursementPageServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sess = request.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) { // user has logged in
			RequestDispatcher rd = request.getRequestDispatcher("reimbursementForm.html");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
