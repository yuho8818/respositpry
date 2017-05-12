package Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DAOFactory;
import pojo.Goods;
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
		String username = (String) request.getSession().getAttribute("username");
		int money = Integer.parseInt(request.getParameter("money"));
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		if(action.equals("addorder")){
			try{
				ArrayList<Goods> goodlist = null;
				Users user = DAOFactory.getUserDAOInstance().queryByUsername(username);
				ArrayList<Goods> paylist = (ArrayList<Goods>) request.getSession().getAttribute("paylist");
				for (int i = 0; i < paylist.size(); i++) {
					goodlist = DAOFactory.getCartDAOInstance().deleteItem(username, paylist.get(i).getId());
					DAOFactory.getOrderDAOInstance().addOrder(user.getUid(),money,addressId);
				}
				//DAOFactory.getOrderDAOInstance().addOrder(user.getUid(),);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
