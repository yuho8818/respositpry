package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Goods;

public interface GoodsDao {
	public ArrayList<Goods> queryByKeyword(String keyWord,int currentpage,int maximum) throws SQLException, Exception;
	public int queryNumber(String keyWord) throws SQLException;
	public Goods queryById(int id) throws Exception;
}
