package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBConnection;
import Dao.CartDao;
import Dao.CartDaoImpl;
import pojo.Goods;


public class CartService implements CartDao{
	private DBConnection dbconn = null;
	private CartDao dao = null;
	
	public CartService() throws Exception{
		this.dbconn = new DBConnection();
		this.dao = new CartDaoImpl(this.dbconn.getConnection());
}
	
	public ArrayList<Goods> getAllItems() throws Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.getAllItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
		
	}
}
