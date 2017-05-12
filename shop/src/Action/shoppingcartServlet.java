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
import pojo.Users;
import pojo.userAddress;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/shoppingcart")
public class shoppingcartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		String action = request.getParameter("action");
		ArrayList<Goods> goodlist = null;
		ArrayList<Goods> paied = null;
		ArrayList<Goods> getpaylist=new ArrayList<Goods>();
		if (action.equals("lookbus")) {
			try {
				goodlist = DAOFactory.getCartDAOInstance().getAllItems(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", goodlist);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		} else if (action.equals("lookpaied")) {
			try {
				paied = DAOFactory.getCartDAOInstance().getAllPaied(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("paied", paied);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/paied.jsp");
			dispather.forward(request, response);
		} else if (action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				goodlist = DAOFactory.getCartDAOInstance().deleteItem(username, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", goodlist);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		} else if (action.equals("pay")) {
			try {
				Users user = DAOFactory.getUserDAOInstance().queryByUsername(username);
				ArrayList<Goods> paylist = (ArrayList<Goods>) request.getSession().getAttribute("paylist");
				for (int i = 0; i < paylist.size(); i++) {
					goodlist = DAOFactory.getCartDAOInstance().deleteItem(username, paylist.get(i).getId());
					//DAOFactory.getCartDAOInstance().addpaied(username, paylist.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", goodlist);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		} else if (action.equals("add")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				goodlist = DAOFactory.getCartDAOInstance().addNum(username, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", goodlist);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		} else if (action.equals("sub")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				goodlist = DAOFactory.getCartDAOInstance().subNum(username, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", goodlist);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/Cart.jsp");
			dispather.forward(request, response);
		} else if (action.equals("payfor")) {
			try {
				goodlist = DAOFactory.getCartDAOInstance().getAllItems(username);
				String[] item = request.getParameterValues("item");
				for (int i = 0; i < item.length; i++) {
					getpaylist.add(goodlist.get(Integer.parseInt(item[i])));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Users user;
			ArrayList<userAddress> addresslist = null;
			try {
				user = DAOFactory.getUserDAOInstance().queryByUsername(username);
				addresslist = DAOFactory.getUserDAOInstance().queryAddress(user.getUid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("list", addresslist);
			request.getSession().setAttribute("paylist", getpaylist);
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/paybus.jsp");
			dispather.forward(request, response);
		} else if (action.equals("addgoods")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Goods goods = null;
			try {
				goods = DAOFactory.getGoodsDAOInstance().queryById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(DAOFactory.getCartDAOInstance().queryGoods(username, id)){
					DAOFactory.getCartDAOInstance().addgoods(username, goods);
				}else{
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispather = getServletContext().getRequestDispatcher("/shoplist.jsp");
			dispather.forward(request, response);
		}

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
