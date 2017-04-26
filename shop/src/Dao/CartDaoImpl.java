package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Goods;

public class CartDaoImpl implements CartDao{
	
	private Connection conn = null;
	private PreparedStatement presta = null;
	ResultSet rs = null;
	
	public CartDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public ArrayList<Goods> getAllItems() throws SQLException {
		String sql = "select * from cart;";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		ArrayList<Goods> list = new ArrayList<Goods>(); 
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setId(rs.getInt("id"));
			goods.setName(rs.getString("name"));
			goods.setCity(rs.getString("city"));
			goods.setNumber(rs.getInt("number"));
			goods.setPrice(rs.getInt("price"));
			goods.setPicture(rs.getString("picture"));
			list.add(goods);
		}
		
		rs.close();
		presta.close();
		return list; 

	}

}
