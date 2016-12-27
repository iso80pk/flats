<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/aboutMe/">Profil</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Zmień hasło</h2>
				</div>
			</div>


			<form:form method="POST" modelAttribute="passwordForm"
				class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-4">Podaj stare hasło:</label>
					<div class="col-sm-6">
						<form:input type="password" path="oldPassword" name="oldPassword"
							class="form-control" placeholder="Tutaj wpisz obecne hasło" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="oldPassword" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Podaj nowe hasło:</label>
					<div class="col-sm-6">
						<form:input type="password" path="newPassword" name="newPassword"
							class="form-control" placeholder="Podaj nowe hasło" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="newPassword" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Powtórz nowe hasło:</label>
					<div class="col-sm-6">
						<form:input type="password" path="repetedNewPassword"
							name="repetedNewPassword" class="form-control"
							placeholder="Powtórz nowe hasło" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="repetedNewPassword" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						<button type="submit" class="btn btn-default">Zmień</button>
					</div>
				</div>
			</form:form>

		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />