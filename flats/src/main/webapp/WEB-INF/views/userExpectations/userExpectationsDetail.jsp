<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/userExpectations/">Moje
					oczekiwania</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Moje oczekiwania</h2>
				</div>
			</div>


			<c:if test="${empty userExpectations}">

				<div class="jumbotron">
					<h3>Nie uzupełniłeś jeszcze informacji o tym, jakiego mieszkania oczekujesz.</h3>
					<p>Te informacje pomogą w podjęciu decyzji dotyczącej wyboru nieruchomości.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="add" role="button">Przejdź do uzupełnienia ankiety</a>
					</p>
				</div>
			</c:if>





			<c:if test="${not empty userExpectations}">
				<div class="row">
					<div class="table-responsive col-md-8 col-md-offset-2">
						<table class="table table-striped">

							<tbody>

								<tr>
									<td>Lokalizacja:</td>
									<td>${userExpectations.location}</td>
								</tr>
								<tr>
									<td>Typ nieruchomości:</td>
									<td>${userExpectations.realEstateType}</td>
								</tr>
								<tr>
									<td>Powierzchnia [m2]:</td>
									<td>${userExpectations.minFloorArea}-
										${userExpectations.maxFloorArea}</td>
								</tr>
								<tr>
									<td>Cena:</td>
									<td>${userExpectations.minPrice}-
										${userExpectations.maxPrice}</td>
								</tr>
								<tr>
									<td>ilość pokoi:</td>
									<td>${userExpectations.minNumberOfRooms}-
										${userExpectations.maxNumberOfRooms}</td>
								</tr>
								<tr>
									<td>wiek nieruchomości:</td>
									<td>${userExpectations.minHowOld}-
										${userExpectations.maxHowOld}</td>
								</tr>
								<tr>
									<td>piętro:</td>
									<td>${userExpectations.minFloor}-
										${userExpectations.maxFloor}</td>
								</tr>
								<tr>
									<td>Garaż</td>
									<td><c:if test="${userExpectations.garage == true}">Tak</c:if>
										<c:if test="${userExpectations.garage == false}">Nie</c:if></td>
								</tr>
								<tr>
									<td>Parking</td>
									<td><c:if test="${userExpectations.parking == true}">Tak</c:if>
										<c:if test="${userExpectations.parking == false}">Nie</c:if></td>
								</tr>
								<tr>
									<td>Ogród</td>
									<td><c:if test="${userExpectations.garden == true}">Tak</c:if>
										<c:if test="${userExpectations.garden == false}">Nie</c:if></td>
								</tr>
								<tr>
									<td>Piwnica</td>
									<td><c:if test="${userExpectations.cellar == true}">Tak</c:if>
										<c:if test="${userExpectations.cellar == false}">Nie</c:if></td>
								</tr>
								<tr>
									<td>Monitoring</td>
									<td><c:if test="${userExpectations.monitoring == true}">Tak</c:if>
										<c:if test="${userExpectations.monitoring == false}">Nie</c:if></td>
								</tr>
								<tr>
									<td>Winda</td>
									<td><c:if test="${userExpectations.lift == true}">Tak</c:if>
										<c:if test="${userExpectations.lift == false}">Nie</c:if></td>
								</tr>
								<tr>
									<td>Dostęp do transportu publicznego</td>
									<td><c:if
											test="${userExpectations.accessToPublicTransport == true}">Tak</c:if>
										<c:if
											test="${userExpectations.accessToPublicTransport == false}">Nie</c:if></td>
								</tr>


							</tbody>
						</table>
					</div>
					
					
				</div>
				<div class="row my-center"><a class="btn btn-primary btn-lg" href="edit" role="button">Edytuj</a></div>
			</c:if>

		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />