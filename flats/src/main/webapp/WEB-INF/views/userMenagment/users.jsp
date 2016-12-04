<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Użytkownicy</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Użutkownicy</p>
	<table border=1 align="center">
		<thead>
			<tr>

				<td>ID</td>
				<td>Imię</td>
				<td>Nazwisko</td>
				<td>Nazwa użytkownika</td>
				<td>Aktywny</td>
				<td>Data rejestracji</td>
				<td>Szczegóły</td>
				<td>Edytuj</td>
				<td>Usuń</td>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.username}</td>
					<td><c:if test="${user.enabled == true}">Tak</c:if> 
						<c:if test="${user.enabled == false}">Nie</c:if></td>
					<td><fmt:formatDate pattern="dd.MM.yyyy"   value="${user.signUpDate}" />r.</td>
					<td><a href="details-${user.id}">Szczegóły</a></td>
					<td><a href="edit-${user.id}">Edytuj</a></td>
					<td><a href="delete-${user.id}">Usuń</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br/>
	<center>
		<a href="../">Strona główna</a><br/>
	</center>


</body>
</html>