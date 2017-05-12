package User;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;
import pojo.userAddress;

public class ShowAddressAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		Users user = null;
		try {
			user =DAOFactory.getUserDAOInstance().queryByUsername(username);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<userAddress> list = null;
		try {		
		    list = DAOFactory.getUserDAOInstance().queryAddress(user.getUid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().removeAttribute("list");
		request.getSession().setAttribute("list", list);
		return "editAddress.jsp";
	}

}
