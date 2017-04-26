package Factory;

import Dao.CartDao;
import Dao.GoodsDao;
import Dao.UserDao;
import Service.CartService;
import Service.GoodsService;
import Service.UsersService;

public class DAOFactory {
	
	public static UserDao getUserDAOInstance() throws Exception{
		return new UsersService();
	}
	public static CartDao getCartDAOInstance() throws Exception{
		return  new CartService();
	}
	public static GoodsDao getGoodsDAOInstance() throws Exception{
		return  new GoodsService();
	}

}
