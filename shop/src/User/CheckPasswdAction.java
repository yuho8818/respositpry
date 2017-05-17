package User;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Factory.DAOFactory;
import pojo.Users;

public class CheckPasswdAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û���idֵ
		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
		//��ȡ�û����û���
		String uname = request.getParameter("uname");
		//��ȡ�û��绰
		String phone = request.getParameter("phone");
		String p1="^[0-9]*[1-9][0-9]*$";
		String p2="^[A-Za-z0-9]+$";
		String p3="^[A-Za-z]+$";
		int Score=0;
		try{
			//�����û�����ѯ�û�
			Users user=DAOFactory.getUserDAOInstance().queryByUsername(
					String.valueOf(request.getSession().getAttribute("username")));
			//��ȡ�û���ȫ����
			String passwd=user.getPassword();
			int i=passwd.length();
			if(getSafety(p1,passwd)){
				if(i<=5){
					Score=i*5;
				}else{
					Score=25;
				}
				
			}else if(getSafety(p3,passwd)){
				if(i<=5){
					Score=i*5;
				}else{
					Score=25;
				}
			}else if(getSafety(p2,passwd)){
				if(i<=10){
					Score=i*10;
				}else{
					Score=100;
				}
			}
			request.getSession().setAttribute("Safety", Score);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "editpasswd.jsp";
	}
	boolean getSafety(String p,String Stringchecked){
		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(Stringchecked);
		 boolean rs = matcher.matches();
		return rs;
	}

}
