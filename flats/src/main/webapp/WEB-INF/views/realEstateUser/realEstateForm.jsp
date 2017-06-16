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
					<h2>Nieruchomość</h2>
				</div>
			</div>

			<form:form method="POST" class="form-horizontal"
				modelAttribute="form">
				<div class="row">
					<div class="col-sm-6">


						<div class="form-group">
							<label class="control-label col-sm-5">Lokalizacja * 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Informacja o lokalizacji. Maksymalnie 50 znaków."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							
							<div class="col-sm-7">
								<form:input type="text" path="location" name="location"
									maxlength="50" required="required" pattern=".{3,}"
									class="form-control" placeholder="Podaj lokalizację" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="location" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Typ nieruchomości *
							
							</label>
							<div class="col-sm-7">
								<form:select path="realEstateType" items="${realEstateTypes}"
									class="form-control" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="realEstateType" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Powierzchnia [m2] *
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Powierzchnia nieruchomości podawana w m2. Wartość z przedziału 3.00 - 99999999.99"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input type="number"  min="3" step="0.01" max="99999999.99"
									path="floorArea" name="floorArea"	required="required"	
									class="form-control"	placeholder="Podaj powierzchnię" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="floorArea" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Cena *
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Cena całej nieruchomości.  Wartość z przedziału 3.00 - 99999999.99"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input  type="number"  min="100" step="0.01" max="99999999.99"
								 path="price" name="price"	required="required"
									class="form-control" placeholder="Podaj cenę nieruchomości" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="price" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Ilość pokoi *
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Ilośc pokoi. Nie wlicza się pomieszczeń typu kuchnia, łazienka, spiżarnia.. "> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input type="number"  min="1" step="1" max="100"
								path="numberOfRooms"	name="numberOfRooms"  required="required"
								class="form-control"	placeholder="Podaj ilość pokoi" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="numberOfRooms" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Wiek nieruchomości *
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Wiek nieruchomosci nalezy podac w latach. Wartość zaokrąglij do pełnych lat. Jeżeli jest młodsza niż rok podaj 0"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input type="number"  min="0" step="1" max="500"
								path="howOld" name="howOld"	 required="required" 
								class="form-control" placeholder="Podaj wiek mieszkania" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="howOld" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Piętro
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Jeżeli nieruchomośc jest miesznaniem, to można podać na którym piętrze się znajduje.Wartość 0 oznacza parter."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input  type="number"  min="0" step="1" max="100"
								 path="floor" name="floor" 
								 class="form-control" placeholder="Podaj piętro" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="floor" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Garaż</label>
							<div class="col-sm-7">
								<form:checkbox path="garage" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Parking</label>
							<div class="col-sm-7">
								<form:checkbox path="parking" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Ogród</label>
							<div class="col-sm-7">
								<form:checkbox path="garden" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Piwnica</label>
							<div class="col-sm-7">
								<form:checkbox path="cellar" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Monitoring</label>
							<div class="col-sm-7">
								<form:checkbox path="monitoring" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Winda</label>
							<div class="col-sm-7">
								<form:checkbox path="lift" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Dostęp do
								transportu publicznego</label>
							<div class="col-sm-7">
								<form:checkbox path="accessToPublicTransport" />
							</div>
						</div>


					</div>
					<div class="col-sm-6">



						<div class="form-group">
							<label class="control-label col-sm-5">Szacowany wkład własny 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Suma szacowanych kosztów: remontu, umeblowania, ..."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input  type="number"  min="0" step="0.01" max="99999999.99"
								path="ownContribution"	name="ownContribution" class="form-control"
									placeholder="Podaj przybliżone koszty remonyu, umeblowania, itp" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="ownContribution" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Dystans dzienny: 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="ile kilometrów dziennie musisz dojeżdżać prytatnym środkiem
								transportu. Podaj przybliżoną wartość średnią."> 
								<span class="glyphicon glyphicon-info-sign"></span></a> 
							</label>
							<div class="col-sm-7">
								<form:input type="number"  min="0" step="0.01" max="9999.99"
								path="kmPerDay" name="kmPerDay"
								class="form-control" placeholder="Podaj dystans w km" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="kmPerDay" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Miesięczne koszty utrzymania
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Koszty związane z utrzymaniem nieruchomości np.:
								czynsz, fundusz remontowy, podatek od nieruchomości, opłata gruntowa.
								Podaj przybliżoną wartość."> 
								<span class="glyphicon glyphicon-info-sign"></span></a> 
							</label>
							<div class="col-sm-7">
								<form:input type="number"  min="0" step="0.01" max="99999.99"
								path="maintenanceCosts" name="maintenanceCosts"
									class="form-control" placeholder="Podaj przybliżone koszty" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="maintenanceCosts" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5">Średnia cena w okolicy <br />
								<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Średnia cena 1m2 nitruchomości w okolicy. 
								Jeżeli jej nie znasz skożystaj z poniższego linku"> 
								<span class="glyphicon glyphicon-info-sign"></span></a> 
								 <a target="_blank" href="https://ceny.szybko.pl">Sprawdź</a>
							</label>
							<div class="col-sm-7">
								<form:input type="number"  min="100" step="0.01" max="999999.99"
								 path="averagePriceInArea" name="averagePriceInArea"
									class="form-control" placeholder="Podaj cenę za 1m2" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="averagePriceInArea" class="my-form-error" /></c:if>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5"> Link do ogłoszenia
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Jeżeli ogłoszenie znaleziono w Internecie, to można podac do niego link.
								Ułatwi to ponowne znalezienie ogłoszenia, np. w celu sprawdzenia, czy jest jeszcze aktualne."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
							</label>
							<div class="col-sm-7">
								<form:input type="url" path="advertismentsLink"
									name="advertismentsLink" class="form-control"
									placeholder="wpisz aders" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-5"> Notatki 
							<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Osobiste notatki dotyczące ogłoszenia."> 
								<span class="glyphicon glyphicon-info-sign"></span></a></label>
							<div class="col-sm-7">
								<form:textarea rows="5" cols="30" path="notes" name="notes"
									class="form-control" placeholder="miejsce na notatki" />
							</div>
						</div>

					</div>
				</div>
				<div class="form-group row">
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