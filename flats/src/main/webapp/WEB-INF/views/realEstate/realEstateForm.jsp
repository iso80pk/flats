<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moje nieruchomości</title>
</head>
<body>



	<form:form method="POST" modelAttribute="form">
		<table style="text-align: right;">
			<tbody>
				<tr>
					<td>Lokalizacja:</td>
					<td><form:input type="text" path="location" name="location" /></td>
				</tr>
				<tr>
					<td>Typ nieruchomości:</td>
					<td><form:select path="realEstateType" items="${realEstateTypes}" /></td>
				</tr>
				<tr>
					<td>Powierzchnia [m2]:</td>
					<td><form:input type="text" path="floorArea" name="floorArea" /></td>
				</tr>


				<tr>
					<td>Cena:</td>
					<td><form:input type="text" path="price" name="price" /></td>
				</tr>

				<tr>
					<td>ilość pokoi:</td>
					<td><form:input type="text" path="numberOfRooms"
							name="numberOfRooms" /></td>
				</tr>

				<tr>
					<td>wiek nieruchomości:</td>
					<td><form:input type="text" path="howOld" name="howOld" /></td>
				</tr>

				<tr>
					<td>piętro:</td>
					<td><form:input type="text" path="floor" name="floor" /></td>
				</tr>

				<tr>
					<td>Garaż</td>
					<td><form:checkbox path="garage" /></td>
				<tr>
				<tr>
					<td>Parking</td>
					<td><form:checkbox path="parking" /></td>
				<tr>
				<tr>
					<td>Ogród</td>
					<td><form:checkbox path="garden" /></td>
				<tr>
				<tr>
					<td>Piwnica</td>
					<td><form:checkbox path="cellar" /></td>
				<tr>
				<tr>
					<td>Monitoring</td>
					<td><form:checkbox path="monitoring" /></td>
				<tr>
				<tr>
					<td>Winda</td>
					<td><form:checkbox path="lift" /></td>
				<tr>
				<tr>
					<td>Dostęp do transportu publicznego:</td>
					<td><form:checkbox path="accessToPublicTransport" /></td>
				<tr>
				<tr>
					<td>Szacowany wkład własny <br /> (remont, umeblowanie...):
					</td>
					<td><form:input type="text" path="ownContribution"
							name="ownContribution" /></td>
				</tr>

				<tr>
					<td>ile kilometrów dziennie <br> musisz dojeżdżać
						prytatnym <br /> środkiem transportu:
					</td>
					<td><form:input type="text" path="kmPerDay" name="kmPerDay" /></td>
				</tr>

				<tr>
					<td>miesięczne koszty utrzymania<br /> (czynsz, fundusz
						remontowy,<br /> podatek od nieruchomości,<br /> opłata
						gruntowa.):
					</td>
					<td><form:input type="text" path="maintenanceCosts"
							name="maintenanceCosts" /></td>
				</tr>

				<tr>
					<td>Średnia cena nieruchomości w okolicy <br /> 
					<a href="https://ceny.szybko.pl">Sprawdź</a>
					</td>
					<td><form:input type="text" path="averagePriceInArea"
							name="averagePriceInArea" /></td>
				</tr>

				<tr>
					<td>Odnośnik do ogłoszenia</td>
					<td><form:input type="text" path="advertismentsLink"
							name="advertismentsLink" /></td>
				</tr>

				<tr>
					<td>Notatki</td>
					<td><form:input type="text" path="notes" name="notes" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Zatwierdź" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<br/>
	<a href="../realEstate/">Moje nieruchomości</a><br/>
	<br/>
	<a href="../">Strona główna</a><br/>
	
</body>
</html>