package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDaoImpl implements OrderDao{
	private Connection conn = null;
	private PreparedStatement presta = null;
	ResultSet rs = null;
	
	public OrderDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public void addOrder(int Uid,int money,int addressId) throws Exception {
		
		
	}

}
