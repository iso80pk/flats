<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />
		<div class="container">

			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/realEstate/">
					Nieruchomości do porównania</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Nieruchomość</h2>
				</div>
			</div>

			<div class="row">
				<div class="table-responsive col-md-8 col-md-offset-2">
					<table class="table table-striped">

						<tbody>

							<tr>
								<td>Lokalizacja:</td>
								<td>${realEstate.location}</td>
							</tr>
							<tr>
								<td>Typ nieruchomości:</td>
								<td>${realEstate.realEstateType}</td>
							</tr>
							<tr>
								<td>Powierzchnia [m2]:</td>
								<td>${realEstate.floorArea}</td>
							</tr>
							<tr>
								<td>Cena:</td>
								<td>${realEstate.price}</td>
							</tr>
							<tr>
								<td>ilość pokoi:</td>
								<td>${realEstate.numberOfRooms}</td>
							</tr>
							<tr>
								<td>wiek nieruchomości:</td>
								<td>${realEstate.howOld}</td>
							</tr>
							<tr>
								<td>piętro:</td>
								<td>${realEstate.floor}</td>
							</tr>
							<tr>
								<td>Garaż</td>
								<td><c:if test="${realEstate.garage == true}">Tak</c:if> <c:if
										test="${realEstate.garage == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Parking</td>
								<td><c:if test="${realEstate.parking == true}">Tak</c:if> <c:if
										test="${realEstate.parking == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Ogród</td>
								<td><c:if test="${realEstate.garden == true}">Tak</c:if> <c:if
										test="${realEstate.garden == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Piwnica</td>
								<td><c:if test="${realEstate.cellar == true}">Tak</c:if> <c:if
										test="${realEstate.cellar == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Monitoring</td>
								<td><c:if test="${realEstate.monitoring == true}">Tak</c:if>
									<c:if test="${realEstate.monitoring == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Winda</td>
								<td><c:if test="${realEstate.lift == true}">Tak</c:if> <c:if
										test="${realEstate.lift == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Dostęp do transportu publicznego:</td>
								<td><c:if
										test="${realEstate.accessToPublicTransport == true}">Tak</c:if>
									<c:if test="${realEstate.accessToPublicTransport == false}">Nie</c:if></td>
							</tr>
							<tr>
								<td>Szacowany wkład własny <br /> (remont,
									umeblowanie...):
								</td>
								<td>${realEstate.ownContribution}</td>
							</tr>
							<tr>
								<td>ile kilometrów dziennie <br> musisz dojeżdżać
									prytatnym <br /> środkiem transportu:
								</td>
								<td>${realEstate.kmPerDay}</td>
							</tr>
							<tr>
								<td>miesięczne koszty utrzymania<br /> (czynsz, fundusz
									remontowy,<br /> podatek od nieruchomości,<br /> opłata
									gruntowa.):
								</td>
								<td>${realEstate.maintenanceCosts}</td>
							</tr>
							<tr>
								<td>Średnia cena nieruchomości w okolicy:</td>
								<td>${realEstate.averagePriceInArea}</td>
							</tr>
							<tr>
								<td>Odnośnik do ogłoszenia:</td>
								<td><a target="_blank" href="${realEstate.advertismentsLink}">KLIK</a></td>
							</tr>
							<tr>
								<td>Notatki</td>
								<td>${realEstate.notes}</td>
							</tr>


						</tbody>
					</table>
				</div>
			</div>

			<div class="row my-center">
				<a class="btn btn-primary " href="edit-${realEstate.realEstate_id}"
					role="button">Edytuj</a> <a class="btn btn-danger "
					href="delete-${realEstate.realEstate_id}" role="button">Usuń</a>
			</div>



		</div>

<jsp:include page="../main/footer.jsp" />