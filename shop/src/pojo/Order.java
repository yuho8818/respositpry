package pojo;

import java.util.ArrayList;

public class Order {
    private String time;
    private int Uid;
    private int money;
    private int addressId;
    private int orderId;
    private ArrayList<Goods> paiedlist;
    public Order(){
    	this.paiedlist = new ArrayList<Goods>();
    }
    
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public ArrayList<Goods> getPaiedlist() {
		return paiedlist;
	}
	public void setPaiedlist(ArrayList<Goods> paiedlist) {
		this.paiedlist = paiedlist;
	}
}
