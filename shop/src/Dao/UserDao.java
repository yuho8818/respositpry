package Dao;


import pojo.Users;

public interface UserDao {
       public int addUser(Users user) throws Exception;
       public Users queryByPhone(String phone) throws Exception;
       public Users queryByUsername(String username) throws Exception;
       public int editPasswd(int Uid,String passWord) throws Exception;
       public int editInf(int uid,String uname,String email) throws Exception;
}
