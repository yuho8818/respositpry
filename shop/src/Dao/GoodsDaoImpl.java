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
		String sql = "select * from goods where name like '%"+keyWord+"%' limit "+ (currentpage - 1) * maximum + "," + maximum;
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
		String sql = "select * from goods where name like '%"+keyWord+"%'";
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
	
	public Goods queryById(int id) throws Exception{
		Goods goods = null;
		String sql = "select * from goods where id="+id;
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		while(rs.next()){
			goods = new Goods();
			goods.setId(rs.getInt("id"));
			goods.setName(rs.getString("name"));
			goods.setCity(rs.getString("city"));
			goods.setNumber(rs.getInt("number"));
			goods.setPrice(rs.getInt("price"));
			goods.setPicture(rs.getString("picture"));
			goods.setImg1(rs.getString("img1"));
			goods.setImg2(rs.getString("img2"));
			goods.setImg3(rs.getString("img3"));
			goods.setOprice(rs.getInt("Oprice"));
			goods.setMonSale(rs.getInt("monSale"));
			goods.setTotalSale(rs.getInt("totalSale"));
			goods.setEvaluation(rs.getInt("evaluation"));
		}
		rs.close();
		presta.close();
		return goods;
	}

	@Override
	public ArrayList<Goods> queryByPriceUp(String keyWord, int currentpage, int maximum)
			throws SQLException, Exception {
		String sql = "select * from goods where name like '%"+keyWord+"%' order by price asc limit "+ (currentpage - 1) * maximum + "," + maximum;
		
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

	@Override
	public ArrayList<Goods> queryByPriceDown(String keyWord, int currentpage, int maximum)
			throws SQLException, Exception {
        String sql = "select * from goods where name like '%"+keyWord
        +"%' order by price desc limit "+ (currentpage - 1) * maximum + "," + maximum;		
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

	@Override
	public ArrayList<Goods> queryByPriceBetween(String keyWord, int currentpage, int maximum,int min_price,int max_price)
			throws SQLException, Exception {
		String sql = "select * from goods where price >="+min_price+" and price<="+max_price
				+" and name like '%"+keyWord+"%' limit "+ (currentpage - 1) * maximum + "," + maximum;
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

	@Override
	public int queryNumber(String keyWord, int min_price, int max_price) throws SQLException {
		String sql = "select * from goods where price >="+min_price+" and price<="+max_price+" and name like '%"+keyWord+"%'";
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
