<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />

		<div class="container">
		<div class="row col-sm-offset-2"> <a href="/">Strona główna</a> > <a href="/userExpectations/">Moje oczekiwania</a>
			
		</div>
		<div class="row well">
			<div class="text-center">
				<h3> Moje oczekiwania</h3> 
			</div>
		</div>


			<form:form method="POST" class="form-horizontal"
				modelAttribute="form">
				<div class="row">
					<div class="col-sm-8">


						<div class="form-group">
							<label class="control-label col-sm-4">Lokalizacja * 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Informacja o lokalizacji. Maksymalnie 50 znaków."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							
							<div class="col-sm-8">
								<form:input type="text" path="location" name="location"
									maxlength="50" required="required" pattern=".{3,}"
									class="form-control" placeholder="Podaj lokalizację" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="location" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Typ nieruchomości *
							
							</label>
							<div class="col-sm-8">
								<form:select path="realEstateType" items="${realEstateTypes}"
									class="form-control" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="realEstateType" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Powierzchnia [m2]
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Powierzchnia nieruchomości podawana w m2. Wartość z przedziału 3.00 - 99999999.99"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							
							<div class="col-sm-4">
								<form:input type="number"  min="3" step="0.01" max="99999999.99"
									path="minFloorArea" name="minFloorArea"	
									class="form-control"	placeholder="Od" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="floorArea" class="my-form-error" /></c:if>
							</div>
							
							<div class="col-sm-4">
								<form:input type="number"  min="3" step="0.01" max="99999999.99"
									path="maxFloorArea" name="maxFloorArea"	
									class="form-control"	placeholder="Do" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="floorArea" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Cena 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Cena całej nieruchomości.  Wartość z przedziału 3.00 - 99999999.99"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-4">
								<form:input  type="number"  min="100" step="0.01" max="99999999.99"
								 path="minPrice" name="minPrice"	
									class="form-control" placeholder="Od" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="minPrice" class="my-form-error" /></c:if>
							</div>
							<div class="col-sm-4">
								<form:input  type="number"  min="100" step="0.01" max="99999999.99"
								 path="maxPrice" name="maxPrice"	
									class="form-control" placeholder="Do" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="maxPrice" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Ilość pokoi 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Ilośc pokoi. Nie wlicza się pomieszczeń typu kuchnia, łazienka, spiżarnia.. "> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-4">
								<form:input type="number"  min="1" step="1" max="100"
								path="minNumberOfRooms"	name="minNumberOfRooms"  
								class="form-control"	placeholder="Od" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="minNumberOfRooms" class="my-form-error" /></c:if>
							</div>
							<div class="col-sm-4">
								<form:input type="number"  min="1" step="1" max="100"
								path="maxNumberOfRooms"	name="maxNumberOfRooms" 
								class="form-control"	placeholder="Do" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="maxNumberOfRooms" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Wiek nieruchomości 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Wiek nieruchomosci nalezy podac w latach. Wartość zaokrąglij do pełnych lat. Jeżeli jest młodsza niż rok podaj 0"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-4">
								<form:input type="number"  min="0" step="1" max="500"
								path="minHowOld" name="minHowOld"	 
								class="form-control" placeholder="Od" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="minHowOld" class="my-form-error" /></c:if>
							</div>
							<div class="col-sm-4">
								<form:input type="number"  min="0" step="1" max="500"
								path="maxHowOld" name="maxHowOld"	 
								class="form-control" placeholder="Do" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="maxHowOld" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4">Piętro
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Jeżeli nieruchomośc jest miesznaniem, to można podać na którym piętrze się znajduje.Wartość 0 oznacza parter."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-4">
								<form:input  type="number"  min="0" step="1" max="100"
								 path="minFloor" name="minFloor" 
								 class="form-control" placeholder="Od" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="minFloor" class="my-form-error" /></c:if>
							</div>
							<div class="col-sm-4">
								<form:input  type="number"  min="0" step="1" max="100"
								 path="maxFloor" name="maxFloor" 
								 class="form-control" placeholder="Do" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="maxFloor" class="my-form-error" /></c:if>
							</div>
						</div>



					</div>
					<div class="col-sm-4">

					
						<div class="form-group">
							<label class="control-label col-sm-8">Garaż</label>
							<div class="col-sm-2">
								<form:checkbox path="garage" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-8">Parking</label>
							<div class="col-sm-2">
								<form:checkbox path="parking" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-8">Ogród</label>
							<div class="col-sm-2">
								<form:checkbox path="garden" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-8">Piwnica</label>
							<div class="col-sm-2">
								<form:checkbox path="cellar" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-8">Monitoring</label>
							<div class="col-sm-2">
								<form:checkbox path="monitoring" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-8">Winda</label>
							<div class="col-sm-2">
								<form:checkbox path="lift" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-8">Dostęp do
								transportu publicznego</label>
							<div class="col-sm-2">
								<form:checkbox path="accessToPublicTransport" />
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

<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<jsp:include page="../main/footer.jsp" />