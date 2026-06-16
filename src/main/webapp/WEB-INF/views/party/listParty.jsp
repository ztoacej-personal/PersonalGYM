<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
	<table>
		<c:forEach var="party" items="${listParty}" varStatus="status">
			<tr>
				<td>${party.id}</td>
				<td>${party.name}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
