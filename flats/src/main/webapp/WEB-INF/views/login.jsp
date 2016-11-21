<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logowanie</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Logowanie</p>
	<c:if test="${param.error != null}">
		<div  id="error">
		<font color="red">Błędna nazwa użytkownika lub hasło</font></div>
	</c:if>
	<c:set var="loginUrl">
		<c:url value="/login" />
	</c:set>
	<form method="post" action="${loginUrl}">
		Login: <input type="text" name="email" /></br> Hasło: <input
			type="password" name="password" /> </br> </br> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
			type="submit" value="Zaloguj" />
	</form>
</body>
</html>