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

public class EditAddressAction implements Action{

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
		String path =request.getParameter("path");
		System.out.println("path"+path);
		userAddress useraddress = new userAddress();
		
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"),"utf-8");
		useraddress.setName(name);
		
		String phone = request.getParameter("phone");
		phone = new String(phone.getBytes("iso-8859-1"),"utf-8");
		useraddress.setPhone(phone);
		
		String province = request.getParameter("province");
		province = new String(province.getBytes("iso-8859-1"),"utf-8");
		useraddress.setProvince(province);
		
		String city = request.getParameter("city");
		city = new String(city.getBytes("iso-8859-1"),"utf-8");
		useraddress.setCity(city);
		
		String town = request.getParameter("town");
		town = new String(town.getBytes("iso-8859-1"),"utf-8");
		useraddress.setTown(town);
		
		String deaddress = request.getParameter("deaddress");
		deaddress = new String(deaddress.getBytes("iso-8859-1"),"utf-8");
		useraddress.setDeadress(deaddress);
		
		useraddress.setUid(user.getUid());
		
		ArrayList<userAddress> list = null;
		try {			
			DAOFactory.getUserDAOInstance().editAddress(useraddress);
			list = DAOFactory.getUserDAOInstance().queryAddress(user.getUid());
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
