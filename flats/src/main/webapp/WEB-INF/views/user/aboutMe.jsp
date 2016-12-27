<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
		
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/aboutMe/">Profil</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>O mnie</h2>
				</div>
			</div>
		
			<div class="row">
				<div class="table-responsive col-md-8 col-md-offset-2">
					<table class="table table-striped">
						<tbody>

					<tr>
						<td>Imię</td>
						<td>${user.firstName}</td>
					</tr>
					<tr>
						<td>Nazwisko</td>
						<td>${user.lastName}</td>
					</tr>
					<tr>
						<td>Nazwa użytkownika</td>
						<td>${user.username}</td>
					</tr>
					<tr>
						<td>Aktywny</td>
						<td><c:if test="${user.enabled == true}">Tak</c:if> <c:if
								test="${user.enabled == false}">Nie</c:if></td>
					</tr>
					<tr>
						<td>e-mail</td>
						<td>${user.email}</td>
					</tr>
					<tr>
						<td>numer telefonu</td>
						<td>${user.phoneNumber}</td>
					</tr>
					<tr>
						<td>Data rejestracji</td>
						<td><fmt:formatDate pattern="dd.MM.yyyy"
								value="${user.signUpDate}" />r.</td>
					</tr>
				</tbody>
			
			</table>
			
			</div>
			</div>

			<div class="row my-center">
				<a class="btn btn-primary " href="edit" role="button"><span class="glyphicon glyphicon-pencil"></span> Edytuj dane</a>
				<a class="btn btn-danger " href="password" role="button"><span class="glyphicon glyphicon-refresh"></span> Zmień hasło</a>
			</div>
			
		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />