<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<p style="width: 100%; text-align: center;">Rejestracja</p>

			<c:if test="${pageContext.request.method=='POST'}">

				<font color="red">Login oraz hasło powinny zaierać od 4 do 35
					znaków.<br /> Żadne z pól nie może pozostać puste
				</font>
			</c:if>
			
			
			<form:form method="POST" class="form-horizontal col-xs-10"	modelAttribute="form">

				<div class="form-group">
					<label class="control-label col-sm-2">Imię:</label>
					<div class="col-sm-10">
						<form:input type="text" path="firstName" name="firstName"
							class="form-control" placeholder="Podaj imię" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Nazwisko:</label>
					<div class="col-sm-10">
						<form:input type="text" path="lastName" name="lastName"
							class="form-control" placeholder="Podaj nazwisko" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Login:</label>
					<div class="col-sm-10">
						<form:input type="text" path="username" name="username"
							class="form-control" placeholder="Podaj login" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Hasło:</label>
					<div class="col-sm-10">
						<form:input type="password" path="password" name="password"
							class="form-control" placeholder="Podaj hasło" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Powtórz hasło:</label>
					<div class="col-sm-10">
						<form:input type="password" path="repeatPassword" name="repeatPassword"
						 class="form-control"  placeholder="Powtórz hasło" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">E-mail:</label>
					<div class="col-sm-10">
						<form:input type="text" path="email" name="email"
							class="form-control" placeholder="Podaj adres e-mail" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Powtórz e-mail:</label>
					<div class="col-sm-10">
						<form:input type="text" path="repeatEmail" name="repeatEmail"
							class="form-control" placeholder="Powtórz adres e-mail" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Telefon:</label>
					<div class="col-sm-10">
						<form:input type="text" path="phoneNumber" name="phoneNumber"
							class="form-control" placeholder="Podaj numer telefonu" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Zarejestruj</button>
					</div>
				</div>

			</form:form>

		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />