<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../main/header.jsp" />

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
					<h3>Nie uzupełniłeś jeszcze informacji o tym, jakiego
						mieszkania oczekujesz.</h3>
					<p>Te informacje pomogą w podjęciu decyzji dotyczącej wyboru
						nieruchomości.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="add" role="button">Przejdź
							do uzupełnienia ankiety</a>
					</p>
				</div>
			</c:if>
			
			<c:if test="${(not empty userExpectations) and (empty importanceOfExpectations)}">

				<div class="jumbotron">
					<h3>Nie donkończono uzupełniania formularza</h3>
					<p>Nie dokonałeś jeszcze oceny istotności poszczególnych informacji.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="addImportanceOfExpectations" role="button">Dokończ uzupełnianie formularza</a>
					</p>
				</div>
			</c:if>
			





			<c:if test="${(not empty userExpectations) and (not empty importanceOfExpectations) }">
				<div class="row">
					<div class="table-responsive col-md-8 col-md-offset-2">
						<table class="table table-striped">

							<thead>
								<tr>
									<th></th>
									<th>Oczekiwania</th>
									<th>Ważność</th>
									<th>Grupa <a class="btn btn-primary"
						href="splitDefaultGroups" data-toggle="tooltip"
						data-placement="bottom"
						title="Podziel na grupy używając domyślnych przedziałów">
							<span class="glyphicon glyphicon-flash"></span>
					</a></th>

								</tr>
							</thead>

							<tbody>

								<tr>
									<td>Lokalizacja:</td>
									<td>${userExpectations.location}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.location}">  
									 <span class="glyphicon glyphicon-star" style="color:#1a75ff"></span>
									 </c:forEach>
									 
									 <c:forEach var="i" begin="${importanceOfExpectations.location+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									
									${importanceOfExpectations.location}/10</td>
									<td class=" my-center">${importanceOfExpectations.location_priority}</td>
								</tr>
								<tr>
									<td>Typ nieruchomości:</td>
									<td>${userExpectations.realEstateType}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.realEstateType}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.realEstateType+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									${importanceOfExpectations.realEstateType}/10</td>
									<td class=" my-center">${importanceOfExpectations.realEstateType_priority}</td>
								</tr>
								<tr>
									<td>Powierzchnia [m2]:</td>
									<td>${userExpectations.minFloorArea}-
										${userExpectations.maxFloorArea}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.floorArea}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.floorArea+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.floorArea}/10</td>
									 <td class=" my-center">${importanceOfExpectations.floorArea_priority}</td>
								</tr>
								<tr>
									<td>Cena:</td>
									<td>${userExpectations.minPrice}-
										${userExpectations.maxPrice}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.price}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.price+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.price}/10</td>
									 <td class=" my-center">${importanceOfExpectations.price_priority}</td>
								</tr>
								<tr>
									<td>ilość pokoi:</td>
									<td>${userExpectations.minNumberOfRooms}-
										${userExpectations.maxNumberOfRooms}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.numberOfRooms}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.numberOfRooms+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.numberOfRooms}/10</td>
									 <td class=" my-center">${importanceOfExpectations.numberOfRooms_priority}</td>
								</tr>
								<tr>
									<td>wiek nieruchomości:</td>
									<td>${userExpectations.minHowOld}-
										${userExpectations.maxHowOld}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.howOld}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.howOld+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.howOld}/10</td>
									 <td class=" my-center">${importanceOfExpectations.howOld_priority}</td>
								</tr>
								<tr>
									<td>piętro:</td>
									<td>${userExpectations.minFloor}-
										${userExpectations.maxFloor}</td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.floor}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.floor+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.floor}/10</td>
									 <td class=" my-center">${importanceOfExpectations.floor_priority}</td>
								</tr>
								<tr>
									<td>Garaż</td>
									<td><c:if test="${userExpectations.garage == true}">Tak</c:if>
										<c:if test="${userExpectations.garage == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.garage}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.garage+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.garage}/10</td>
									 <td class=" my-center">${importanceOfExpectations.garage_priority}</td>
								</tr>
								<tr>
									<td>Parking</td>
									<td><c:if test="${userExpectations.parking == true}">Tak</c:if>
										<c:if test="${userExpectations.parking == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.parking}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.parking+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.parking}/10</td>
									 <td class=" my-center">${importanceOfExpectations.parking_priority}</td>
								</tr>
								<tr>
									<td>Ogród</td>
									<td><c:if test="${userExpectations.garden == true}">Tak</c:if>
										<c:if test="${userExpectations.garden == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.garden}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.garden+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.garden}/10</td>
									 <td class=" my-center">${importanceOfExpectations.garden_priority}</td>
								</tr>
								<tr>
									<td>Piwnica</td>
									<td><c:if test="${userExpectations.cellar == true}">Tak</c:if>
										<c:if test="${userExpectations.cellar == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.cellar}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.cellar+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.cellar}/10</td>
									 <td class=" my-center">${importanceOfExpectations.cellar_priority}</td>
								</tr>
								<tr>
									<td>Monitoring</td>
									<td><c:if test="${userExpectations.monitoring == true}">Tak</c:if>
										<c:if test="${userExpectations.monitoring == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.monitoring}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.monitoring+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.monitoring}/10</td>
									 <td class=" my-center">${importanceOfExpectations.monitoring_priority}</td>
								</tr>
								<tr>
									<td>Winda</td>
									<td><c:if test="${userExpectations.lift == true}">Tak</c:if>
										<c:if test="${userExpectations.lift == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.lift}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.lift+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.lift}/10</td>
									 <td class=" my-center">${importanceOfExpectations.lift_priority}</td>
								</tr>
								<tr>
									<td>Dostęp do transportu publicznego</td>
									<td><c:if
											test="${userExpectations.accessToPublicTransport == true}">Tak</c:if>
										<c:if
											test="${userExpectations.accessToPublicTransport == false}">Nie</c:if></td>
									<td>
									<c:forEach var="i" begin="1" end="${importanceOfExpectations.accessToPublicTransport}">  
									 <span class="glyphicon glyphicon-star " style="color:#1a75ff"></span>
									 </c:forEach>
									 <c:forEach var="i" begin="${importanceOfExpectations.accessToPublicTransport+1}" end="10">  
									 <span class="glyphicon glyphicon-star-empty" style="color:#0047b3"></span>
									 </c:forEach>
									 ${importanceOfExpectations.accessToPublicTransport}/10</td>
									 <td class=" my-center">${importanceOfExpectations.accessToPublicTransport_priority}</td>
								</tr>


							</tbody>
							<tfoot>
    							<tr>
      							  	<td></td>
    								<td><div class="row my-center">
										<a class="btn btn-primary" href="edit" role="button">Edytuj oczekiwania</a>
									</div>
									
									</td>
    								<td><div class="row my-center">
									<a class="btn btn-primary" href="editImportanceOfExpectations" role="button">Edytuj oceny</a>
									</div></td>
									<td><div class="row my-center">
									<a class="btn btn-primary" href="editImportanceOfExpectations" role="button">Edytuj grupy</a>
									</div></td>
   								</tr>
 							</tfoot>
						</table>
					</div>


				</div>
				 	 
			</c:if>

		</div>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<jsp:include page="../main/footer.jsp" />