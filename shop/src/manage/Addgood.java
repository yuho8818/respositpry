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
@WebServlet("/Addgood")
public class Addgood extends HttpServlet{
	private Connection cn;
	private PreparedStatement presta = null;
	ResultSet rs = null;
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		Goods goods = new Goods();
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		goods.setName(request.getParameter("name"));
		goods.setCity(request.getParameter("city"));
		goods.setNumber(Integer.valueOf(request.getParameter("number")));
		goods.setPrice(Integer.valueOf(request.getParameter("price")));
		goods.setPicture(request.getParameter("picture"));
		goods.setImg1(request.getParameter("img1"));
		goods.setImg2(request.getParameter("img2"));
		goods.setOprice(Integer.valueOf(request.getParameter("Oprice")));
		goods.setMonSale(Integer.valueOf(request.getParameter("monSale")));
		goods.setTotalSale(Integer.valueOf(request.getParameter("totalSale")));
		goods.setEvaluation(Integer.valueOf(request.getParameter("evaluation")));
		System.out.println("哈哈哈");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","888888");
		String insert = "insert into goods(name,city,number,price,picture,img1,img2,Oprice,monSale,totalSale,evaluation) values(?,?,?,?,?,?,?,?,?,?,?)";
		presta = cn.prepareStatement(insert); // create a statement
		
		presta.setString(1, goods.getName());
		presta.setString(2, goods.getCity());
		presta.setInt(3, goods.getNumber());
		presta.setInt(4, goods.getPrice());
		presta.setString(5,goods.getPicture());
		presta.setString(6,goods.getImg1());
		presta.setString(7,goods.getImg2());
		presta.setInt(8,goods.getOprice());
		presta.setInt(9,goods.getMonSale());
		presta.setInt(10,goods.getTotalSale());
		presta.setInt(11,goods.getEvaluation());
		presta.executeUpdate();
		presta.close();
		cn.close();
		}catch(Exception e){System.out.println(e);}
		System.out.println("插入完毕");
		request.setAttribute("result", "插入商品信息成功！");
		RequestDispatcher dispather = getServletContext().getRequestDispatcher("/operationresult.jsp"); 
		dispather.forward(request,response);
	   }
	
	
}

