
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    String op;
    public LoginController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		op=request.getParameter("op");
		if(op.equals("EmployeeLogin")){
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeLogin.html");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("SpocLogin.html");
			rd.forward(request, response);
		}
		
		
	}

}
