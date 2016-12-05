<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Moje nieruchomości</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Wszystkie statystyki</p>
	<table border=1 align="center">
	
		<tbody>
			
				<tr>
					<td>Lokalizacja:</td><td>${realEstate.location}</td>
				</tr><tr>
					<td>Typ nieruchomości:</td><td>${realEstate.realEstateType}</td>
				</tr><tr>
					<td>Powierzchnia [m2]:</td><td>${realEstate.floorArea}</td>
				</tr><tr>
					<td>Cena:</td><td>${realEstate.price}</td>
				</tr><tr>
					<td>ilość pokoi:</td><td>${realEstate.numberOfRooms}</td>
				</tr><tr>
					<td>wiek nieruchomości:</td><td>${realEstate.howOld}</td>
				</tr><tr>
					<td>piętro:</td><td>${realEstate.floor}</td>
				</tr><tr>
					<td>Garaż</td><td><c:if test="${realEstate.garage == true}">Tak</c:if> 
						<c:if test="${realEstate.garage == false}">Nie</c:if></td>
				</tr><tr>
					<td>Parking</td><td><c:if test="${realEstate.parking == true}">Tak</c:if> 
						<c:if test="${realEstate.parking == false}">Nie</c:if></td>
				</tr><tr>
					<td>Ogród</td><td><c:if test="${realEstate.garden == true}">Tak</c:if> 
						<c:if test="${realEstate.garden == false}">Nie</c:if></td>
				</tr><tr>
					<td>Piwnica</td><td><c:if test="${realEstate.cellar == true}">Tak</c:if> 
						<c:if test="${realEstate.cellar == false}">Nie</c:if></td>
				</tr><tr>
					<td>Monitoring</td><td><c:if test="${realEstate.monitoring == true}">Tak</c:if> 
						<c:if test="${realEstate.monitoring == false}">Nie</c:if></td>
				</tr><tr>
					<td>Winda</td><td><c:if test="${realEstate.lift == true}">Tak</c:if> 
						<c:if test="${realEstate.lift == false}">Nie</c:if></td>
				</tr><tr>
					<td>Dostęp do transportu publicznego:</td><td><c:if test="${realEstate.accessToPublicTransport == true}">Tak</c:if> 
						<c:if test="${realEstate.accessToPublicTransport == false}">Nie</c:if></td>
				</tr><tr>
					<td>Szacowany wkład własny <br />
					(remont, umeblowanie...):</td><td>${realEstate.ownContribution}</td>
				</tr><tr>
					<td>ile kilometrów dziennie <br> musisz dojeżdżać
						prytatnym <br /> środkiem transportu:
					</td>
					<td>${realEstate.kmPerDay}</td>
				</tr><tr>
					<td>miesięczne koszty utrzymania<br /> (czynsz, fundusz
						remontowy,<br /> podatek od nieruchomości,<br /> opłata
						gruntowa.):
					</td>
					<td>${realEstate.maintenanceCosts}</td>
				</tr><tr>
					<td>Średnia cena nieruchomości w okolicy:</td><td>${realEstate.averagePriceInArea}</td>
				</tr><tr>
					<td>Odnośnik do ogłoszenia:</td><td><a href="${realEstate.advertismentsLink}">KLIK</a></td>
				</tr><tr>
					<td>Notatki</td><td>${realEstate.notes}</td>
				</tr>
				
				
				
				<tr>
					<td><a href="edit-${realEstate.id}">Edutuj</a></td>
					<td><a href="delete-${realEstate.id}">Usuń</a></td>
				</tr>
			
		</tbody>
	</table>
	
	<br/>
	<center>
		<a href="../realEstate/">Wstecz</a><br/>
	</center>
	<br/>
	<center>
		<a href="../">Strona główna</a><br/>
	</center>


</body>
</html>