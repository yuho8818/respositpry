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

public class DeleteAddressAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = (String) request.getSession().getAttribute("username");
		String path =  request.getParameter("path");
		Users user = null;
		try {
			user =DAOFactory.getUserDAOInstance().queryByUsername(username);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int Uid = user.getUid();
		try {
			DAOFactory.getUserDAOInstance().deleteAddress(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<userAddress> list = null;
		try {
			list = DAOFactory.getUserDAOInstance().queryAddress(Uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().removeAttribute("list");
		request.getSession().setAttribute("list", list);
		if(path==null){
			return "editAddress.jsp";
		}else{
			return path;
		}
		
	}

}
