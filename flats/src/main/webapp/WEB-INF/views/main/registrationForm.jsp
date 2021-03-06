<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />
<div class="container">
	<p style="width: 100%; text-align: center;">Rejestracja</p>
	
	<c:if test="${pageContext.request.method=='POST'}">
	<div class="row alert alert-danger col-sm-offset-1 col-sm-10"> 
		<c:if test="${email == true}">Użytkownik o podanym  <strong>adresie e-mail</strong> już istnieje<br></c:if>
		<c:if test="${username == true}">Podana <strong>nazwa użytkownika</strong> jest już zajęta</c:if><br>
		Proszę, popraw błędy.
	</div>
	</c:if>


	<form:form method="POST" class="form-horizontal" modelAttribute="form">
		<div class="row">


			<div class="form-group">
				<label class="control-label col-sm-4">Imię *</label>
				<div class="col-sm-7">
					<form:input type="text" path="firstName" name="firstName"
						maxlength="40" required="required" class="form-control"
						placeholder="Podaj imię" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="firstName" class="my-form-error" />
					</c:if>
					<div class="firstNameError my-form-error"></div>
				</div>

			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">Nazwisko</label>
				<div class="col-sm-7">
					<form:input type="text" path="lastName" name="lastName"
						maxlength="40" class="form-control" placeholder="Podaj nazwisko" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="lastName" class="my-form-error" />
					</c:if>
					<div class="lastNameError my-form-error"></div>
				</div>

			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">Login *</label>
				<div class="col-sm-7">
					<form:input type="text" path="username" name="username"
						maxlength="35" required="required" pattern=".{4,}"
						class="form-control" placeholder="Podaj login" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="username" class="my-form-error" />
					</c:if>

					<div class="usernameError my-form-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">Hasło *</label>
				<div class="col-sm-7">
					<form:input type="password" path="password" name="password"
						id="password" maxlength="35" required="required" pattern=".{4,}"
						class="form-control" placeholder="Podaj hasło" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="password" class="my-form-error" />
					</c:if>

					<div class="passwordError my-form-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">Powtórz hasło *</label>
				<div class="col-sm-7">
					<form:input type="password" path="repeatPassword"
						id="repeatPassword" name="repeatPassword" maxlength="35"
						required="required" pattern=".{4,}" class="form-control"
						placeholder="Powtórz hasło" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="repeatPassword" class="my-form-error" />
					</c:if>

					<div class="repeatPasswordError my-form-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">E-mail *</label>
				<div class="col-sm-7">
					<form:input type="email" path="email" name="email" id="email"
						required="required" class="form-control"
						placeholder="Podaj adres e-mail" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="email" class="my-form-error" />
					</c:if>
					<div class="emailError my-form-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">Powtórz e-mail*</label>
				<div class="col-sm-7">
					<form:input type="email" path="repeatEmail" name="repeatEmail"
						id="repeatEmail" required="required" class="form-control"
						placeholder="Powtórz adres e-mail" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="repeatEmail" class="my-form-error" />
					</c:if>
					<div class="repeatEmailError my-form-error"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4">Telefon</label>
				<div class="col-sm-7">
					<form:input type="text" path="phoneNumber" name="phoneNumber"
						maxlength="13" pattern="((00|\+)(\d\d))?\d{9}"
						class="form-control" placeholder="Podaj numer telefonu" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="phoneNumber" class="my-form-error" />
					</c:if>
					<div class="phoneNumberError my-form-error"></div>
				</div>
			</div>

		</div>
		<button class="hidden" id="submit" type="submit" name="submit"></button>


	</form:form>
	<div class="row my-center">
		<div class="col-sm-offset-4 col-sm-7">
			<button type="submit" class="btn btn-default" onclick="test()">Zarejestruj</button>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="myError" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Błędy w formularzu</h4>
      </div>
      <div class="modal-body">
      <div id="modal-email"></div>
      <div id="modal-password"></div>
      <div> Proszę, popraw błędy</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
      </div>
    </div>

  </div>
</div>

<script>
	$('form').each(function() {
		this.addEventListener('invalid', function(event) {
			event.preventDefault();
		}, true);
	});

	function test() {
		var noError = true;
		var emailOrPassword =true;
		$('form input').each(function() {
			var id = 'div.' + this.name + 'Error';
			if (this.checkValidity() == false) {
				$(id).empty();
				$(id).append(this.validationMessage);
				noError = false;
			} 		

		});
		
		$('#modal-email').empty();
		$('#modal-password').empty();
		
		if (($('#email').val() != $('#repeatEmail').val())) {
			$('#modal-email').append("Wartości pól, które powinny zawierać Tój adres e-mail są różne");

			emailOrPassword = false;

		} 
		
		if (($('#password').val() != $('#repeatPassword').val())) {
			emailOrPassword = false;
			$('#modal-password').append("Wartości pól, które powinny zawierać Twoje hasło są różne");

		}
		
		if(!emailOrPassword){
			$('#myError').modal('show'); 
		}

		if (noError && emailOrPassword)	$('#submit').click();
	};
</script>
<jsp:include page="../main/footer.jsp" />