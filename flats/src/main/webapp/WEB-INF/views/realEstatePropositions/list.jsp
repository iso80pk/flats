<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />
<div class="container">

	<div class="row col-sm-offset-2">
		<a href="/">Strona główna</a> > <a href="/propositions/">
			Propozycje nieruchomości</a>
	</div>

	<div class="row">
		<div class="text-center">
			<h2>Propozycje nieruchomości</h2>
		</div>
	</div>

	<c:if test="${empty realEstates}">

		<div class="jumbotron">
			<h3>Niestety nie mamy nic więcej do zaproponowania</h3>
		</div>
	</c:if>

	<c:if test="${not empty  realEstates}">

		<div class="row">
			<div class="table-responsive col-md-8 col-md-offset-2">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#ID</th>
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
								<td>${realEstate.realEstate_id}</td>
								<td>${realEstate.location}</td>
								<td>${realEstate.floorArea}</td>
								<td>${realEstate.price}</td>
								<td>${realEstate.numberOfRooms}</td>
								<td><a target="_blank"
									href="${realEstate.advertismentsLink}"> <span
										class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								</a></td>

								<td><a class="btn btn-info"
									href="details-${realEstate.realEstate_id}" role="button">Szczegóły</a></td>
								<td><a class="btn btn-info"
									href="add-${realEstate.realEstate_id}" role="button">Obserwuj</a></td>


								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<td><a class="btn btn-success"
										href="edit-${realEstate.realEstate_id}" role="button">Edytuj</a></td>
									<td><a class="btn btn-danger"
										href="delete-${realEstate.realEstate_id}" role="button">Usuń</a></td>
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