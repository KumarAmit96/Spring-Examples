<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.lang.*" import="java.sql.*" import="java.util.*"
	import="com.stock.pojo.*" import="java.io.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Exchange</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="">
	function btnEdit() {
		var edit = document.getElementById("edit");
		if (edit) {
			document.getElementById("save").style.display = "none";
			document.getElementById("forms").style.display = "block";
			document.getElementById("custId").value = "buy";
		}
	}
	function btnSave() {
		var save = document.getElementById("save");
		if (save) {
			document.getElementById("edit").style.display = "none";
			document.getElementById("forms").style.display = "block";
			document.getElementById("custId").value = "sale";
		}
}

	function dateCheck(form)
	{
		var today = new Date();
		var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
		var mytime="09:00:00";
		var endTime="18:00:00";
		if((time>mytime )  && (time<endTime))
			{
			 return true;
			}
		else{
			alert("Sorry! we are closed. Please try your transaction tomorrow between 9:00 am to 6:00 pm")
			return false;
		}
	}
		
</script>

</head>
<body>
	<span class="psw"> <a href="loginPage.jsp">LOGOUT<%
 	session.removeAttribute("name");
 %></a></span>

	<span class="psw">Hello User,
	</span>
	<%
		System.out.print(" BuyandSell " + session.getAttribute("id") + " " + (String) session.getAttribute("name"));
	%>
	<div class="center">
		<p>Please click to the related button</p>
		<INPUT TYPE="BUTTON" VALUE="BUY" class="cancelbtn" id="edit"
			onclick="btnEdit()"> <INPUT TYPE="BUTTON" VALUE="SELL"
			class="cancelbtn" id="save" onclick="btnSave()">
	</div>
	<div id="forms">
		<form action="DisplayStock.jsp" method="post" onSubmit="return dateCheck(this)"> <!--  -->
			<div class="container">
				<p>Please fill the details.</p>
				<hr>

				<label for="share"><b>Share Name</b></label> <input type="text"
					placeholder="Enter share name" name="share" required> <label
					for="quantity"><b>Number of Share</b></label> <input type="text"
					placeholder="Enter Number of Share" name="quantity" required>
				<label for="price"><b>price of share</b></label> <input type="text"
					placeholder="Enter price of share" name="price" required> <input
					type="hidden" id="custId" name="custId">
				<hr>

				<input type="submit" name="submit" value="Submit"
					class="registerbtn">
			</div>
		</form>
	</div>

	<div>
		<div>		<p>Present Stock</p>
		
		<table border="1"  style="display: inline-block; border: 1px solid; float: left;">
			<tr>
				<td>ID</td>
				<td>TIME</td>
				<td>SHARES</td>
				<td>TYPES</td>
				<td>QUANTITY</td>
				<td>PRICES</td>
			</tr>
			<%
				Connection con = null;
				Statement st = null;
				ResultSet rs;
				ArrayList<StockLIst> salelist = new ArrayList<>();
				ArrayList<StockLIst> buylist = new ArrayList<>();
				String url = "jdbc:mysql://127.0.0.1:3306/";
				String db = "stocks"; // this is the database name 
				String driver = "com.mysql.jdbc.Driver"; //this is the driver name 
				String userName = "root"; //this is mysql user name 
				String password = "honda5112amit"; // this is mysql password 

				try {
					con = DriverManager.getConnection(url + db, userName, password);
					st = con.createStatement();
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
			%>
			<tr>
				<td><%=rs.getString("user_id")%></td>
				<td><%=rs.getString("transaction_time")%></td>
				<td><%=rs.getString("shares")%></td>
				<td><%=rs.getString("Type")%></td>
				<td><%=rs.getString("stock_holding_uid")%></td>
				<td><%=rs.getString("price")%></td>
			</tr>
			<%
				}
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
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
						if ((buyData.equals(saleData)) && (buylist.get(i).getPrice() > salelist.get(j).getPrice())) {
							try {
								con = DriverManager.getConnection(url + db, userName, password);
								st = con.createStatement();
								PreparedStatement ps;
								int remain_stock, stock,gg=0;
								if (buylist.get(i).getStock_holding_uid() > salelist.get(j).getStock_holding_uid()) {
									remain_stock = buylist.get(i).getStock_holding_uid()
											- salelist.get(j).getStock_holding_uid();
									stock = salelist.get(j).getStock_holding_uid();

									String sql = "Delete from stock where id = ? ";
									assert con != null;
									ps = con.prepareStatement(sql);
									ps.setInt(1, salelist.get(j).getId());
									int update = ps.executeUpdate();
									if (update > 0) {
										System.out.print("data deleted....from Transactional for seller");
										gg=1;
									} else {
										System.out.print("No data deleted....from Transactional for seller");

									}

									String up_stmt = "Update stock set stock_holding_uid =? where id= "
											+ buylist.get(i).getId() + " AND user_id= " + buylist.get(i).getUser_id();
									ps = con.prepareStatement(up_stmt);
									ps.setInt(1, remain_stock);
									int count = ps.executeUpdate();
									if (count > 1) {
										System.out.print("data updated....from Transactional for Buyer");
										buylist.get(i).setStock_holding_uid(remain_stock);

									} else {
										System.out.print("data updated....from Transactional for Buyer");
									}

								} else {
									remain_stock = salelist.get(j).getStock_holding_uid()
											- buylist.get(i).getStock_holding_uid();
									stock = buylist.get(i).getStock_holding_uid();

									String sql = "Delete from stock where id = ? ";

									assert con != null;
									ps = con.prepareStatement(sql);
									ps.setInt(1, buylist.get(i).getId());
									int update = ps.executeUpdate();
									if (update > 0) {
										System.out.print("data deleted....from Transactional for buyer");
												gg=2;
									} else {
										System.out.print("No data deleted....from Transactional for buyer");

									}
									String up_stmt = "Update stock set stock_holding_uid =? where id = "
											+ salelist.get(j).getId() + " AND user_id = " + salelist.get(j).getUser_id();
									ps = con.prepareStatement(up_stmt);
									ps.setInt(1, remain_stock);
									int count = ps.executeUpdate();
									if (count > 1) {
										System.out.print("data updated....from Transactional for seller");
										salelist.get(j).setStock_holding_uid(remain_stock);

									} else {
										System.out.print("data updated....from Transactional for seller");
									}

								}

								String sqls = "Insert into stock_holdings (seller_id,share_holding_id,price,owner_id) values('"
										+ salelist.get(j).getUser_id() + "','" + stock + "','" + salelist.get(j).getPrice()
										+ "','" + buylist.get(i).getUser_id() + "')";
								int x = st.executeUpdate(sqls);
								if (x > 0) {
									System.out.print("data inserted in stock holding....");
								} else {
									System.out.print("No data inserted in stock holding....");

								}
								/* if(gg==1)
								{
									salelist.remove(j);
								}
								else if(gg==2)
								{
									buylist.remove(i);
								} */
								st.close();
								con.close();
								System.out.print("Connection closed...");
								/* for (int jj = 0; jj < salelist.size() - 1; jj++) {
									if (salelist.get(jj).getPrice() > salelist.get(jj + 1).getPrice()) {
										temp = salelist.get(jj + 1);
										temp2 = salelist.get(jj);
										int k = salelist.indexOf(temp);
										int l = salelist.indexOf(temp2);
										salelist.remove(k);
										salelist.remove(l);
										salelist.add(l, temp);
										salelist.add(k, temp2);

									}
								}
 */

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
			%>

		</table>
	</div>
	
	<div class=center>		<p> Sold Stock </p>
		<table border="1" style="display: inline-block; border: 1px solid; ">
			<tr>
				<td>SELLER ID</td>
				<td>QTY</td>
				<td>SELL PRICE</td>
				<td>BUYER ID</td>
				
			</tr>
			
			<%
					try {
					con = DriverManager.getConnection(url + db, userName, password);
					st = con.createStatement();
					String sql = "select * from stock_holdings order by id";
					rs = st.executeQuery(sql);
					while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("seller_id")%></td>
				<td><%=rs.getString("share_holding_id")%></td>
				<td><%=rs.getString("price")%></td>
				<td><%=rs.getString("owner_id")%></td>
				
			</tr>
			<%
				}
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				%>

				</table>
				</div>
			
</div>

</body>
</html>