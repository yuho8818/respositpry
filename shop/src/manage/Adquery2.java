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

@WebServlet("/Adquery2")
public class Adquery2 extends HttpServlet{
	ArrayList<Goods> list = null;
	Integer idd=null;
	Connection cn = null;
	ResultSet rs = null;
	private static final long serialVersionUID = 1L;
    public Adquery2() {
        super();
        
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	idd=Integer.valueOf(request.getParameter("id"));
    	String sql="select *from goods where id = '"+idd+"'";
    	System.out.println(idd);
    try{
    	Class.forName("com.mysql.jdbc.Driver");
    	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","888888");
    	PreparedStatement presta=cn.prepareStatement(sql);
    	rs = presta.executeQuery();
    	list = new ArrayList<Goods>(); 
		while (rs.next()) {
			Goods goods = new Goods();
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
			list.add(goods);
		}
    }catch(Exception e){System.out.println(e);}
    if(list.size()==0){
    request.setAttribute("result", "没有该编号的商品，请您确认是否正确输入编号！");
	RequestDispatcher dispather = getServletContext().getRequestDispatcher("/operationresult.jsp"); 
	dispather.forward(request,response);}
    else{
    request.getSession().setAttribute("list", list);
	RequestDispatcher dispather = getServletContext().getRequestDispatcher("/queryresult.jsp");
	dispather.forward(request, response);}
    
    }
}
