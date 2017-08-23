<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />
<div class="container">
	<div class="row col-sm-offset-2">
		<a href="/">Strona główna</a> > <a href="/realEstate/">
			Dostępne oferty</a> > <a href="/realEstate/add"> Doddaj z ogłoszenia</a>
	</div>

	<div class="row">
		<div class="text-center">
			<h2>Znajdź dane w treści ogłoszenia</h2>
			<br />
		</div>
	</div>

	<form:form method="POST" class="form-horizontal" modelAttribute="searchData">
		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-6"> Treść ogłoszenia <a
					href="javascript:void(0);" data-toggle="tooltip"
					data-placement="bottom"
					title="wklej tutaj terść ogłoszenia,a system wyszuka dane i uzupeni nimi formularz">
						<span class="glyphicon glyphicon-info-sign"></span>
				</a></label>
				<div class="col-sm-12">
					<form:textarea rows="20" cols="30" path="text" name="text"
						class="form-control" placeholder="Wklej treść ogłoszenia" />
				</div>
			</div>
		</div>
		<div class="form-group row">
			<div class="text-center">
				<button type="submit" class="btn btn-default">Wyszukaj
					informacji w treści ogłoszenia</button>
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