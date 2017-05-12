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
	
	public ArrayList<Goods> getAllItems(String username) throws Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.getAllItems(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
		
	}

	@Override
	public ArrayList<Goods> deleteItem(String username, int id) throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.deleteItem(username,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public ArrayList<Goods> payAllItems(String username) throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.payAllItems(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public ArrayList<Goods> subNum(String username, int id) throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.subNum(username,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public ArrayList<Goods> addNum(String username, int id) throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.addNum(username,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public void addgoods(String username, Goods goods) throws SQLException, Exception {
		try{
		this.dao.addgoods(username, goods);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void addpaied(String username, Goods goods) throws SQLException, Exception {
		try{
		this.dao.addpaied(username, goods);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Goods> getAllPaied(String username) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.getAllPaied(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		return list;
	}
}
