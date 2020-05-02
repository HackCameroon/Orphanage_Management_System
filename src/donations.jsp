<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTN - Donations</title>
</head>
<body>
    <sql:setDataSource var="mydb" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/forms" user="root" password="root" />
    <sql:query dataSource="${mydb}" var="listUsers">select * from donations;</sql:query>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Donations made:</h2></caption>
            <tr>
				<th>S.No</th>
				<th>Name of donator</th>
                <th>Orphanage name</th>
                <th>Purpose</th>
                <th>Transaction ID</th>
				<th>Amount</th>
			</tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.sno}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.orphanage}" /></td>
                    <td><c:out value="${user.purpose}" /></td>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.amt}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>