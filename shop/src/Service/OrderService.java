package Service;

import DB.DBConnection;
import Dao.CartDao;
import Dao.CartDaoImpl;
import Dao.OrderDao;
import Dao.OrderDaoImpl;

public class OrderService implements OrderDao{
	private DBConnection dbconn = null;
	private OrderDao dao = null;
	
	public OrderService() throws Exception{
		this.dbconn = new DBConnection();
		this.dao = new OrderDaoImpl(this.dbconn.getConnection());
}

	@Override
	public void addOrder(int Uid,int money,int addressId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
