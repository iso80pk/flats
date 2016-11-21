<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Statystyki</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Wszystkie statystyki</p>
	<table border=1 align="center">
		<thead>
			<tr>

				<td>ID</td>
				<td>Obowiązuje od</td>
				<td>Obowiązuje do </td>
				<td>Nazwa obszaru</td>
				<td>Czy miasto?</td>
				<td>Za mieszkanie?</td>
				<td>cena za 1m2</td>
				<td>Źróło danych</td>
				<td>Autor</td>
				<td>Usuń</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="statistic" items="${statistics}" varStatus="status">
				<tr>
					<td>${statistic.id}</td>
					<td><fmt:formatDate pattern="dd.MM.yyyy"    value="${statistic.statisticFrom}" />r.</td>
					<td><fmt:formatDate pattern="dd.MM.yyyy"    value="${statistic.statisticTo}" />r.</td>
					<td>${statistic.areaName}</td>
					<td><c:if test="${statistic.city == true}">Tak</c:if>
						<c:if test="${statistic.city == false}">Nie</c:if>
					</td>
					<td>
					<c:if test="${statistic.flat == true}">Tak</c:if>
						<c:if test="${statistic.flat == false}">Nie</c:if>
					
					<td>${statistic.price} zł.</td>
					<td>${statistic.dataSource}</td>
					<td>${statistic.user.username}</td>
					<td><a href="delete-${statistic.id}">Usuń</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</br>
	<center>
	<a href="../">Strona główna</a></br></br>
	<a href="add">Dodaj nowe dane</a>
	</center>
	
	
</body>
</html>