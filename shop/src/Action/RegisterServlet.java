package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DAOFactory;
import pojo.Users;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String path = null; 
		
		Users user = new Users();
		user.setPhone(phone);
		System.out.println(phone);
		user.setUsername(username);
		user.setPassword(password);
		
		try{
			if(DAOFactory.getUserDAOInstance().queryByUsername(username).getUid()==0){
                if((DAOFactory.getUserDAOInstance().queryByPhone(phone).getUid())==0){	
				System.out.println("yes");
				if(DAOFactory.getUserDAOInstance().addUser(user) == 1){
					request.setAttribute("status", "��ϲ����ע��ɹ���");
				}
				
		      }
            else{
			  request.setAttribute("status", "�ֻ����ѱ�ע��");
		     }
		}else{
			request.setAttribute("status", "�û����ѱ�ע��");
		}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dispather = getServletContext().getRequestDispatcher("/register_result.jsp");
		dispather.forward(request, response);
	}

}
