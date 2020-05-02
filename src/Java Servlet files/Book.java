import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Book extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/forms","root","root");

			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String orphanages = request.getParameter("orphanages");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String no = request.getParameter("no");
			PreparedStatement pst = con.prepareStatement("insert into visit values(?,?,?,?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,phone);
			pst.setString(3,email);
			pst.setString(4,orphanages);
			pst.setString(5,date);
			pst.setString(6,time);
			pst.setString(7,no);
			int i = pst.executeUpdate();
			while(i!=0){
				request.getSession().setAttribute("errorMessage", "Booking request has been recorded!");
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