package User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

public class EditUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			Users user = DAOFactory.getUserDAOInstance().queryByUsername(""); 
		}catch(Exception e){
			
		}
		
		
		return null;
	}

}
