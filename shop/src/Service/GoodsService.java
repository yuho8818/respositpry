package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBConnection;
import Dao.GoodsDao;
import Dao.GoodsDaoImpl;
import pojo.Goods;

public class GoodsService implements GoodsDao {
	private DBConnection dbconn = null;
	private GoodsDao dao = null;
	
	public GoodsService() throws Exception{
		this.dbconn = new DBConnection();
		this.dao = new GoodsDaoImpl(this.dbconn.getConnection());
}
	
	public ArrayList<Goods> queryByKeyword(String keyWord,int currentpage,int maximum) throws Exception {
		
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.queryByKeyword(keyWord,currentpage,maximum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
		
	}
	
	public int queryNumber(String keyWord) {
		int number = 0;
		try {
			number = this.dao.queryNumber(keyWord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
		
	}
	
	public Goods queryById(int id){
		Goods goods = null;
		try{
			 goods = this.dao.queryById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return goods;
		
	}

	@Override
	public ArrayList<Goods> queryByPriceUp(String keyWord, int currentpage, int maximum)
			throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.queryByPriceUp(keyWord,currentpage,maximum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public ArrayList<Goods> queryByPriceDown(String keyWord, int currentpage, int maximum)
			throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.queryByPriceDown(keyWord,currentpage,maximum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public ArrayList<Goods> queryByPriceBetween(String keyWord, int currentpage, int maximum,int min_price,int max_price)
			throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<>();
		try {
			list = this.dao.queryByPriceBetween(keyWord,currentpage,maximum,min_price,max_price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.dbconn.close();
		}
		
		return list;
	}

	@Override
	public int queryNumber(String keyWord, int min_price, int max_price) throws SQLException {
		int number = 0;
		try {
			number = this.dao.queryNumber(keyWord,min_price,max_price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
}
