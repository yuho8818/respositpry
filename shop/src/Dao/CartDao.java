package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Goods;



public interface CartDao {
	public ArrayList<Goods> getAllItems(String username) throws SQLException, Exception;
	public ArrayList<Goods> deleteItem(String username,int id) throws SQLException, Exception;
	public ArrayList<Goods> payAllItems(String username)throws SQLException, Exception;
	public ArrayList<Goods> subNum(String username,int id)throws SQLException, Exception;
	public ArrayList<Goods> addNum(String username,int id)throws SQLException, Exception;
	public void addgoods(String username,Goods goods)throws SQLException, Exception;
}
