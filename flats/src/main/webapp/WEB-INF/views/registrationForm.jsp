<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Rejestracja</p>
	
	<c:if test="${pageContext.request.method=='POST'}">
		
		<font color="red">Login oraz hasło powinny zaierać od 4 do 35 znaków.</br> Żadne z pól nie może pozostać puste</font></div>
	</c:if>
	<form:form method="POST" modelAttribute="form">
		<table style="text-align: right;">
			<tbody>
				<tr>
					<td>Login:</td>
					<td><form:input type="text" path="username" name="username" /></td>
					
 					
				</tr>
				<tr>
					<td>Hasło:</td>
					<td><form:input type="password" path="password" name="password" /></td>
						
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Dodaj" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>