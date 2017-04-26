package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Goods;

public class GoodsDaoImpl implements GoodsDao{
	private Connection conn = null;
	private PreparedStatement presta = null;
	ResultSet rs = null;
	
	public GoodsDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	public ArrayList<Goods> queryByKeyword(String keyWord,int currentpage,int maximum) throws SQLException, Exception {
		String sql = "select * from goods limit "+ (currentpage - 1) * maximum + "," + maximum;
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
	
	public int queryNumber(String keyWord) throws SQLException{
		String sql = "select * from goods";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		int number = 0;
		while (rs.next()) {
			number++; 
		}
		rs.close();
		presta.close();
		return number;
		
	}

}
