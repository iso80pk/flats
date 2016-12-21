<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">

			<p style="width: 100%; text-align: center;">Moje nieruchomości</p>
			<br />
			<p style="text-align: center">
				<a href="add">dodaj nową nieruchomość</a>
			</p>
			<div class="row">
			<div class="table-responsive col-md-8 col-md-offset-2">
				<table class="table table-striped">
					<thead>
						<tr>

							<td>Lokalizacja</td>
							<td>Powierzchnia [m2]</td>
							<td>Cena</td>
							<td>Ilość pokoi</td>
							<td>Link</td>
							<td>Szczegóły</td>
							<td>Edytuj</td>
							<td>Usuń</td>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="realEstate" items="${realEstates}">
							<tr>

								<td>${realEstate.location}</td>
								<td>${realEstate.floorArea}</td>
								<td>${realEstate.price}</td>
								<td>${realEstate.numberOfRooms}</td>
								<td><a target="_blank" href="${realEstate.advertismentsLink}">KLIK</a></td>

								<td><a href="details-${realEstate.id}">Szczegóły</a></td>
								<td><a href="edit-${realEstate.id}">Edytuj</a></td>
								<td><a href="delete-${realEstate.id}">Usuń</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>

			<br /> <a href="../">Strona główna</a><br />




		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />