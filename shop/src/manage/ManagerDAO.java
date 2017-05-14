package manage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Goods;
import pojo.manager;
public class ManagerDAO {
	static Connection cn;
	private static PreparedStatement presta = null;
	static ResultSet rs = null;
	private static final long serialVersionUID = 1L;
    public ManagerDAO() {
        super();
        
        // TODO Auto-generated constructor stub
    }
	public static int checkmanager(manager manag)
	{
		System.out.println(manag.getadname());
		int flag=0;
		String sql="select * from manager where adname='"+manag.getadname()+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","888888");
			presta = cn.prepareStatement(sql);
			rs = presta.executeQuery(sql);
			if(rs.next())
			{
				if(manag.getPassword().equals(rs.getString("password")))
				{
					flag=1;//表示验证成功
				}
				else{flag=0;}
			}
			else{flag=0;}
			}catch(Exception e){flag=0;e.printStackTrace();}
		  finally {try {
			  presta.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		System.out.println(flag);
		return flag;
		

		
	}
	
	

}






















