package EditUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

public class EditinfUserAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û���idֵ
		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
		//��ȡ�û����û���
		String uname = request.getParameter("uname");
		//��ȡ�û�email
		String phone = request.getParameter("phone");
		try{
			//�����û�����ѯ�û�
			Users user=DAOFactory.getUserDAOInstance().queryByUsername(
					String.valueOf(request.getSession().getAttribute("username")));
			if(user.getUsername().equals(uname)||
					DAOFactory.getUserDAOInstance().
					queryByUsername(uname).getUid()==0){//�û���δע��
				if(user.getPhone().equals(phone)||
						DAOFactory.getUserDAOInstance().
						queryByPhone(phone).getUid()==0){//����δ��ע��
					if(DAOFactory.getUserDAOInstance().
							editInf(uid, uname, phone)==1){//�û���Ϣ�޸ĳɹ�
						request.getSession().setAttribute("username", uname);
						request.setAttribute("status", "��Ϣ�޸ĳɹ���");
					}else{//�û���Ϣ�޸�ʧ��
						request.setAttribute("status", "�޸Ĳ���ʧ�ܣ������ԣ�");
					}
				}else{//�����Ѿ���ע��
					request.setAttribute("status", "���������˺��ѱ�ע��,�뻻һ����");
				}
			}else{//�ж��û����Ѿ�����
				request.setAttribute("status", "�û����Ѵ��ڣ��뻻һ����");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "home.jsp";
	}

}
