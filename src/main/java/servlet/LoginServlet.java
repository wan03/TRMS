package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pojos.User;
import service.AuthenticationServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static AuthenticationServiceImpl authService = new AuthenticationServiceImpl();

    public LoginServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		rd.forward(request, response);
	}


	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userJson = request.getReader().readLine();
		User tempUser = new Gson().fromJson(userJson, User.class);
		String username = tempUser.getUsername();
		String password = tempUser.getPassword();
		System.out.println("Username: " + username + " Password: " + password);
		User user = authService.validateUser(username, password);
		System.out.println("User: " + user);
		if (user == null) {
			response.setStatus(response.SC_UNAUTHORIZED);
		} else {
			HttpSession sess = request.getSession(true);
			sess.setAttribute("user", user);
			response.sendRedirect("dashboard");
		}
	}

}
