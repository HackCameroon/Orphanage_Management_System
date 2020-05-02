import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Donate extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/forms","root","root");

			String orphanage = request.getParameter("orphanage");
			String id = request.getParameter("id");
			String purpose = request.getParameter("purpose");
		
			PreparedStatement pst = con.prepareStatement("insert into donations values(?,?,?)");
			pst.setString(1,orphanage);
			pst.setString(2,id);
			pst.setString(3,purpose);
	
			int i = pst.executeUpdate();
			while(i!=0){
				request.getSession().setAttribute("errorMessage", "Thanks for your contribution!");
				RequestDispatcher rd = request.getRequestDispatcher("afteruserlogin.html");
				rd.forward(request,response);
				return;
			}
		}
		catch(Exception e){
			out.print(e);
		}
		out.close();
	}
}