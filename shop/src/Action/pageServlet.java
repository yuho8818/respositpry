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
		
//		String keyWord = null;
//		if(request.getParameter("keyWord") == null){
//			keyWord = (String) request.getAttribute("keyWord");
//		}else{
//			keyWord = request.getParameter("keyWord");
//		}
		String keyWord =  request.getParameter("keyWord");
		String action = request.getParameter("action");
		if(keyWord==null){
			keyWord = (String) request.getSession().getAttribute("keyWord");
			if(keyWord==null){
				keyWord = "";
			}
		}
		request.getSession().setAttribute("keyWord", keyWord);
		request.setAttribute("keyWord", keyWord);
		keyWord = new String(keyWord.getBytes("iso-8859-1"),"utf-8");		
		
		System.out.println("keyWord in pageServlet** "+keyWord);
		
		         int currentpage = Integer.parseInt(currentpageStr);
		         // 每页显示多少条
		         int maximum = 8;
		         // 可以显示多少页
		         int viewperpage = 5;
		         
		         long totalrecordnumber = 0;
		         
	   ArrayList<Goods> list = new ArrayList<Goods>();
	   try {
		if(action.equals("default")){
			list = DAOFactory.getGoodsDAOInstance().queryByKeyword(keyWord,currentpage,maximum);
			totalrecordnumber = DAOFactory.getGoodsDAOInstance().queryNumber(keyWord);
			request.setAttribute("action", "default");
		}else if(action.equals("priceUp")){
			list = DAOFactory.getGoodsDAOInstance().queryByPriceUp(keyWord,currentpage,maximum);
			totalrecordnumber = DAOFactory.getGoodsDAOInstance().queryNumber(keyWord);
			request.setAttribute("action", "priceUp");
		}else if(action.equals("priceDown")){
			list = DAOFactory.getGoodsDAOInstance().queryByPriceDown(keyWord,currentpage,maximum);
			totalrecordnumber = DAOFactory.getGoodsDAOInstance().queryNumber(keyWord);
			request.setAttribute("action", "priceDown");
		}else if(action.equals("priceBetween")){
			int min_price = 0;
			int max_price = 99999;
			if(request.getParameter("min_price")==""){
				
			}else{
				min_price=Integer.parseInt(request.getParameter("min_price"));
			}
			if(request.getParameter("max_price")==""){
				
			}else{
				max_price = Integer.parseInt(request.getParameter("max_price"));
			}			
			list = DAOFactory.getGoodsDAOInstance().queryByPriceBetween(keyWord,currentpage,maximum,min_price,max_price);
			totalrecordnumber = DAOFactory.getGoodsDAOInstance().queryNumber(keyWord,min_price,max_price);
			request.setAttribute("action", "priceBetween");
			request.setAttribute("min_price", min_price);
			request.setAttribute("max_price", max_price);
		}
		
	   
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
         request.getSession().setAttribute("pageView", pageView);
         request.getSession().setAttribute("list", list);
         request.getRequestDispatcher("shoplist.jsp").forward(request, response);
	}

}
   
