<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<p style="width: 100%; text-align: center;">Edytuj</p>


			<form:form method="POST" modelAttribute="form" class="form-horizontal">
				
				
				<div class="form-group">
					<label class="control-label col-sm-4">Imię:</label>
					<div class="col-sm-6">
						<form:input type="text" path="firstName" name="firstName"
							class="form-control" placeholder="Imię" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Nazwisko:</label>
					<div class="col-sm-6">
						<form:input type="text" path="lastName" name="lastName"
							class="form-control" placeholder="Nazwisko" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Login:</label>
					<div class="col-sm-6">
						<form:input type="text" path="username" name="username"
							class="form-control" placeholder="Nazwa użytkownika" />
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
						<form:input type="text" path="email" name="email"
						class="form-control" placeholder="E-mail" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Telefon:</label>
					<div class="col-sm-6">
						<form:input type="text" path="phoneNumber" name="phoneNumber"
						class="form-control" placeholder="Telefon" />
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