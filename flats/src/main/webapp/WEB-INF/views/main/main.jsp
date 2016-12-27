<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />


<div class="row">
	
		<div class="container">


			Wiatj na stronie
			<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
				<br />
				<a href="registration">rejestracja</a>
			</sec:authorize>
			<br /> <a href="statistics/">satystyczne ceny mieszkań</a><br />

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<br />
				<a href="users/">Edytuj użytkowników</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
				<br />
				<a href="realEstate/">Moje nieruchomości</a>
			</sec:authorize>



		</div>

</div>

<jsp:include page="footer.jsp" />
