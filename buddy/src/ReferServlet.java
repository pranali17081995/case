import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.beans.Job;
import com.techm.beans.budy;
import com.techm.dao.JobDetails;
import com.techm.dao.JobDetailsImpl;


public class ReferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String op;
	public ReferServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String jcode = request.getParameter("j_code");
		int jcode1 = Integer.parseInt(jcode);
		String name=request.getParameter("name");
		String jskill = request.getParameter("skill");
		int yoe = Integer.parseInt(request.getParameter("exp"));
		String status="new";
		String jloc = request.getParameter("address");

		String mail = request.getParameter("mail");
		System.out.println(jcode1+name+jskill+yoe+jloc+status+mail);
		budy b1=new budy(jcode1,name,jskill, yoe, jloc,status,mail);
		JobDetails modifyjob1 = new JobDetailsImpl();
		boolean flag = modifyjob1.refbuddy(b1);
		if (flag == true) 
		{
			out.println("Buddy Details Added");
		} else 
		{
			out.println("Details cannot be added");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}