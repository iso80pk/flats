<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/userExpectations/">Moje
					oczekiwania</a>

			</div>
			<div class="row well">
				<div class="text-center">
					<h3>
						Oceń ważność poszczególnych oczekiwań <a
							href="javascript:void(0);" data-toggle="tooltip"
							data-placement="bottom"
							title="Wskaż, które z kryteriów powinny mieć większy wpływ(dając wyższą ocenę), a które mniejszy. ?">
							<span class="glyphicon glyphicon-info-sign"></span>
						</a>
					</h3>
				</div>
			</div>


			<form:form method="POST" class="form-horizontal"
				modelAttribute="importanceForm">
				<div class="row">
					<div class="col-sm-7">

						<div class="form-group">
							<label class="control-label col-sm-7">Lokalizacja :
								${userExpectations.location} </label>
							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="location" name="location" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-7">Typ nieruchomości :
								${userExpectations.realEstateType}</label>
							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="realEstateType" name="realEstateType" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-7">Powierzchnia od
								${userExpectations.minFloorArea} do
								${userExpectations.maxFloorArea} [m2] </label>
							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="floorArea" name="floorArea" />
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-sm-7">Cena od
								${userExpectations.minPrice} do ${userExpectations.maxPrice} </label>
							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="price" name="price" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-7">Ilość pokoi od
								${userExpectations.minNumberOfRooms} do
								${userExpectations.maxNumberOfRooms} </label>

							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="numberOfRooms" name="numberOfRooms" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-7">Wiek nieruchomości
								od ${userExpectations.minHowOld} do
								${userExpectations.maxHowOld} </label>
							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="howOld" name="howOld" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-7">Piętro od
								${userExpectations.minFloor} do ${userExpectations.maxFloor} </label>
							<div class="col-sm-5">
								<form:input type="range" min="1" max="10" class="form-control"
									path="floor" name="floor" />
							</div>
						</div>


					</div>
					<div class="col-sm-5">


						<div class="form-group">
							<label class="control-label col-sm-5">Garaż: <c:if
									test="${userExpectations.garage == true}">Tak</c:if> <c:if
									test="${userExpectations.garage == false}">Nie</c:if></label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="garage" name="garage" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Parking: <c:if
									test="${userExpectations.parking == true}">Tak</c:if> <c:if
									test="${userExpectations.parking == false}">Nie</c:if>
							</label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="parking" name="parking" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Ogród: <c:if
									test="${userExpectations.garden == true}">Tak</c:if> <c:if
									test="${userExpectations.garden == false}">Nie</c:if>
							</label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="garden" name="garden" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Piwnica: <c:if
									test="${userExpectations.cellar == true}">Tak</c:if> <c:if
									test="${userExpectations.cellar == false}">Nie</c:if>
							</label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="cellar" name="cellar" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Monitoring: <c:if
									test="${userExpectations.monitoring == true}">Tak</c:if> <c:if
									test="${userExpectations.monitoring == false}">Nie</c:if>
							</label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="monitoring" name="monitoring" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Winda: <c:if
									test="${userExpectations.lift == true}">Tak</c:if> <c:if
									test="${userExpectations.lift == false}">Nie</c:if>
							</label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="lift" name="lift" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Dostęp do
								transportu publicznego: <c:if
									test="${userExpectations.accessToPublicTransport == true}">Tak</c:if>
								<c:if
									test="${userExpectations.accessToPublicTransport == false}">Nie</c:if>
							</label>
							<div class="col-sm-7">
								<form:input type="range" min="1" max="10" class="form-control"
									path="accessToPublicTransport" name="accessToPublicTransport" />
							</div>
						</div>


					</div>
				</div>
				<div class="form-group row well">
					<div class="text-center">
						<button type="submit" class="btn btn-default">Zatwierdź</button>
					</div>
				</div>

			</form:form>

		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<jsp:include page="../main/footer.jsp" />