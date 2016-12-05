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
	<p style="width: 100%; text-align: center;">Moje nieruchomości</p>
	<br />
	<p style=text-align:center><a href="add">dodaj nową nieruchomość</a></p>
	<table border=1 align="center">
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
					<td><a href="${realEstate.advertismentsLink}">KLIK</a></td>
					
					<td><a href="details-${realEstate.id}">Szczegóły</a></td>
					<td><a href="edit-${realEstate.id}">Edytuj</a></td>
					<td><a href="delete-${realEstate.id}">Usuń</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br/>
	<center>
		<a href="../">Strona główna</a><br/>
	</center>


</body>
</html>