<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />
<div class="container">
	<div class="row col-sm-offset-2">
		<a href="/">Strona główna</a> > <a href="/realEstate/">
			Nieruchomości do porównania</a>
	</div>

	<div class="row">
		<div class="text-center">
			<h2>Dodaj do obserwowanych</h2>
			<br />
		</div>
	</div>

	<form:form method="POST" class="form-horizontal" modelAttribute="form">
		<div class="col-md-8 col-md-offset-2">
			<div class="form-group row">
				<label class="control-label col-sm-3">Moja nazwa * <a
					href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom"
					title="NMazwan nadana przez użytkownika pomoże mu sdzybciej odnaleźć szukaną nieruchomość">
						<span class="glyphicon glyphicon-info-sign"></span>
				</a>
				</label>

				<div class="col-sm-9">
					<form:input type="text" path="nammedByUser" name="nammedByUser"
						maxlength="50" class="form-control"
						placeholder="Podaj swoją nazwę" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="nammedByUser" class="my-form-error" />
					</c:if>
				</div>
			</div>

			<div class="form-group row">
				<label class="control-label col-sm-3">Ulubione<a
					href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom" title="wyróżnij ogłoszenie"> <span
						class="glyphicon glyphicon-info-sign"></span>
				</a>
				</label>
				<div class="col-sm-9">
					<form:checkbox path="favorite" />
				</div>
			</div>

			<div class="form-group row">
				<label class="control-label col-sm-3">Szacowany wkład własny
					<a href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom"
					title="Szacowana kwota, jaką należy zainwestować, aby mieszkanie dostosować do swoich potrzeb. Wartość z przedziału 0.00 - 99999999.99">
						<span class="glyphicon glyphicon-info-sign"></span>
				</a>
				</label>
				<div class="col-sm-9">
					<form:input type="number" min="0" step="0.01" max="99999999.99"
						path="ownContribution" name="ownContribution" class="form-control"
						placeholder="Szacowany wkład własny" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="ownContribution" class="my-form-error" />
					</c:if>
				</div>
			</div>

			<div class="form-group row">
				<label class="control-label col-sm-3">Szacowany dystans<a
					href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom"
					title="Szacowany dystans jaki użytkownik będzie musiał pokonać dziennie do pracy, szkoły itp. Wartość z przedziału 0.00 - 9999.99">
						<span class="glyphicon glyphicon-info-sign"></span>
				</a>
				</label>
				<div class="col-sm-9">
					<form:input type="number" min="0" step="0.01" max="9999.99"
						path="kmPerDay" name="kmPerDay" class="form-control"
						placeholder="Szacowany dystans" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="kmPerDay" class="my-form-error" />
					</c:if>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-3">Miesięczne koszty
					utrzymania<a href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom"
					title="Miesięczne koszty utrzymania. Np. Czynsz, media i inne opłaty. Wartość z przedziału 0.00 - 9999.99">
						<span class="glyphicon glyphicon-info-sign"></span>
				</a>
				</label>
				<div class="col-sm-9">
					<form:input type="number" min="0" step="0.01" max="9999.99"
						path="maintenanceCosts" name="maintenanceCosts"
						class="form-control" placeholder="Podaj szacowane miesięczne koszty utrzymania" />
					<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="maintenanceCosts" class="my-form-error" />
					</c:if>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3"> Notatki <a
					href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom"
					title="dodatkowe notaki uztkownika">
						<span class="glyphicon glyphicon-info-sign"></span>
				</a></label>
				<div class="col-sm-9">
					<form:textarea rows="3" path="notes" name="notes"
						class="form-control" placeholder="Notatki..." />
				</div>
			</div>

		</div>
		<div class=" col-md-8 col-md-offset-2">
			<div class="text-center">
				<button type="submit" class="btn btn-success">Dodaj</button>
			</div>
		</div>

	</form:form>


	<div class="row">
		<br /> <br />
		<div class="table-responsive col-md-8 col-md-offset-2">
			<table class="table table-striped">
				<thead>
					<tr>
						<td><b>Informacje o nieruchomości</b></td>
						<td></td>
					</tr>
				</thead>
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
						<td>Średnia cena nieruchomości w okolicy:</td>
						<td>${realEstate.averagePriceInArea}</td>
					</tr>
					<tr>
						<td>Odnośnik do ogłoszenia:</td>
						<td><a target="_blank" href="${realEstate.advertismentsLink}">KLIK</a></td>
					</tr>

					<tr>
						<td>Numer telefonu sprzedającego:</td>
						<td>${realEstate.sellerPhoneNumber}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


</div>

<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<jsp:include page="../main/footer.jsp" />