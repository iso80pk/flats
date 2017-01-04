<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />

		<div class="container">
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/users/"> Użytkowinicy</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Użytkowinik ${user.username}</h2>
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
							<tr>
								<td colspan=2 align="center">Uprawnienia</td>

							</tr>
							<tr>
								<c:if test="${isAdmin == null}">
									<td>Admin</td>
									<td><a href=addRole-${user.id}-ROLE_ADMIN>Dodaj</a></td>
								</c:if>
								<c:if test="${isAdmin != null}">
									<td>Admin</td>
									<td>${isAdmin.role}<a
										href="deleteRole-${isAdmin.id}-${user.id}"> X</a></td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${isUser == null}">
									<td>User</td>
									<td><a href=addRole-${user.id}-ROLE_USER>Dodaj </a></td>
								</c:if>
								<c:if test="${isUser != null}">
									<td>User</td>
									<td>${isUser.role}<a
										href="deleteRole-${isUser.id}-${user.id}"> X</a></td>
								</c:if>
							</tr>
							
						</tbody>
					</table>
				</div>

			</div>
			<div class="row my-center">
				<a class="btn btn-primary " href="edit-${user.id}" role="button">Edytuj</a>
				<a class="btn btn-danger " href="delete-${user.id}" role="button">Usuń</a>
			</div>
			
		</div>

<jsp:include page="../main/footer.jsp" />