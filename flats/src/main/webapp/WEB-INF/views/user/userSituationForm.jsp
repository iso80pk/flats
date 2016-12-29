<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../main/header.jsp" />


<div class="row">
	<div class="col-xs-12">
		<div class="container">
		
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/aboutMe/mySituation">Informacje podstawowe</a>
			</div>

			<div class="row">
				<div class="text-center">
					<h2>Informacje podstawowe</h2>
				</div>
			</div>
		
			<div class="row">
				<form:form method="POST" modelAttribute="userSituation" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-4">Kolejna przeprowadzka *:
					<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Na jaki okres szukasz nieruchomości? wartość zaokrąglij do pełnych lat."> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
					</label>
					<div class="col-sm-6">
						<form:input  type="number"  min="1" step="1" max="100" required="required"
						 path="nextRemoval" name="nextRemoval"
						class="form-control" placeholder="Podaj wartość w latach" />
							 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="nextRemoval" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Ilość członków rodziny *:
					<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Ilość osób, które będą zamieszkiwały nieruchomość"> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
					</label>
					<div class="col-sm-6">
						<form:input  type="number"  min="1" step="1" max="50" required="required"
						path="numberOfFamilyMembers" name="numberOfFamilyMembers"
						class="form-control" placeholder="Podaj ilość" />
						<c:if test="${pageContext.request.method=='POST'}">
						<form:errors path="numberOfFamilyMembers" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4">Koszty przejazdu prywatnym samochodem *:
					<a href="javascript:void(0);" data-toggle="tooltip" data-placement="bottom"
								title="Koszt przejechania 100km. prywatnym samochodem. "> 
								<span class="glyphicon glyphicon-info-sign"></span></a>
					</label>
					<div class="col-sm-6">
						<form:input  type="number"  min="0" step="0.01" max="500" required="required"
						path="costOfPersonalCarUsage" name="costOfPersonalCarUsage" 
						class="form-control" placeholder="Podaj koszt" />
						 <c:if test="${pageContext.request.method=='POST'}">
							 <form:errors path="costOfPersonalCarUsage" class="my-form-error" /></c:if>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						<button type="submit" class="btn btn-default">Zatwierdź</button>
					</div>
				</div>
				
			</form:form>
			</div>
		
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>

<jsp:include page="../main/footer.jsp" />