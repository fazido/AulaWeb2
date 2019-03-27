<%-- 
    Document   : galeria
    Created on : 14/03/2019, 21:24:39
    Author     : Francisco 1455
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="galeria.jsp"> Inicio</a>
        <%
          String driver = "org.apache.derby.jdbc.ClientDriver";
          String url = "jdbc:derby://localhost:1527/masp";
          String username = "adm";
          String password = "adm";
          
          try {
              Class.forName(driver);
              Connection connection = DriverManager.getConnection(url, username, password);
              Statement statement = connection.createStatement();
              String query = "SELECT * FROM OBRAS";
              ResultSet results = statement.executeQuery(query);
              
              while (results.next()){
                  out.print(results.getString("id") + "\">");
                  out.print(results.getString("nome") + "</a> <br>");
              }
              connection.close();
          } catch(ClassNotFoundException cnfe){
              out.println("Error loading driver: " + cnfe);
          } catch(SQLException sqle) {
              out.println("Error with connection: " + sqle);
          }
            %>
        
    </body>
</html>
