<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.lang.*" import="java.sql.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Exchange</title>
</head>
<body>
<%
Connection con = null;
Statement st=null;
ResultSet rs;
String url = "jdbc:mysql://127.0.0.1:3306/";
String db = "stocks"; // this is the database name 
String driver = "com.mysql.jdbc.Driver"; //this is the driver name 
String userName ="root"; //this is mysql user name 
String password="honda5112amit"; // this is mysql password 
String type=(String)session.getAttribute("page");
if(type!=null && type.equals("login"))
{
	String uname=request.getParameter("uname"); 
	String psw=request.getParameter("psw"); 
	try { 
		Class.forName(driver);
		con = DriverManager.getConnection(url+db,userName,password);
		String sql="select id from users where username='"+uname+"' AND password ='"+psw+"'";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			if(rs.getInt(1)!=0 && rs.getInt(1)!=-1)
			{
			System.out.print(rs.getInt(1)+"  "+uname);
			session.setAttribute("id", rs.getInt(1));
			session.setAttribute("name", uname);
			request.getRequestDispatcher("BuyandSell.jsp").forward(request, response);
			}
			else
			{
				out.println("You are not registered user. Please register first!"); 
			}
		}
		out.println("You are not registered user. Please register first!"); 

			st.close();
			con.close();
			} 
	catch(Exception e) 
	{ out.println("USER DATA "+e); 
	}
}
else if(type!=null && type.equals("registration"))
{
	String email=request.getParameter("email");
	String psw=request.getParameter("psw");
	String pswrepeat=request.getParameter("pswrepeat");
	try { 
		Class.forName(driver);
		con = DriverManager.getConnection(url+db,userName,password);
		st=con.createStatement();
		int i=st.executeUpdate("insert into users(username,password)values('"+email+"','"+psw+"')"); 
		if(i>0)
		{
			String sql="select id from users where username='"+email+"' AND password ='"+psw+"'";//"select id from users";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getInt(1)!=0 && rs.getInt(1)!=-1)
				{
				System.out.print(rs.getInt(1)+"   "+email);
				session.setAttribute("id", rs.getInt(1));
				session.setAttribute("name",email );
				request.getRequestDispatcher("BuyandSell.jsp").forward(request, response);
				}
				else
				{
					out.println("You are not registered user. Please register first!"); 
				}
			}

		}
		else
		{
			response.sendRedirect("Registration.jsp");
		}
		
			st.close();
			con.close();
			} 
	catch(Exception e) 
	{ out.println("USER DATA "+e); 
	}

}
else
{
	out.println("Something went wrong…"); 
}

%>


</body>
</html>