package manage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Goods;

@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 public Deleteservlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {	
			  doGet(request, response);
		   }
	 public void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {	
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");	
			String idd=request.getParameter("id");
			System.out.println("ȡ��������"+idd);
			int id=Integer.valueOf(idd);
			Goods goods = new Goods();
			//ִ�и���Id�Ų�ѯ����Ӧ����Ʒ��Ϣ
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/shop";
				Connection cn = DriverManager.getConnection(url, "root", "888888");
				String sql = "delete from goods where id=?";
				PreparedStatement prepStmt=cn.prepareStatement(sql); 
				prepStmt.setString(1, idd);
				prepStmt.executeUpdate();				
				prepStmt.close();
				cn.close();	
				System.out.println("ɾ�������Ѿ���ϣ����ر��������ݿ�����");
			} catch (Exception e) {
				System.out.println("ɾ����Ʒ���ֵĴ��� :" + e);
			}
			request.setAttribute("result", "ɾ����Ʒ�ɹ���");
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/operationresult.jsp"); 
			dispather.forward(request,response);
			
   }
}
