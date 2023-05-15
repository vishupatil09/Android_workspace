import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServelet2 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		int id2 = Integer.parseInt(id);
		String myname = req.getParameter("name");
		String mysurname = req.getParameter("surname");
		String myemail = req.getParameter("email");
		
		Model m =new Model();
		m.setId(id2);
		m.setName(myname);
		m.setSurname(mysurname);
		m.setEmail(myemail);
		
		int status = MyDao.updatedata(m);
		
		if(status>0)
		{
			resp.sendRedirect("ViewServlet");
			//System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
	}
}
