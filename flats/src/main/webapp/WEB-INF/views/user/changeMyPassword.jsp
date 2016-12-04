<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edytuj</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Zmień hasło</p>
	
	
	<form:form method="POST" modelAttribute="passwordForm">
		<table style="text-align: right;">
			<tbody>
				<tr>
					<td>Podaj stare hasło:</td>
					<td><form:input type="password" path="oldPassword" name="oldPassword"  /></td>
				</tr>
				<tr>
					<td>Podaj nowe hasło:</td>
					<td><form:input type="password" path="newPassword" name="newPassword"  /></td>
				</tr>
				<tr>
					<td>Powtórz nowe hasło:</td>
					<td><form:input type="password" path="repetedNewPassword" name="repetedNewPassword"  /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Zatwierdź" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>