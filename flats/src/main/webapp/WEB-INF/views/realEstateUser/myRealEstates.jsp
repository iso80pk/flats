<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					<h2>Nieruchomości do porównania</h2>
				</div>
			</div>

			<c:if test="${empty realEstates}">

				<div class="jumbotron">
					<h3>Nie masz jeszcze żadnej nieruchomości do porównania</h3>
					<p>Po dodaniu nieruchomości będzie można wyłonić tę najlepszą do
						zakupu</p>
					<p>
						<a class="btn btn-primary btn-lg" href="add" role="button">Dodaj
							pierwszą nieruchomość</a>
					</p>
				</div>
			</c:if>

			<c:if test="${not empty  realEstates}">
				<div class=" col-md-offset-2">
					<a class="btn btn-success" href="add" role="button">Dodaj nową
						nieruchomość</a>
				</div>


				<div class="row">
					<div class="table-responsive col-md-8 col-md-offset-2">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Lokalizacja</th>
									<th>Powierzchnia [m2]</th>
									<th>Cena</th>
									<th>Ilość pokoi</th>
									<th>Link</th>
									<th colspan="3" class="my-center">Akcja</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="realEstate" items="${realEstates}">
									<tr>

										<td>${realEstate.location}</td>
										<td>${realEstate.floorArea}</td>
										<td>${realEstate.price}</td>
										<td>${realEstate.numberOfRooms}</td>
										<td><a target="_blank"
											href="${realEstate.advertismentsLink}"> <span
												class="glyphicon glyphicon-globe" aria-hidden="true"></span>
										</a></td>

										<td><a class="btn btn-info" href="details-${realEstate.realEstate_id}" role="button">Szczegóły</a></td>
										<td><a class="btn btn-primary"	href="edit-${realEstate.realEstate_id}" role="button">Edytuj</a></td>
										<td><a class="btn btn-danger " href="delete-${realEstate.realEstate_id}" role="button">Usuń</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>




			</c:if>

		</div>

<jsp:include page="../main/footer.jsp" />