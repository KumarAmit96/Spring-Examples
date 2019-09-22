<%@page import="java.util.*"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.lang.*" import="java.sql.*" import="java.text.*"
	import="com.stock.pojo.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Exchange</title>
</head>
<body>

	<%
		ArrayList<StockLIst> arraylist = new ArrayList<>();
		ArrayList<StockLIst> salelist = new ArrayList<>();
		ArrayList<StockLIst> buylist = new ArrayList<>();
		Connection con = null;
		String url = "jdbc:mysql://127.0.0.1:3306/";
		Statement st = null;
		ResultSet rs;
		//my sql server IP 
		String db = "stocks"; // this is the database name 
		String driver = "com.mysql.jdbc.Driver"; //this is the driver name 
		String userName = "root"; //this is mysql user name 
		String password = "honda5112amit"; // this is mysql password 
		String share = request.getParameter("share");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String type = request.getParameter("custId");
		java.util.Date date = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		String time = dateFormat.format(Calendar.getInstance().getTime());
		int id = (int) session.getAttribute("id");
		System.out.print(id);
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, userName, password);
			st = con.createStatement();
			String qwery = "insert into stock(price,shares,transaction_time,user_id,stock_holding_uid,Type) values ('"
					+ Float.parseFloat(price) + "','" + share + "','" + time + "','" + id + "','"
					+ Integer.parseInt(quantity) + "','" + type + "')";
			int ii = st.executeUpdate(qwery);
			if (ii > 0)
			{
				System.out.print("Data inserted....");

				String sql = "select * from stock order by id";
				rs = st.executeQuery(sql);
				while (rs.next()) {
					StockLIst stock = new StockLIst();

					if (rs.getString("Type").equals("buy")) {
						stock.setPrice(Float.parseFloat(rs.getString("price")));
						stock.setStock_holding_uid(Integer.parseInt(rs.getString("stock_holding_uid")));
						stock.setUser_id(Integer.parseInt(rs.getString("user_id")));
						stock.setTransaction_time(rs.getString("transaction_time"));
						stock.setShares(rs.getString("shares"));
						stock.setType(rs.getString("Type"));
						stock.setId(Integer.parseInt(rs.getString("id")));
						buylist.add(stock);
					} else {
						stock.setPrice(Float.parseFloat(rs.getString("price")));
						stock.setStock_holding_uid(Integer.parseInt(rs.getString("stock_holding_uid")));
						stock.setUser_id(Integer.parseInt(rs.getString("user_id")));
						stock.setTransaction_time(rs.getString("transaction_time"));
						stock.setShares(rs.getString("shares"));
						stock.setType(rs.getString("Type"));
						stock.setId(Integer.parseInt(rs.getString("id")));
						salelist.add(stock);
					}
				}

				StockLIst temp, temp2;

				for (int j = 0; j < salelist.size() - 1; j++) {
					if (salelist.get(j).getPrice() > salelist.get(j + 1).getPrice()) {
						temp = salelist.get(j + 1);
						temp2 = salelist.get(j);
						int k = salelist.indexOf(temp);
						int l = salelist.indexOf(temp2);
						salelist.remove(k);
						salelist.remove(l);
						salelist.add(l, temp);
						salelist.add(k, temp2);

					}
				}

				for (int i = 0; i < buylist.size(); i++) {
					for (int j = 0; j < salelist.size(); j++) {
						System.out.print("Inside Arraylist....");
						String buyData = buylist.get(i).getShares();
						String saleData = salelist.get(j).getShares();
						if ((buyData.equals(saleData))
								&& (buylist.get(i).getPrice() > salelist.get(j).getPrice())) {
							try {
								st = con.createStatement();
								PreparedStatement ps;
								int remain_stock, stock,gg=0;
								if (buylist.get(i).getStock_holding_uid() > salelist.get(j)
										.getStock_holding_uid()) {
									remain_stock = buylist.get(i).getStock_holding_uid()
											- salelist.get(j).getStock_holding_uid();
									stock = salelist.get(j).getStock_holding_uid();

									String sqlo = "Delete from stock where id = ? ";
									assert con != null;
									ps = con.prepareStatement(sqlo);
									ps.setInt(1, salelist.get(j).getId());
									int update = ps.executeUpdate();
									if (update > 0) {

										System.out.print("data deleted....from Transactional for seller");
												gg=1;

									} else {
										System.out.print("No data deleted....from Transactional for seller");

									}

									String up_stmt = "Update stock set stock_holding_uid =? where id= "
											+ buylist.get(i).getId() + " AND user_id= "
											+ buylist.get(i).getUser_id();
									ps = con.prepareStatement(up_stmt);
									ps.setInt(1, remain_stock);
									int count = ps.executeUpdate();
									if (count > 0) {
										System.out.print("data updated....from Transactional for Buyer");
										buylist.get(i).setStock_holding_uid(remain_stock);		
										
									} else {
										System.out.print("data updated....from Transactional for Buyer");
									}

								} else {
									remain_stock = salelist.get(j).getStock_holding_uid()
											- buylist.get(i).getStock_holding_uid();
									stock = buylist.get(i).getStock_holding_uid();

									String sqlt = "Delete from stock where id = ? ";

									assert con != null;
									ps = con.prepareStatement(sqlt);
									ps.setInt(1, buylist.get(i).getId());
									int update = ps.executeUpdate();
									if (update > 0) {
										System.out.print("data deleted....from Transactional for buyer");
										gg=2;

									} else {
										System.out.print("No data deleted....from Transactional for buyer");

									}
									String up_stmt = "Update stock set stock_holding_uid =? where id = "
											+ salelist.get(j).getId() + " AND user_id = "
											+ salelist.get(j).getUser_id();
									ps = con.prepareStatement(up_stmt);
									ps.setInt(1, remain_stock);
									int count = ps.executeUpdate();
									if (count > 0) {
										System.out.print("data updated....from Transactional for seller");
										salelist.get(j).setStock_holding_uid(remain_stock);
												
									} else {
										System.out.print("data updated....from Transactional for seller");
									}

								}

								String sqls = "Insert into stock_holdings (seller_id,share_holding_id,price,owner_id) values('"
										+ salelist.get(j).getUser_id() + "','" + stock + "','"
										+ salelist.get(j).getPrice() + "','" + buylist.get(i).getUser_id() + "')";
								int x = st.executeUpdate(sqls);
								if (x > 0) {
									System.out.print("data inserted in stock holding....");
								} else {
									System.out.print("No data inserted in stock holding....");

								}
								System.out.print("Connection closed...");
								
								/* if(gg==1)
								{
									salelist.remove(j);
								}
								else if(gg==2)
								{
									buylist.remove(i);
								} */
												

							} catch (Exception e) {
								System.out.print("Exception occured....");
								e.printStackTrace();
							}

						} else {
							System.out.print("Match is not found");
						}
					}
					System.out.print("Out of first loop...");

				}
				System.out.print("Out of second loop...");

				response.sendRedirect("BuyandSell.jsp");
			} else {
				System.out.print("Data not inserted....");
				response.sendRedirect("BuyandSell.jsp");
			}
			
			st.close();
			con.close();
			
			
		} catch (Exception e) {
			out.println(e);
		}
	%>

</body>
</html>