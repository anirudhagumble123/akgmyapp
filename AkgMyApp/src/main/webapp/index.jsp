<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
<head>
	<title>Search user</title>
</head>
<body>
<%
	String keyword = "";
	if(request.getParameter("txtKeyword") != null) {
		keyword = request.getParameter("txtKeyword");
	}
%>

	<form name="frmSearch" method="get" action="index.jsp">
	  <table width="599" border="1">
	    <tr>
	      <th>Keyword
	      <input name="txtKeyword" type="text" id="txtKeyword" value="<%=keyword%>">
	      <input type="submit" value="Search"></th>
	    </tr>
	  </table>
	</form>

	<%
	Connection connect = null;
	Statement s = null;
	
	try {
		Class.forusername("com.mysql.jdbc.Driver");
		
		connect =  DriverManager.getConnection("jdbc:mysql://localhost/mydatabase" +
				"?user=root&password=anirudha");
		
		s = connect.createStatement();
		
		String sql = "SELECT * FROM  user WHERE username like '%" +  keyword + "%' " +
		" ORDER BY id ASC";
		
		System.out.println(sql);
		
		ResultSet rec = s.executeQuery(sql);
		%>
		<table width="600" border="1">
		  <tr>
		    <th width="91"> <div align="center">CustomerID </div></th>
		    <th width="98"> <div align="center">username </div></th>
		    <th width="198"> <div align="center">Email </div></th>
		    <th width="97"> <div align="center">CountryCode </div></th>
		    <th width="59"> <div align="center">Budget </div></th>
		    <th width="71"> <div align="center">Used </div></th>
		  </tr>	
			<%while((rec!=null) && (rec.next())) { %>
				  <tr>
				    <td><div align="center"><%=rec.getString("CustomerID")%></div></td>
				    <td><%=rec.getString("username")%></td>
				    <td><%=rec.getString("Email")%></td>
				    <td><div align="center"><%=rec.getString("CountryCode")%></div></td>
				    <td align="right"><%=rec.getFloat("Budget")%></td>
				    <td align="right"><%=rec.getFloat("Used")%></td>
				  </tr>
	       	<%}%>
	  	</table>      
	    <%	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	
		try {
			if(s!=null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
</body>
</html>