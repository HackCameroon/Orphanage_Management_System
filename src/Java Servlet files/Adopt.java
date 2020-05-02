import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Adopt extends HttpServlet{
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
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String maritalstatus = request.getParameter("maritalstatus");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String pan = request.getParameter("pan");
			String occupation = request.getParameter("occupation");
			String income = request.getParameter("income");
			String place = request.getParameter("place");
			PreparedStatement pst = con.prepareStatement("insert into adopter values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,age);
			pst.setString(3,gender);
			pst.setString(4,maritalstatus);
			pst.setString(5,phone);
			pst.setString(6,email);
			pst.setString(7,pan);
			pst.setString(8,occupation);
			pst.setString(9,income);
			pst.setString(10,place);
			int i = pst.executeUpdate();
			while(i!=0){
				request.getSession().setAttribute("errorMessage", "Your request for adoption has been recorded. You'll be notified soon!");
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