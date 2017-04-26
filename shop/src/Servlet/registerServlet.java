package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("gbk");
		String phone = request.getParameter("phone");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("”√ªß"+user);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/shop";
			Connection cn = DriverManager.getConnection(url, "root", "888888");
			
			String update = "insert customer set phone=?,user=?,password=?";
			PreparedStatement prestmt = cn.prepareStatement(update);
			prestmt.setString(1, phone);
			prestmt.setString(2, user);
			prestmt.setString(3, password);
			prestmt.executeUpdate();
			prestmt.close();
			cn.close();
		}catch (Exception e){
			System.out.println("error:"+e);
		}
		
		RequestDispatcher dispather = getServletContext().getRequestDispatcher("/home.jsp");
		dispather.forward(request, response);
	}

}
