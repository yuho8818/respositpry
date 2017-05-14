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

@WebServlet("/Changeservlet")
public class Changeservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 public Changeservlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {	
		 	Goods good=new Goods();
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			good.setId(Integer.valueOf(request.getParameter("id")));
			good.setName(request.getParameter("name"));
			good.setCity(request.getParameter("city"));
			good.setNumber(Integer.valueOf(request.getParameter("number")));
			good.setPrice(Integer.valueOf(request.getParameter("price")));
			good.setPicture(request.getParameter("picture"));
			good.setImg1(request.getParameter("img1"));
			good.setImg2(request.getParameter("img2"));
			good.setOprice(Integer.valueOf(request.getParameter("Oprice")));
			good.setMonSale(Integer.valueOf(request.getParameter("monSale")));
			good.setTotalSale(Integer.valueOf(request.getParameter("totalSale")));
			good.setEvaluation(Integer.valueOf(request.getParameter("evaluation")));
			PreparedStatement presta = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/shop";
				Connection cn = DriverManager.getConnection(url, "root", "888888");
				String update = "update goods set name=?,city=?,number=? ,price=?,picture=?,img1=?,img2=?,Oprice=?,monSale=?,totalSale=?,evaluation=?"+
						" where id=?";
				presta = cn.prepareStatement(update); // create a statement			
				presta.setString(1, good.getName()); 
				presta.setString(2, good.getCity()); 
				presta.setInt(3,good.getNumber()); 
				presta.setInt(4, good.getPrice()); 
				presta.setString(5, good.getPicture()); 
				presta.setString(6,good.getImg1());
				presta.setString(7,good.getImg2());
				presta.setInt(8,good.getOprice());
				presta.setInt(9,good.getMonSale());
				presta.setInt(10,good.getTotalSale());
				presta.setInt(11,good.getEvaluation());
				presta.setInt(12, good.getId());
				presta.executeUpdate(); 
				presta.close();
				cn.close();	
				System.out.println("修改成功");
			} catch (Exception e) {
				System.out.println("修改商品信息出现错误:" + e);
			}	
			request.setAttribute("result", "修改商品信息成功！");
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/operationresult.jsp"); 
			dispather.forward(request,response);
		}
	
}
