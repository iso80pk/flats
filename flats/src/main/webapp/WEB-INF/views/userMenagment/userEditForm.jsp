<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../main/header.jsp" />

		<div class="container">
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/users/"> Użytkowinicy</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Użytkowinik</h2>
				</div>
			</div>


			<form:form method="POST" modelAttribute="form" class="form-horizontal">
				
				
				<div class="form-group">
					<label class="control-label col-sm-4">Imię:</label>
					<div class="col-sm-6">
						<form:input type="text" path="firstName" name="firstName"
							class="form-control" placeholder="Imię" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="firstName" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Nazwisko:</label>
					<div class="col-sm-6">
						<form:input type="text" path="lastName" name="lastName"
							class="form-control" placeholder="Nazwisko" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="lastName" class="my-form-error" /></c:if>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Login:</label>
					<div class="col-sm-6">
						<form:input type="text" path="username" name="username"
							class="form-control" placeholder="Nazwa użytkownika" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="username" class="my-form-error" /></c:if>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Aktywny:</label>
					<div class="col-sm-6">
						<form:checkbox path="enabled" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">E-mail:</label>
					<div class="col-sm-6">
						<form:input type="email" path="email" name="email"
						class="form-control" placeholder="E-mail" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="email" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Telefon:</label>
					<div class="col-sm-6">
						<form:input type="text" path="phoneNumber" name="phoneNumber" maxlength="13" pattern="((00|\+)(\d\d))?\d{9}"
						class="form-control" placeholder="Telefon" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="phoneNumber" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						<button type="submit" class="btn btn-default">Zmień</button>
					</div>
				</div>
				
			</form:form>

		</div>

<jsp:include page="../main/footer.jsp" />