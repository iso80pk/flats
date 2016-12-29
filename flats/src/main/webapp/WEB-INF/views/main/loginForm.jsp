<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">

			<c:if test="${param.error != null}">
				<div id="error">
					<font color="red">Błędna nazwa użytkownika lub hasło</font>
				</div>
			</c:if>
			<c:set var="loginUrl">
				<c:url value="/login" />
			</c:set>

			<form method="post" class="form-horizontal" action="${loginUrl}">
				<div class="form-group">
					<label class="control-label col-sm-4" for="email">Nazwa
						użytkownika</label>
					<div class="col-sm-7">
						<input type="text" name="username" class="form-control" required="required"
							placeholder="Podaj nazwę użytkownika" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="pwd">Hasło</label>
					<div class="col-sm-7">
						<input type="password" name="password" class="form-control" required="required"
							placeholder="Podaj hasło">
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-7">
						<button type="submit" class="btn btn-default">ZALOGUJ</button>
					</div>
				</div>
			</form>

</div>