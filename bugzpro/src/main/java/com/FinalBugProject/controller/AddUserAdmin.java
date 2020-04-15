package com.FinalBugProject.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FinalBugProject.models.EditProfile;
import com.FinalBugProject.models.Login;
import com.FinalBugProject.models.Signup;
import com.FinalBugProject.services.AddData;
import com.FinalBugProject.services.SendEmail;
/**
 * Servlet implementation class AddUserAdmin
 */
@WebServlet("/AddUserAdmin")
public class AddUserAdmin extends HttpServlet {
	static RequestDispatcher views;
	static HttpSession session;
	static AddData data = new AddData();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		try {
		request.setAttribute("password1","");
		request.setAttribute("email1","");
		request.setAttribute("username1","");
		views = request.getRequestDispatcher("WEB-INF/views/admin/AddUserAdmin.jsp");
		views.forward(request, response);
		}catch(Exception e) {
			if(session.getAttribute("email")==null)
				response.sendRedirect("./welcome");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setAttribute("exists", false);
		String Email = request.getParameter("email");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String Desig = request.getParameter("radio");
		int valid = data.exists(Email, username, pwd);
		if(valid==1) {
			request.setAttribute("exists", true);
			request.setAttribute("emailexists",true);
			request.setAttribute("email1", "");
		}else {
			request.setAttribute("email1", Email);
			
		}
		if(valid==2) {
			request.setAttribute("exists", true);
			request.setAttribute("usernameexists",true);
			request.setAttribute("username1", "");
		}else {
			request.setAttribute("username1", username);
			
		}
		if(valid==3) {
			request.setAttribute("exists", true);
			request.setAttribute("passwordexists",true);
			request.setAttribute("password1", "");
		}else {
			request.setAttribute("password1", pwd);
			
		}
		if((boolean)request.getAttribute("exists")) {
			views = request.getRequestDispatcher("WEB-INF/views/admin/AddUserAdmin.jsp");
			views.forward(request, response);
		}
		if(valid==0) {
		request.setAttribute("errors", true);
		String username_regex = "^[a-z0-9_-]{3,15}$";
		String email_regex = "^[a-zA-Z0-9_!#$%&�*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String password_regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		
		if ((username.matches(username_regex) && username.length() > 2) == false) {
			request.setAttribute("errors", false);
			request.setAttribute("username_error", true);
			request.setAttribute("username1", "");
			views = request.getRequestDispatcher("WEB-INF/views/admin/AddUserAdmin.jsp");
			views.forward(request, response);
		} else {
			request.setAttribute("username1", username);
		}
		if ((pwd.matches(password_regex) && pwd.length() > 2) == false) {
			request.setAttribute("errors", false);
			request.setAttribute("password_error", true);
			request.setAttribute("password1", "");
			views = request.getRequestDispatcher("WEB-INF/views/admin/AddUserAdmin.jsp");
			views.forward(request, response);
		} else {
			request.setAttribute("password1", pwd);
		}
		if ((Email.matches(email_regex) && Email.length() > 2) == false) {
			request.setAttribute("errors", false);
			request.setAttribute("email_error", true);
			request.setAttribute("email1", "");
			views = request.getRequestDispatcher("WEB-INF/views/admin/AddUserAdmin.jsp");
			views.forward(request, response);
		} else {
			request.setAttribute("email1", Email);
		}
		
		
		if ((boolean) request.getAttribute("errors")) {
			session = request.getSession();
			session.setAttribute("email", Email);
			String subject = "Welcome to Experience the Product";
			String Body = "Dear "+Email+", Thanks for choosing our product.We at BugZPro is maintained and developed by a single person but will meet your expectations.We hope you enjoy using our product.We hope to hear back from you.Go to our feedback section in the menu to let us know.Thank You!!!";
			SendEmail send = new SendEmail();
			Signup signup1 = new Signup();
			Login login = new Login();
			EditProfile edit = new EditProfile();
			Random rnd = new Random();
		    long number = rnd.nextInt(999999);
			signup1.setUsername(username);
			signup1.setPwd(pwd);
			signup1.setEmail(request.getParameter("email"));
			signup1.setDesig(Desig);
			login.setEmail(Email);
			login.setDesig(Desig);
			login.setPassword(pwd);
			login.setUser_ID_FK(number);
			edit.setUser_ID_FK(number);
			data.insertLogin(login);
			data.insertSignup(signup1);
			data.insertEdit(edit);
			views = request.getRequestDispatcher("WEB-INF/views/admin/AddUserAdmin.jsp");
			request.setAttribute("email1", "");
			request.setAttribute("password1", "");
			request.setAttribute("username1", "");
			request.setAttribute("radio1", "");
			request.setAttribute("success", true);
			views.forward(request, response);

		}
		}
	}catch(Exception e) {
		if(session.getAttribute("email")==null)
			response.sendRedirect("./welcome");
	}
	}
}
