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
<title>HTN - Visitings</title>
</head>
<body>
    <sql:setDataSource var="mydb" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/forms" user="root" password="root" />
    <sql:query dataSource="${mydb}" var="listUsers">select * from visitings;</sql:query>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Visit Bookings</h2></caption>
            <tr>
				<th>S.No</th>
				<th>Name</th>
                <th>Phone</th>
                <th>E-mail</th>
                <th>Orphanage</th>
				<th>Date</th>
				<th>Time</th>
				<th>No. of people</th>
			</tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.sno}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.phone}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.orphanage}" /></td>
                    <td><c:out value="${user.date}" /></td>
                    <td><c:out value="${user.time}" /></td>
                    <td><c:out value="${user.num}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>