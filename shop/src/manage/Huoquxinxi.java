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

@WebServlet("/Huoquxinxi")
public class Huoquxinxi extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 public Huoquxinxi() {
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
			Goods goods=new Goods();
			int id=Integer.valueOf(request.getParameter("id"));
			String sql="select * from goods where id='"+id+"'";
			PreparedStatement presta = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/shop";
				Connection cn = DriverManager.getConnection(url, "root", "888888");
				presta=cn.prepareStatement(sql);	
				ResultSet rs =presta.executeQuery();
				while(rs.next())
				{
					goods.setId(rs.getInt("id"));
					goods.setName(rs.getString("name"));
					goods.setCity(rs.getString("city"));
					goods.setNumber(rs.getInt("number"));
					goods.setPrice(rs.getInt("price"));
					goods.setPicture(rs.getString("picture"));
					goods.setImg1(rs.getString("img1"));
					goods.setImg2(rs.getString("img2"));
					goods.setOprice(rs.getInt("Oprice"));
					goods.setMonSale(rs.getInt("monSale"));
					goods.setTotalSale(rs.getInt("totalSale"));
					goods.setEvaluation(rs.getInt("evaluation"));
					
				}
				
				presta.close();
				cn.close();	
			} catch (Exception e) {
				System.out.println(e);
			}	
			request.setAttribute("good", goods);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/change.jsp"); 
			dispather.forward(request,response);
		 
		 
		 
	 }
	
}
