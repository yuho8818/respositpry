package EditUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

public class EditPasswdAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û����û���ֵ
		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
		//��ȡ������
		String oldPasswd = request.getParameter("oldPasswd");
		//��ȡ������
		String passwd = request.getParameter("passwd1");
		String confirdPasswd = request.getParameter("passwd2");
		try{
			//�����û�����ѯ�û�
			Users user =DAOFactory.getUserDAOInstance().
				queryByUsername(String.valueOf(
						request.getSession().getAttribute("username")));
			//�ж�����ľ������ԭ���ľ������Ƿ�һ�£�
			//���һ�½����޸�
			if(user.getPassword().equals(oldPasswd)){
				if(isValidPassword(passwd,confirdPasswd)){//��֤����
					request.setAttribute("status", "����Ϊ�ջ������벻һ�£�");
				}
				if(DAOFactory.getUserDAOInstance().
						editPasswd(uid, passwd)==1){//�����޸ĳɹ�
					request.setAttribute("status", "�����޸ĳɹ���");
				}else{//�����޸�ʧ��
					request.setAttribute("status", "�����޸Ĳ���ʧ�ܣ������ԣ�");
				}
			}else{//�����������
				request.setAttribute("status", "ԭ��������㲻���޸����룡");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "editpassed.jsp";
	}
	//��֤���룬�������Ϊ���ҳ���С��6���Ҹ�ȷ�����벻ͳһ
	//����true
	public boolean isValidPassword(String passwd,String confirdPasswd){
		return passwd==null||confirdPasswd==null
		||passwd.length()<6||confirdPasswd.length()<6
		||!passwd.equals(confirdPasswd);
	}
}
