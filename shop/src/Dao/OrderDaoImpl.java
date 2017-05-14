package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Factory.DAOFactory;
import pojo.Goods;
import pojo.Order;

public class OrderDaoImpl implements OrderDao{
	private Connection conn = null;
	private PreparedStatement presta = null;
	ResultSet rs = null;
	
	public OrderDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public void addOrder(Order order) throws Exception {
		String sql="insert into orders (time,Uid,addressId,money) values(?,?,?,?)";
		presta = this.conn.prepareStatement(sql);
		presta.setString(1, order.getTime());
		presta.setInt(2,order.getUid());
		presta.setInt(3, order.getAddressId());
		presta.setInt(4,order.getMoney());
		presta.executeUpdate();
		presta.close();
		
	}

	@Override
	public int getMaxId() throws Exception {
		int id = 0;
		String sql = "select * from orders";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		while(rs.next()){
			if(id<rs.getInt("orderId")){
				id = rs.getInt("orderId");
			}
		}
		presta.close();
		return id;
	}

	@Override
	public void AddPaied(Order order) throws Exception {
		for(int i = 0;i<order.getPaiedlist().size();i++){
		String sql = "insert into paied (orderId,Uid,goodsId,number) values(?,?,?,?)";
		presta = this.conn.prepareStatement(sql);
		presta.setInt(1, order.getOrderId());
		presta.setInt(2,order.getUid());
		presta.setInt(3, order.getPaiedlist().get(i).getId());
		presta.setInt(4, order.getPaiedlist().get(i).getNumber());
		presta.executeUpdate();
		}
		presta.close();
	}

	@Override
	public ArrayList<Order> getAllOrder(int Uid) throws Exception {
		ArrayList<Order> orderlist = new ArrayList<Order>();
		String sql = "select * from Orders where Uid='"+Uid+"' Order by orderId desc";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		while(rs.next()){
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setTime(rs.getString("time"));
			order.setAddressId(rs.getInt("addressId"));
			order.setMoney(rs.getInt("money"));
			order.setUid(rs.getInt("Uid"));
			orderlist.add(order);
		}
		return orderlist;
	}

	@Override
	public ArrayList<Order> getPaiedGoods(ArrayList<Order> orderlist) throws Exception {
		for(int i = 0;i<orderlist.size();i++){
			String sql = "select * from paied where orderId = '"+orderlist.get(i).getOrderId()+"'";
			presta = this.conn.prepareStatement(sql);
			rs = presta.executeQuery();
			
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("goodsId"));
				goods = DAOFactory.getGoodsDAOInstance().queryById(goods.getId());
				goods.setNumber(rs.getInt("number"));
				orderlist.get(i).getPaiedlist().add(goods);
			}
			
		}
		return orderlist;
	}

}
