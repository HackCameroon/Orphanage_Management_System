import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Register extends HttpServlet{
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
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String pwd = request.getParameter("pwd");
			PreparedStatement pst = con.prepareStatement("insert into userlogin values(?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,phone);
			pst.setString(4,pwd);
			int i = pst.executeUpdate();
			while(i!=0){
				RequestDispatcher rd = request.getRequestDispatcher("afterlogin.html");
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