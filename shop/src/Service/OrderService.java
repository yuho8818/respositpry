package Service;

import java.util.ArrayList;

import DB.DBConnection;
import Dao.CartDao;
import Dao.CartDaoImpl;
import Dao.OrderDao;
import Dao.OrderDaoImpl;
import pojo.Order;

public class OrderService implements OrderDao{
	private DBConnection dbconn = null;
	private OrderDao dao = null;
	
	public OrderService() throws Exception{
		this.dbconn = new DBConnection();
		this.dao = new OrderDaoImpl(this.dbconn.getConnection());
}

	@Override
	public void addOrder(Order order) throws Exception {
		try{
		this.dao.addOrder(order);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
	}

	@Override
	public int getMaxId() throws Exception {
		int id = 0;
		try{
			id = this.dao.getMaxId();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return id;
	}

	@Override
	public void AddPaied(Order order) throws Exception {
		try{
			this.dao.AddPaied(order);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
	}

	@Override
	public ArrayList<Order> getAllOrder(int Uid) throws Exception {
		ArrayList<Order> orderlist = null;
		try{
			orderlist = this.dao.getAllOrder(Uid);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		return orderlist;
	}

	@Override
	public ArrayList<Order> getPaiedGoods(ArrayList<Order> orderlist) throws Exception {
		try{
			orderlist = this.dao.getPaiedGoods(orderlist);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		return orderlist;
	}

}
