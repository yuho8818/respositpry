package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Goods;

public class CartDaoImpl implements CartDao {

	private Connection conn = null;
	private PreparedStatement presta = null;
	ResultSet rs = null;

	public CartDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ArrayList<Goods> getAllItems(String username) throws SQLException {
		String sql = "select * from cart where username ='" + username + "';";
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
	public ArrayList<Goods> deleteItem(String username, int id) throws SQLException, Exception {
		String sql = "delete from cart where id ='" + id + "';";
		presta = this.conn.prepareStatement(sql);
		presta.executeUpdate();
		ArrayList<Goods> list = new ArrayList<Goods>();
		list = getAllItems(username);
		return list;
	}

	@Override
	public ArrayList<Goods> payAllItems(String username) throws SQLException, Exception {
		ArrayList<Goods> list = new ArrayList<Goods>();
		list = getAllItems(username);
		return list;
	}

	@Override
	public ArrayList<Goods> subNum(String username, int id) throws SQLException, Exception {
		String sql = "select * from cart where id ='" + id + "';";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		ArrayList<Goods> list = new ArrayList<Goods>();
		rs.next();
		int num=rs.getInt("number");
		num=num-1;
		sql = "update cart set number=? where id='" + id + "'";
		presta = this.conn.prepareStatement(sql);
		presta.setInt(1, num);
		presta.executeUpdate();
		System.out.println("成功！");
		rs.close();
		presta.close();
		list = getAllItems(username);
		return list;
	}

	@Override
	public ArrayList<Goods> addNum(String username, int id) throws SQLException, Exception {
		String sql = "select * from cart where id ='" + id + "';";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		ArrayList<Goods> list = new ArrayList<Goods>();
		rs.next();
		int num=rs.getInt("number");
		num=num+1;
		sql = "update cart set number=? where id='" + id + "'";
		presta = this.conn.prepareStatement(sql);
		presta.setInt(1, num);
		presta.executeUpdate();
		System.out.println("成功！");
		rs.close();
		presta.close();
		list = getAllItems(username);
		return list;
	}

	@Override
	public void addgoods(String username, Goods goods) throws SQLException, Exception {
		String sql = "insert into cart(id,name,city,number,price,picture,username) values(?,?,?,?,?,?,?)";
		presta = this.conn.prepareStatement(sql);
		presta.setInt(1, goods.getId());
		presta.setString(2,goods.getName());
		presta.setString(3, goods.getCity());
		presta.setInt(4,1);
		presta.setInt(5,goods.getPrice());
		presta.setString(6, goods.getPicture());
		presta.setString(7, username);
		presta.executeUpdate();
		presta.close();
		
	}
	
	

	@Override
	public ArrayList<Goods> getAllPaied(String username) throws SQLException, Exception {
		// TODO Auto-generated method stub
		String sql = "select * from paied where username ='" + username + "';";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		ArrayList<Goods> paied = new ArrayList<Goods>();
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setId(rs.getInt("id"));
			goods.setName(rs.getString("name"));
			goods.setCity(rs.getString("city"));
			goods.setNumber(rs.getInt("number"));
			goods.setPrice(rs.getInt("price"));
			goods.setPicture(rs.getString("picture"));
			paied.add(goods);
		}

		rs.close();
		presta.close();
		return paied;
	}

	@Override
	public boolean queryGoods(String username, int id) throws SQLException, Exception {
		String sql = "select * from cart where id = '"+id+"' and username = '"+username+"'";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		if(rs.next()){
			rs.close();
			presta.close();
			return false;
		}else{
			rs.close();
			presta.close();
			return true;
		}
		
	}

}
