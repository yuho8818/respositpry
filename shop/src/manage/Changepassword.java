package manage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Goods;
import pojo.manager;

@WebServlet("/Changepassword")
public class Changepassword extends HttpServlet{
	String newname=null;
	String newpassword=null;
	PreparedStatement presta=null;
	private static final long serialVersionUID = 1L;
    public Changepassword() {
        super();
        
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		newpassword=request.getParameter("newpassword");
		newname=request.getParameter("newname");
		System.out.println(newpassword+"huoqu 到了"+newname);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","888888");
			String sql = "update manager set password=?"+
					" where adname=?";
			presta=cn.prepareStatement(sql);
			presta.setString(1,newpassword);
			presta.setString(2, newname);
			presta.executeUpdate();
			presta.close();
			cn.close();	
			System.out.println("hah");
		}catch(Exception e){System.out.println("修改管理员信息出现错误:" + e);}
		request.setAttribute("status", "修改管理员信息成功！");
		RequestDispatcher dispather = getServletContext().getRequestDispatcher("/error.jsp"); 
		dispather.forward(request,response);
		
		
		

	}

}

