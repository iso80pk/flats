<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Statystyki</title>
</head>
<body>
	<p style="width: 100%; text-align: center;">Uzupełniasz statystyki</p>
	
	<c:if test="${pageContext.request.method=='POST'}">
		
		<font color="red">Formularz zawiera błędy</font></div>
	</c:if>
	
	<form:form method="POST" modelAttribute="form">
		<table style="text-align: right;">
			<tbody>
				
				<tr>
					<td>nazwa obszaru:</td>
					<td><form:input type="text" path="areaName" name="areaName" /></td>
				</tr>
				<tr>
					<td>Czy to miasto</td>
					<td><form:checkbox path="city" /></td>
				</tr>
				
				<tr>
					<td>Cena za [m2]:</td>
					<td><form:input type="text" path="price" name="price" /></td>
				</tr>
				<tr>
					<td>cena za mieszkanie?</td>
					<td><form:checkbox path="flat"  /></td>
				</tr>
				<tr>
					<td>Dane za okres od:</td>
					<td><form:input type="text" path="statisticFrom" name="statisticFrom" /></td>
				</tr>
				<tr>
					<td>do:</td>
					<td><form:input type="text" path="statisticTo" name="statisticTo" /></td>
				</tr>
				<tr>
					<td>Źródło danych:</td>
					<td><form:input type="text" path="dataSource" name="dataSource" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Dodaj" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>