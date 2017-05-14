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

@WebServlet("/Adloginservlet")
public class Adloginservlet extends HttpServlet{
	String adname=null;
	String password=null;
	private static final long serialVersionUID = 1L;
    public Adloginservlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		manager manag=new manager();
		manag.setadname(request.getParameter("adname"));
		manag.setPassword(request.getParameter("password"));
		System.out.println(manag.getadname());
		System.out.println(manag.getPassword());
		int ret=ManagerDAO.checkmanager(manag);
		if(ret==1)
		{
			request.getRequestDispatcher("adhome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("status", "您输入的管理员名称或者密码错误！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
