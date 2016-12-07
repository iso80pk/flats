<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">


			<form:form method="POST" class="form-horizontal"
				modelAttribute="form">

				<div class="form-group">
					<label class="control-label col-sm-4">Lokalizacja</label>
					<div class="col-sm-6">
						<form:input type="text" path="location" name="location"
							class="form-control" placeholder="Podaj lokalizację" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Typ nieruchomości</label>
					<div class="col-sm-6">
						<form:select path="realEstateType" items="${realEstateTypes}"
							class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Powierzchnia [m2]</label>
					<div class="col-sm-6">
						<form:input type="text" path="floorArea" name="floorArea"
							class="form-control" placeholder="Podaj powierzchnię" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Cena</label>
					<div class="col-sm-6">
						<form:input type="text" path="price" name="price"
							class="form-control" placeholder="Podaj cenę nieruchomości" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">ilość pokoi</label>
					<div class="col-sm-6">
					<form:input type="text" path="numberOfRooms" name="numberOfRooms"
							class="form-control" placeholder="Podaj ilość pokoi" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">wiek nieruchomości</label>
					<div class="col-sm-6">
						<form:input type="text" path="howOld" name="howOld"
							class="form-control" placeholder="Podaj wiek mieszkania" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">piętro</label>
					<div class="col-sm-6">
						<form:input type="text" path="floor" name="floor"
							class="form-control" placeholder="Podaj piętro" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">ilość pokoi</label>
					<div class="col-sm-6">
						<form:input type="text" path="numberOfRooms" name="numberOfRooms"
							class="form-control" placeholder="Podaj liczbę pokoi" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Garaż</label>
					<div class="col-sm-6">
						<form:checkbox path="garage" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Parking</label>
					<div class="col-sm-6">
						<form:checkbox path="parking" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Ogród</label>
					<div class="col-sm-6">
						<form:checkbox path="garden" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Piwnica</label>
					<div class="col-sm-6">
						<form:checkbox path="cellar" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Monitoring</label>
					<div class="col-sm-6">
						<form:checkbox path="monitoring" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Winda</label>
					<div class="col-sm-6">
						<form:checkbox path="lift" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Dostęp do transportu publicznego</label>
					<div class="col-sm-6">
						<form:checkbox path="accessToPublicTransport" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Szacowany wkład własny <br /> (remont, umeblowanie...)</label>
					<div class="col-sm-6">
						<form:input type="text" path="ownContribution" name="ownContribution"
							class="form-control" placeholder="Podaj przybliżone koszty remonyu, umeblowania itp" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">ile kilometrów dziennie <br>
					 musisz dojeżdżać prytatnym <br />
					 środkiem transportu</label>
					<div class="col-sm-6">
						<form:input type="text" path="ownContribution" name="ownContribution"
							class="form-control" placeholder="Podaj dystans w km" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">miesięczne koszty utrzymania<br />
					 (czynsz, funduszremontowy,<br />
					  podatek od nieruchomości,<br /> 
					  opłata gruntowa.)
						</label>
					<div class="col-sm-6">
						<form:input type="text" path="maintenanceCosts" name="maintenanceCosts"
							class="form-control" placeholder="Podaj przybliżone koszty" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Średnia cena za 1m2 nieruchomości w okolicy <br />
					 <a target="_blank"	href="https://ceny.szybko.pl">Sprawdź</a>
					</label>
					<div class="col-sm-6">
						<form:input type="text" path="averagePriceInArea" name="averagePriceInArea"
							class="form-control" placeholder="Podaj cenę za 1m2" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">
					Link do ogłoszenia
					</label>
					<div class="col-sm-6">
						<form:input type="text" path="advertismentsLink" name="advertismentsLink"
							class="form-control" placeholder="wpisz aders, aby łatwiej sprawdzić, czy ogłoszenie jest jeszcze aktywne" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">
					Notatki
					</label>
					<div class="col-sm-6">
						<form:input type="text" path="notes" name="notes"
							class="form-control" placeholder="miejsce na notatki" />
					</div>
				</div>

				
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						<button type="submit" class="btn btn-default">Zatwierdź</button>
					</div>
				</div>
				
			</form:form>
			
			<br /> <a href="../realEstate/">Moje nieruchomości</a><br /> <br />
			<a href="../">Strona główna</a><br />


		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />