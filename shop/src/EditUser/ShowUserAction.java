package EditUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

/**
 *�鿴�û�
 */
public class ShowUserAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			//�����û�����ѯ�û�
			Users user = DAOFactory.getUserDAOInstance().queryByUsername(
					String.valueOf(request.getSession().getAttribute("username")));
			
			request.setAttribute("phone", user.getPhone());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "home.jsp";
	}
}
