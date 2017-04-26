package Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.EditPasswdAction;
import User.EditUserAction;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet(
		urlPatterns = { "/user" }, 
		name = "userServlet" 
	)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Action targetAction =null;
		String path = null;
		if (action.equals("show")) {//�鿴�û��б�
//			targetAction = new ShowUserAction();
//			path=targetAction.execute(request, response);
		} else if (action.equals("edit")) {//��ת�༭�û�ҳ��
			targetAction = new EditUserAction();
			path=targetAction.execute(request, response);
		} else if (action.equals("editinf")) {//�޸��û���Ϣ
//			targetAction = new EditinfUserAction();
//			path=targetAction.execute(request, response);
		} else if (action.equals("editpasswd")) {//��������
			targetAction = new EditPasswdAction();
			path=targetAction.execute(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
