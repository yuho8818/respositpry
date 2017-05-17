package pojo;

import java.util.ArrayList;

public class Order {
    private String time;//成交时间
    private int Uid;//用户id
    private int money;//订单金额
    private int addressId;//收货地址id
    private int orderId;//PK，订单号
    private ArrayList<Goods> paiedlist;//一个订单已支付商品list
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
