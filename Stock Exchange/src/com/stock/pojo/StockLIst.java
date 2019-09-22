package com.stock.pojo;

public class StockLIst {     // implements Comparable<StockLIst>{
	
	private float price;
	private int user_id,stock_holding_uid,id;
	private String Type, shares,transaction_time;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getStock_holding_uid() {
		return stock_holding_uid;
	}
	public void setStock_holding_uid(int stock_holding_uid) {
		this.stock_holding_uid = stock_holding_uid;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getShares() {
		return shares;
	}
	public void setShares(String shares) {
		this.shares = shares;
	}
	public String getTransaction_time() {
		return transaction_time;
	}
	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}
	
	/*
	 * @Override public int compareTo(StockLIst o) { // TODO Auto-generated method
	 * stub return 0; }
	 */
	
	

}
