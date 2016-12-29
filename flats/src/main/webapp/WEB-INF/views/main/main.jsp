<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />


<div class="row">

	<div class="container">


		<div class="row">
			<div class="text-center">
				<h2>Witaj na stronie</h2>
			</div>
		</div>


		<sec:authorize access="hasRole('ROLE_ANONYMOUS')">

			<div class="jumbotron">
				<div class="row my-center">
					<h3>Aby korzystać z zawartości konieczna jest rejestracja</h3>
					<br>
				</div>
				<div class="row">
					<div class=" my-center">
						<a class="btn btn-primary btn-lg" href="registration"
							role="button">Przejdź do rejestracji</a>
					</div>
					<br>
					<div>
						<h3 class=" my-center">Lub zaloguj się</h3>
						<jsp:include page="loginForm.jsp" />
					</div>
				</div>




			</div>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_USER')">
			<div class="jumbotron">
				<h3>W przyszłości tu coś się pojawi</h3>
				<br>

			</div>

		</sec:authorize>



	</div>

</div>

<jsp:include page="footer.jsp" />
