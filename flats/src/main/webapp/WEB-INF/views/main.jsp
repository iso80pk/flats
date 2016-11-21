<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mieszkania</title>
</head>
<body>
	<center>
		<h1>„Witaj na stronie”</h1>
		</br>
		
		 <a href="registration">rejestracja</a><br/>
		 <a href="statistics/">satystyczne ceny mieszkań</a><br/>
		 <a href="login">zaloguj</a><br />
		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a href="javascript:document.getElementById('logout').submit()">Wyloguj</a>
		</c:if>
	</center>
</body>
</html>