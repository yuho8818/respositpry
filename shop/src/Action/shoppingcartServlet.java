package Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DAOFactory;
import pojo.Goods;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/shoppingcart")
public class shoppingcartServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	String username = (String) request.getSession().getAttribute("username");
		String action=request.getParameter("action");
		ArrayList<Goods> list = null;
		if(action.equals("lookbus")){
			try {
				 list=DAOFactory.getCartDAOInstance().getAllItems(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", list);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		}else if(action.equals("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				 list=DAOFactory.getCartDAOInstance().deleteItem(username,id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", list);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		}else if(action.equals("pay")){
			try {
				 list=DAOFactory.getCartDAOInstance().payAllItems(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", list);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/pay.jsp");
			dispather.forward(request, response);
		}else if(action.equals("add")){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				 list=DAOFactory.getCartDAOInstance().addNum(username,id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", list);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		}else if(action.equals("sub")){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				 list=DAOFactory.getCartDAOInstance().subNum(username,id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", list);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		}else if(action.equals("addgoods")){
			int id = Integer.parseInt(request.getParameter("id"));
			
			Goods goods = null;
			try {
				goods = DAOFactory.getGoodsDAOInstance().queryById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				DAOFactory.getCartDAOInstance().addgoods(username,goods);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
    	
    } 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        doGet(request, response); 
    } 
} 
