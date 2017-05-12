package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import pojo.Goods;
import pojo.Users;
import pojo.userAddress;

public class UserDaoImpl implements UserDao{
	
	private Connection conn = null;
	private PreparedStatement presta = null;
	ResultSet rs = null;
	
	public UserDaoImpl(Connection conn){
		this.conn = conn;
	}

	@Override
	public int addUser(Users user) throws Exception {
		String sql = "insert users set phone=?,username=?,password=?";
		int result= 0 ; 
		presta = this.conn.prepareStatement(sql);
		presta.setString(1, user.getPhone());
		presta.setString(2, user.getUsername());
		presta.setString(3, user.getPassword());
		result = presta.executeUpdate();
		presta.close();
		return result;
	}
	
	public Users queryByPhone(String phone) throws SQLException  {
		Users user = new Users();
//		ArrayList userlist = new ArrayList();
		System.out.println("queeryByPhone1");
		String sql = "select * from users where phone=?";
//		String sql = "select * from users";
		presta = this.conn.prepareStatement(sql);
		presta.setString(1, phone);
		rs = presta.executeQuery();
		System.out.println("queeryByPhone2");
		if(rs.next()){			
			user.setPhone(rs.getString(1));
			System.out.println(rs.getString(1));
			user.setUsername(rs.getString(2));
			System.out.println(rs.getString(2));
			user.setPassword(rs.getString(3));
			System.out.println(rs.getString(3));
			user.setUid(rs.getInt(4));
			System.out.println(rs.getInt(4));
//			userlist.add(user);
		}else{
			System.out.println("没找到相同");
			user.setUid(0);
		}
		rs.close();
		presta.close();
//		Users user = null;
//		Iterator iterator = userlist.iterator();
//		while(iterator.hasNext()){
//			System.out.println("寻找开始");
//			user =(Users) iterator.next(); 
//			if(user.getPhone().equals(phone)){
//				System.out.println("找到相同"+user.getPhone()+"="+phone);
//				break;
//			}
//			else{
//				user.setUid(0);
//				System.out.println("没找到");
//			}
//		}
//		
		return user;
	}
	
	public Users queryByUsername(String username) throws SQLException{
		Users user = new Users();
		String sql = "select * from users where username=?";
		presta = this.conn.prepareStatement(sql);
		presta.setString(1, username);
		rs = presta.executeQuery();
		if(rs.next()){			
			user.setPhone(rs.getString(1));
			System.out.println(rs.getString(1));
			user.setUsername(rs.getString(2));
			System.out.println(rs.getString(2));
			user.setPassword(rs.getString(3));
			System.out.println(rs.getString(3));
			user.setUid(rs.getInt(4));
			System.out.println(rs.getInt(4));
		}else{
			System.out.println("没找到相同");
			user.setUid(0);
		}
		rs.close();
		presta.close();
		return user;
		
	}
	public int editPasswd(int Uid,String passWord){
		String sql="update users set password=? where Uid=?";
		int result=0;
		try {
			presta=this.conn.prepareStatement(sql);
			presta.setString(1, passWord);
			presta.setInt(2, Uid);
			result=presta.executeUpdate();//执行数据库操作
			System.out.println("修改密码成功！");
			presta.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int editInf(int uid, String uname, String phone) throws Exception {
			System.out.println(uid+"---"+uname+"---"+phone);
			String sql="update users set username=?,phone=? where Uid=?";
			int result=0;
			try {
				presta=this.conn.prepareStatement(sql);//获取PreparedStatement对象
				presta.setString(1, uname);
				presta.setString(2, phone);
				presta.setInt(3, uid);
				result=presta.executeUpdate();//执行数据库操作
				System.out.println("修改用户信息成功！");
				presta.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	@Override
	public void editAddress(userAddress useraddress) throws Exception {
		String sql = "insert address set Uid=?,name=?,phone=?,province=?,city=?,town=?,deaddress=?";
       try{
		int result= 0 ; 
		presta = this.conn.prepareStatement(sql);
		presta.setInt(1, useraddress.getUid());
		presta.setString(2, useraddress.getName());
		presta.setString(3, useraddress.getPhone());
		presta.setString(4, useraddress.getProvince());
		presta.setString(5, useraddress.getCity());
		presta.setString(6, useraddress.getTown());
		presta.setString(7, useraddress.getDeadress());
		result = presta.executeUpdate();
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presta.close();
		
		
	}

	@Override
	public ArrayList<userAddress> queryAddress(int Uid) throws Exception {
		
		String sql = "select * from address where Uid = '"+Uid+"'";
		presta = this.conn.prepareStatement(sql);
		rs = presta.executeQuery();
		ArrayList<userAddress> list = new ArrayList<userAddress>(); 
		try{
		 while (rs.next()) {
			userAddress useraddress = new userAddress();
			useraddress.setUid(rs.getInt("Uid"));
			useraddress.setName(rs.getString("name"));
			useraddress.setPhone(rs.getString("phone"));
			useraddress.setProvince(rs.getString("province"));
			useraddress.setCity(rs.getString("city"));
			useraddress.setTown(rs.getString("town"));
			useraddress.setDeadress(rs.getString("deaddress"));
			useraddress.setIfdefault(rs.getBoolean("ifdefault"));
			useraddress.setId(rs.getInt("id"));
			list.add(useraddress);
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presta.close();
		return list;
	}

	@Override
	public void deleteAddress(int id) throws Exception {
		String sql = "delete from address where id ='" + id + "';";
		try{
		presta = this.conn.prepareStatement(sql);
		presta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presta.close();
	}

	@Override
	public void setDefaultAddress(int Uid, int id) throws Exception {
		String sql = "update address set ifdefault=? where Uid='" + Uid + "'";
		try{
		presta = this.conn.prepareStatement(sql);
		presta.setInt(1, 0);
		presta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = "update address set ifdefault=? where id='" + id + "'";
		try{
			presta = this.conn.prepareStatement(sql);
			presta.setInt(1, 1);
			presta.executeUpdate();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		presta.close();
	}

}
