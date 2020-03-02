<%@ page import="java.sql.*"%>
<html>

<h2>Search Employee!!!</h2>

<head>
<title>Search</title>
<%@page import="java.sql.*"%>
</head>
<body>
	<%
    Connection con;
    Statement st;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
         con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","anirudha");
        st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from user;");
    %>
    
    
	<br><br><br>
	
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>USERNAME</th>
				<th>AGE</th>
				<th>COUNTRY</th>
				<th>EMAIL</th>
			</tr>
		</thead>
		<tbody>
			<%while(rs.next())
        {
            %>
			<tr>
				<td><%=rs.getInt("id") %></td>
				<td><%=rs.getString("username") %></td>
				<td><%=rs.getString("age") %></td>
				<td><%=rs.getString("country") %></td>
				<td><%=rs.getString("email") %></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<br>
	<%}
    catch(Exception e){
        out.print(e.getMessage());%><br>
	<%
    }
  
    %>
</body>
</html>



<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>



</html>