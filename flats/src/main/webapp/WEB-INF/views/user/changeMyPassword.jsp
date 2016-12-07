<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<p style="width: 100%; text-align: center;">Zmień hasło</p>


			<form:form method="POST" modelAttribute="passwordForm"
				class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-4">Podaj stare hasło:</label>
					<div class="col-sm-6">
						<form:input type="password" path="oldPassword" name="oldPassword"
							class="form-control" placeholder="Tutaj wpisz obecne hasło" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Podaj nowe hasło:</label>
					<div class="col-sm-6">
						<form:input type="password" path="newPassword" name="newPassword"
							class="form-control" placeholder="Podaj nowe hasło" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Powtórz nowe hasło:</label>
					<div class="col-sm-6">
						<form:input type="password" path="repetedNewPassword"
							name="repetedNewPassword" class="form-control"
							placeholder="Powtórz nowe hasło" />
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