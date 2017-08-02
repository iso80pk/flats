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

	<c:if test="${empty realEstateUser}">

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

	<c:if test="${not empty  realEstateUser}">
		<div class=" col-md-offset-2">
			<a class="btn btn-success" href="add" role="button">RANKING -
				UZUPEØNI¢</a>
		</div>


		<div class="row">
			<div class="table-responsive col-md-8 col-md-offset-2">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>[%]</th>
							<th>Lokalizacja</th>
							<th>Powierzchnia [m2]</th>
							<th>Cena</th>
							<th>Ilość pokoi</th>
							<th>Link</th>
							<th colspan="3" class="my-center">Akcja</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="RE_U" items="${realEstateUser}">
							<tr>
								<td>${RE_U.rankedPosition}</td>
									<td>${RE_U.adaptation}</td>
								<td>${RE_U.realEstate.location}</td>
								<td>${RE_U.realEstate.floorArea}</td>
								<td>${RE_U.realEstate.price}</td>
								<td>${RE_U.realEstate.numberOfRooms}</td>
								<td><a target="_blank"
									href="${RE_U.realEstate.advertismentsLink}"> <span
										class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								</a></td>

								<td><a class="btn btn-info"
									href="details-${RE_U.realEstate.realEstate_id}" role="button">Szczegóły</a></td>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<td><a class="btn btn-success"
										href="edit-${RE_U.realEstate.realEstate_id}" role="button">Edytuj</a></td>
									<td><a class="btn btn-danger"
										href="delete-${RE_U.realEstate.realEstate_id}" role="button">Usuń</a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>




	</c:if>

</div>

<jsp:include page="../main/footer.jsp" />