<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nieruchomości</title>

<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css" type="text/css" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="../">Nieruchomości</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">

						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Admin<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="../users/">Użytkownicy</a></li>
								</ul></li>
						</sec:authorize>

						<sec:authorize access="hasRole('ROLE_USER')">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Nieruchomości<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/realEstate/">Dostępne oferty</a></li>
									<li><a href="/realEstate/notAssignedToMe">Propozycje</a></li>
									<li><a href="/ranking/">Ranking</a></li>
								</ul></li>

							<li><a href="/userExpectations/">Moje oczekiwania</a></li>
						</sec:authorize>
						<li><a href="#">O projekcie</a></li>

					</ul>
					<ul class="nav navbar-nav navbar-right">

						<!-- GUEST -->
						<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
							<li><a href="../registration"><span
									class="glyphicon glyphicon-user"></span> Zarejestruj się</a></li>
							<li><a href="../login"><span
									class="glyphicon glyphicon-log-in"></span> Zaloguj</a></li>
						</sec:authorize>

						<!-- USER/ ADMIN -->

						<c:if test="${pageContext.request.userPrincipal.name != null}">
							<c:url value="/logout" var="logoutUrl" />
							<form id="logout" action="${logoutUrl}" method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>


							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"> <span
									class="glyphicon glyphicon-user"></span>PROFIL
							</a>
								<ul class="dropdown-menu">
									<li><a href="/aboutMe/">O mnie</a></li>
									<li><a href="/aboutMe/mySituation">Informacje
											podstawowe</a></li>
								</ul></li>
							<li><a
								href="javascript:document.getElementById('logout').submit()"><span
									class="glyphicon glyphicon-off"></span> WYLOGUJ</a></li>
						</c:if>


					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main>