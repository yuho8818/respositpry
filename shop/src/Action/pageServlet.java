package Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.DAOFactory;
import page.PageView;
import pojo.Goods;

/**
 * Servlet implementation class pageServlet
 */
@WebServlet("/pageServlet")
public class pageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public pageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showtwo(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showtwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String currentpageStr = request.getParameter("currentpage") == null ? "1"
		           : request.getParameter("currentpage");
		String keyWord = null;
		         int currentpage = Integer.parseInt(currentpageStr);
		         // 每页显示多少条
		         int maximum = 6;
		         // 可以显示多少页
		         int viewperpage = 5;
		         
		         long totalrecordnumber = 0;
		         
	   ArrayList<Goods> list = new ArrayList();
	   try {
		list = DAOFactory.getGoodsDAOInstance().queryByKeyword(keyWord,currentpage,maximum);
	    totalrecordnumber = DAOFactory.getGoodsDAOInstance().queryNumber("");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// 将数据都封装到pageView
       PageView pageView =new PageView(list, totalrecordnumber, currentpage, maximum, viewperpage);
        // PageView<Student> pageView = new PageView<Student>(records,totalrecordnumber, currentpage, maximum, viewperpage);
         request.setAttribute("pageView", pageView);
         request.setAttribute("list", list);
         request.getRequestDispatcher("shoplist.jsp").forward(request, response);
	   
	}

}
   
