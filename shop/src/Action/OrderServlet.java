package Action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DAOFactory;
import pojo.Goods;
import pojo.Order;
import pojo.Users;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("pay")){			
			String username = (String) request.getSession().getAttribute("username");
			Users user = null;
			try {
				user = DAOFactory.getUserDAOInstance().queryByUsername(username);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Order order = new Order();
			order.setUid(user.getUid());
			order.setMoney(Integer.parseInt(request.getParameter("money")));
			order.setAddressId(Integer.parseInt(request.getParameter("addressId")));
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			order.setTime(format.format(date)); 
			
			try{
				ArrayList<Goods> goodlist = null;
				ArrayList<Order> orderlist = null;
				ArrayList<Goods> paylist = (ArrayList<Goods>) request.getSession().getAttribute("paylist");
				for (int i = 0; i < paylist.size(); i++) {
					goodlist = DAOFactory.getCartDAOInstance().deleteItem(username, paylist.get(i).getId());					
				}
				DAOFactory.getOrderDAOInstance().addOrder(order);
				order.setOrderId(DAOFactory.getOrderDAOInstance().getMaxId());
				order.setPaiedlist(paylist);
				DAOFactory.getOrderDAOInstance().AddPaied(order);
				
				orderlist = DAOFactory.getOrderDAOInstance().getAllOrder(user.getUid());
				orderlist = DAOFactory.getOrderDAOInstance().getPaiedGoods(orderlist);
				request.getSession().setAttribute("list", orderlist);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(action.equals("show")){
			ArrayList<Order> orderlist = null;
			String username = (String) request.getSession().getAttribute("username");
			Users user = null;
			try {
				user = DAOFactory.getUserDAOInstance().queryByUsername(username);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				orderlist = DAOFactory.getOrderDAOInstance().getAllOrder(user.getUid());
				orderlist = DAOFactory.getOrderDAOInstance().getPaiedGoods(orderlist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("list", orderlist);
			
		}
		request.getRequestDispatcher("Order.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
