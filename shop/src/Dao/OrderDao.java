package Dao;

import java.util.ArrayList;

import pojo.Order;

public interface OrderDao {
     public void addOrder(Order order) throws Exception;
     public int getMaxId() throws Exception;
     public void AddPaied(Order order) throws Exception;
     public ArrayList<Order> getAllOrder(int Uid) throws Exception;
     public ArrayList<Order> getPaiedGoods(ArrayList<Order> orderlist) throws Exception;
}
