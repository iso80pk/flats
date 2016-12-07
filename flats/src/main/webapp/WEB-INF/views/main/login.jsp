<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<h2>Logowanie</h2>
			<c:if test="${param.error != null}">
				<div id="error">
					<font color="red">Błędna nazwa użytkownika lub hasło</font>
				</div>
			</c:if>
			<c:set var="loginUrl">
				<c:url value="/login" />
			</c:set>

			<form method="post" class="form-horizontal col-xs-10" action="${loginUrl}">
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Nazwa
						użytkownika</label>
					<div class="col-sm-10">
						<input type="text" name="username" class="form-control"
							placeholder="Podaj nazwę użytkownika" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd">Hasło</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control"
							placeholder="Podaj hasło">
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">ZALOGUJ</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />