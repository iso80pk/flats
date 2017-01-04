<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />

		<div class="container">
		
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/aboutMe/mySituation">Informacje podstawowe</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Informacje podstawowe</h2>
				</div>
			</div>
			
			<c:if test="${empty userSituation}">

				<div class="jumbotron">
					<h3>Nie uzupełniłeś jeszcze informacji o tym, jakiego
						mieszkania oczekujesz.</h3>
					<p>Te informacje pomogą w podjęciu decyzji dotyczącej wyboru
						nieruchomości.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="addMySituation" role="button">Przejdź
							do uzupełnienia podstawowych informacji</a>
					</p>
				</div>
			</c:if>
			
			<c:if test="${not empty userSituation}">
		
			<div class="row">
				<div class="table-responsive col-md-8 col-md-offset-2">
					<table class="table table-striped">
						<tbody>

					<tr>
						<td>Kolejna przeprowadzka</td>
						<td>za ${userSituation.nextRemoval}lat</td>
					</tr>
					<tr>
						<td>Ilość członków rodziny</td>
						<td>${userSituation.numberOfFamilyMembers}</td>
					</tr>
					<tr>
						<td>Koszty przejazdu prywatnym samochodem</td>
						<td>${userSituation.costOfPersonalCarUsage}zł. za 100km.</td>
					</tr>
					
				</tbody>
			
			</table>
			
			</div>
			</div>

			<div class="row my-center">
				<a class="btn btn-primary " href="editMySituation" role="button"><span class="glyphicon glyphicon-pencil"></span> Edytuj dane</a>
							</div>
			</c:if>
		</div>

<jsp:include page="../main/footer.jsp" />