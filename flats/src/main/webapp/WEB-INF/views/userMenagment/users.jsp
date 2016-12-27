<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">

			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/users/"> Użytkowinicy</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Użytkowinicy</h2>
				</div>
			</div>




			<div class="row">
				<div class="table-responsive col-md-8 col-md-offset-2">
					<table class="table table-striped ">
						<thead>
							<tr>

								
								<th>Imię</th>
								<th>Nazwisko</th>
								<th>Nazwa</th>
								<th>Aktywny</th>
								<th>Data rejestracji</th>
								<th colspan="3" class="my-center">Akcja</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.username}</td>
									<td><c:if test="${user.enabled == true}">Tak</c:if> <c:if
											test="${user.enabled == false}">Nie</c:if></td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${user.signUpDate}" />r.</td>
											
									<td><a class="btn btn-info" href="details-${user.id}" role="button">Szczegóły</a></td>
									<td><a class="btn btn-primary"	href="edit-${user.id}" role="button">Edytuj</a></td>
									<td><a class="btn btn-danger " href="delete-${user.id}" role="button">Usuń</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			
		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />