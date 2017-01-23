<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />

		<div class="container">
			<div class="row col-sm-offset-2">
				<a href="/">Strona główna</a> > <a href="/userExpectations/">Moje
					oczekiwania</a>

			</div>
			<div class="row well">
				<div class="text-center">
					<h3>
						Oceń ważność poszczególnych oczekiwań <a
							href="javascript:void(0);" data-toggle="tooltip"
							data-placement="bottom"
							title="Wskaż, które z kryteriów powinny mieć większy udział w podejmowaniu decyzji, a które mniejszy.">
							<span class="glyphicon glyphicon-info-sign"></span>
						</a>
					</h3>
				</div>
			</div>


			<form:form method="POST" class="form-horizontal"
				modelAttribute="importanceForm">
				<div class="row">
					<div class="col-md-7">
						
						<div class="form-group">
							<label class="control-label col-sm-6">Lokalizacja :
								${userExpectations.location} </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
								<form:input type="range" min="0" max="10" class="form-control " 
									path="location" name="location"  
									oninput="OUTlocation.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTlocation">${importanceForm.location*10}%</output>
								</div>
							</div>
						</div>
					
						
						<div class="form-group">
							<label class="control-label col-sm-6">Typ nieruchomości :
								${userExpectations.realEstateType}</label>
							<div class="col-sm-6">
								<div class="col-xs-10">
								<form:input type="range" min="0" max="10" class="form-control " 
									path="realEstateType" name="realEstateType"
									oninput="OUTrealEstateType.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTrealEstateType">${importanceForm.realEstateType*10}%</output>
								</div>								
							</div>
						</div>
						

						<div class="form-group">
							<label class="control-label col-sm-6">Powierzchnia od
								${userExpectations.minFloorArea} do
								${userExpectations.maxFloorArea} [m2] </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="floorArea" name="floorArea"
									oninput="OUTfloorAreae.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTfloorAreae">${importanceForm.floorArea*10}%</output>
								</div>									
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-sm-6">Cena od
								${userExpectations.minPrice} do ${userExpectations.maxPrice} </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="price" name="price"
									oninput="OUTprice.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTprice">${importanceForm.price*10}%</output>
								</div>		
							</div>
						</div>

						<c:if test="${((empty userExpectations.minNumberOfRooms) and (empty userExpectations.maxNumberOfRooms))}">
						<div class="form-group">
							<label class="control-label col-sm-6">Ilość pokoi od
								${userExpectations.minNumberOfRooms} do
								${userExpectations.maxNumberOfRooms} </label>

							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control "  disabled="true" value="0"
									path="numberOfRooms" name="numberOfRooms"
									oninput="OUTnumberOfRooms.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTnumberOfRooms">${importanceForm.numberOfRooms*10}%</output>
								</div>	
							</div>
						</div>
						</c:if>
						<c:if test="${((not empty userExpectations.minNumberOfRooms) or (not empty userExpectations.maxNumberOfRooms))}">
						<div class="form-group">
							<label class="control-label col-sm-6">Ilość pokoi od
								${userExpectations.minNumberOfRooms} do
								${userExpectations.maxNumberOfRooms} </label>

							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="numberOfRooms" name="numberOfRooms"
									oninput="OUTnumberOfRooms.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTnumberOfRooms">${importanceForm.numberOfRooms*10}%</output>
								</div>	
							</div>
						</div>
						</c:if>
						
						
						<c:if test="${((empty userExpectations.minHowOld) and (empty userExpectations.maxHowOld))}">
						<div class="form-group">
							<label class="control-label col-sm-6">Wiek nieruchomości od 
							${userExpectations.minHowOld} do ${userExpectations.maxHowOld} </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control "  disabled="true" value="0"
									path="howOld" name="howOld"
									oninput="OUThowOld.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUThowOld">${importanceForm.howOld*10}%</output>
								</div>
							</div>
						</div>
						</c:if>
						<c:if test="${((not empty userExpectations.minHowOld) or (not empty userExpectations.maxHowOld))}">
						<div class="form-group">
							<label class="control-label col-sm-6">Wiek nieruchomości od 
							${userExpectations.minHowOld} do ${userExpectations.maxHowOld} </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control "  
									path="howOld" name="howOld"
									oninput="OUThowOld.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUThowOld">${importanceForm.howOld*10}%</output>
								</div>
							</div>
						</div>
						</c:if>
						
   						<c:if test="${((empty userExpectations.minFloor) and (empty userExpectations.minFloor))}">
						<div class="form-group">
							<label class="control-label col-sm-6">Piętro od
								${userExpectations.minFloor} do ${userExpectations.maxFloor} </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " disabled="true" value="0"
									path="floor" name="floor" 
									oninput="OUTfloor.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTfloor">${importanceForm.floor*10}%</output>
								</div>	
							</div>
						</div>
						</c:if>
					 	<c:if test="${((not empty userExpectations.minFloor) or (not empty userExpectations.minFloor))}">
    						<div class="form-group">
							<label class="control-label col-sm-6">Piętro od
								${userExpectations.minFloor} do ${userExpectations.maxFloor} </label>
							<div class="col-sm-6">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="floor" name="floor"
									oninput="OUTfloor.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTfloor">${importanceForm.floor*10}%</output>
								</div>	
							</div>
							</div>    
						</c:if>			
					
					
						

					</div>
					<div class="col-md-5">

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Garaż: <c:if
									test="${userExpectations.garage == true}">Tak</c:if> <c:if
									test="${userExpectations.garage == false}">Nie</c:if></label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="garage" name="garage"
									oninput="OUTgarage.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTgarage">${importanceForm.garage*10}%</output>
								</div>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Parking: <c:if
									test="${userExpectations.parking == true}">Tak</c:if> <c:if
									test="${userExpectations.parking == false}">Nie</c:if>
							</label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="parking" name="parking"
									oninput="OUTparking.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTparking">${importanceForm.parking*10}%</output>
								</div>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Ogród: <c:if
									test="${userExpectations.garden == true}">Tak</c:if> <c:if
									test="${userExpectations.garden == false}">Nie</c:if>
							</label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="garden" name="garden"
									oninput="OUTgarden.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTgarden">${importanceForm.garden*10}%</output>
								</div>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Piwnica: <c:if
									test="${userExpectations.cellar == true}">Tak</c:if> <c:if
									test="${userExpectations.cellar == false}">Nie</c:if>
							</label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="cellar" name="cellar"
									oninput="OUTcellar.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTcellar">${importanceForm.cellar*10}%</output>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Monitoring: <c:if
									test="${userExpectations.monitoring == true}">Tak</c:if> <c:if
									test="${userExpectations.monitoring == false}">Nie</c:if>
							</label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="monitoring" name="monitoring" 
									oninput="OUTmonitoring.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTmonitoring">${importanceForm.monitoring*10}%</output>
								</div>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Winda: <c:if
									test="${userExpectations.lift == true}">Tak</c:if> <c:if
									test="${userExpectations.lift == false}">Nie</c:if>
							</label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="lift" name="lift"
									oninput="OUTlift.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTlift">${importanceForm.lift*10}%</output>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-6 col-md-4">Dostęp do
								transportu publicznego: <c:if
									test="${userExpectations.accessToPublicTransport == true}">Tak</c:if>
								<c:if
									test="${userExpectations.accessToPublicTransport == false}">Nie</c:if>
							</label>
							<div class="col-sm-6 col-md-8">
								<div class="col-xs-10">
									<form:input type="range" min="0" max="10" class="form-control " 
									path="accessToPublicTransport" name="accessToPublicTransport"
									oninput="OUTaccessToPublicTransport.value = (this.value*10)+'%'"	/>
								</div>
								<div class="col-xs-2">
									<output  id="OUTaccessToPublicTransport">${importanceForm.accessToPublicTransport*10}%</output>
								</div>	
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