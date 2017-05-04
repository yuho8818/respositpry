package Service;

import DB.DBConnection;
import Dao.UserDao;
import Dao.UserDaoImpl;
import pojo.Users;

public class UsersService implements UserDao{
	private DBConnection dbconn = null;
	private UserDao dao = null;
	
	public UsersService() throws Exception{
		this.dbconn = new DBConnection();
		this.dao = new UserDaoImpl(this.dbconn.getConnection());
		
	}

	@Override
	public int addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		try{
			result = this.dao.addUser(user);
		}catch(Exception e){
			throw e;
		}finally{
			dbconn.close();
		}
		return result;
	}
	
	public Users queryByPhone(String phone) throws Exception{
		Users user = new Users();
		try {
			user = this.dao.queryByPhone(phone);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return user;
	}
	public Users queryByUsername(String username) throws Exception{
		Users user = new Users();
		try {
			user = this.dao.queryByUsername(username);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return user;
	}

	public int editInf(int Uid, String uname, String phone) throws Exception {
		int result = 0;
		try {
			result = this.dao.editInf(Uid, uname, phone);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	public int editPasswd(int Uid, String passWord) throws Exception {
		int result = 0;
		try {
			result = this.dao.editPasswd(Uid, passWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	

}
