<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>mieszkania</title>

<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	
		<h1>„Witaj na stronie”</h1>
		<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
		<br/> <a href="registration">rejestracja</a>
		</sec:authorize>
		<br /> <a href="statistics/">satystyczne
			ceny mieszkań</a><br />
			
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<br/> <a href="users/">Edytuj użytkowników</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
		<br/> <a href="realEstate/">Moje nieruchomości</a>
		</sec:authorize>
	
	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>