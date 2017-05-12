package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Goods;

public interface GoodsDao {
	public ArrayList<Goods> queryByKeyword(String keyWord,int currentpage,int maximum) throws SQLException, Exception;
	public ArrayList<Goods> queryByPriceUp(String keyWord,int currentpage,int maximum) throws SQLException, Exception;
	public ArrayList<Goods> queryByPriceDown(String keyWord,int currentpage,int maximum) throws SQLException, Exception;
	public ArrayList<Goods> queryByPriceBetween(String keyWord,int currentpage,int maximum,int min_price,int max_price) throws SQLException, Exception;
	public int queryNumber(String keyWord) throws SQLException;
	public int queryNumber(String keyWord,int min_price,int max_price) throws SQLException;
	public Goods queryById(int id) throws Exception;
}
