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
	<p style="width: 100%; text-align: center;">O mnie</p>
	<table border=1 align="center">
	
		<tbody>
			
				<tr>
					<td>Imię</td><td>${user.firstName}</td>
				</tr><tr>
					<td>Nazwisko</td><td>${user.lastName}</td>
				</tr><tr>
					<td>Nazwa użytkownika</td><td>${user.username}</td>
				</tr><tr>
					<td>Aktywny</td><td><c:if test="${user.enabled == true}">Tak</c:if> 
						<c:if test="${user.enabled == false}">Nie</c:if></td>
				</tr><tr>
					<td>e-mail</td><td>${user.email}</td>
				</tr><tr>
					<td>numer telefonu</td><td>${user.phoneNumber}</td>
				</tr><tr>
					<td>Data rejestracji</td><td><fmt:formatDate pattern="dd.MM.yyyy"   value="${user.signUpDate}" />r.</td>
				</tr>
					
				
				
				<tr>
					<td><a href="edit">Edutuj Dane</a></td><td><a href="password">Zmień hasło</a></td>
				</tr>
			
		</tbody>
	</table>
	
	
	<br/>
	<center>
		<a href="../">Strona główna</a><br/>
	</center>


</body>
</html>