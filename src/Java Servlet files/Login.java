import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Login extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/forms","root","root");

			String uname = request.getParameter("uname");
			String psw = request.getParameter("psw");
			HttpSession session=request.getSession(true);
			
			PreparedStatement stmt = con.prepareStatement("select uname,password from login where uname = ? and password = ?");
			stmt.setString(1,uname);
			stmt.setString(2,psw);
			ResultSet rs = stmt.executeQuery();
				if(rs.next()){
					RequestDispatcher rd = request.getRequestDispatcher("afterlogin.html");
					rd.forward(request,response);
					return;
				}
				else{
					out.print("No user found");}
			
		}
		catch(Exception e){out.print(e);}
	}
}