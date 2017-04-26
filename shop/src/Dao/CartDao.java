package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Goods;



public interface CartDao {
	public ArrayList<Goods> getAllItems() throws SQLException, Exception;
	
}
