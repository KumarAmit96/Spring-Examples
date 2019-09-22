package com.stock.pojo;
import java.io.*;
import java.sql.*;
import java.util.*;

public class UpdatedArraylist{


	
	/*
	 * ArrayList<StockLIst> arraylist = new ArrayList<>(); ArrayList<StockLIst>
	 * salelist = new ArrayList<>(); ArrayList<StockLIst> buylist = new
	 * ArrayList<>(); Connection con = null; String url =
	 * "jdbc:mysql://127.0.0.1:3306/"; Statement st = null; ResultSet rs; // my sql
	 * server IP String db = "stocks"; String driver = "com.mysql.jdbc.Driver";
	 * String userName = "root"; String password = "honda5112amit"; try {
	 * Class.forName(driver); con = DriverManager.getConnection(url + db, userName,
	 * password); st = con.createStatement(); String sql =
	 * "select * from stock order by id"; rs = st.executeQuery(sql); while
	 * (rs.next()) { StockLIst stock = new StockLIst();
	 * 
	 * if (rs.getString("Type").equals("buy")) {
	 * stock.setPrice(Float.parseFloat(rs.getString("price")));
	 * stock.setStock_holding_uid(Integer.parseInt(rs.getString("stock_holding_uid")
	 * )); stock.setUser_id(Integer.parseInt(rs.getString("user_id")));
	 * stock.setTransaction_time(rs.getString("transaction_time"));
	 * stock.setShares(rs.getString("shares")); stock.setType(rs.getString("Type"));
	 * stock.setId(Integer.parseInt(rs.getString("id"))); buylist.add(stock); } else
	 * { stock.setPrice(Float.parseFloat(rs.getString("price")));
	 * stock.setStock_holding_uid(Integer.parseInt(rs.getString("stock_holding_uid")
	 * )); stock.setUser_id(Integer.parseInt(rs.getString("user_id")));
	 * stock.setTransaction_time(rs.getString("transaction_time"));
	 * stock.setShares(rs.getString("shares")); stock.setType(rs.getString("Type"));
	 * stock.setId(Integer.parseInt(rs.getString("id"))); salelist.add(stock); } }
	 * 
	 * StockLIst temp, temp2;
	 * 
	 * for (int j = 0; j < salelist.size() - 1; j++) { if
	 * (salelist.get(j).getPrice() > salelist.get(j + 1).getPrice()) { temp =
	 * salelist.get(j + 1); temp2 = salelist.get(j); int k = salelist.indexOf(temp);
	 * int l = salelist.indexOf(temp2); salelist.remove(k); salelist.remove(l);
	 * salelist.add(l, temp); salelist.add(k, temp2);
	 * 
	 * } }
	 * 
	 * } catch(Exception e) { e.printStackTrace(); }
	 */

	
}
