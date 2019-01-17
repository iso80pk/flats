<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" />
<script>
	var app = angular.module("demo", [ "dndLists" ]);

	app.controller("SimpleDemoController", function($scope, $http) {

		$scope.models = {
			selected : null,
			lists : {}
		};

		$scope.addGroup = function() {
			let listsLength = Object.keys($scope.models.lists).length;
			$scope.models.lists[listsLength + 1] = {
				"id" : null,
				"degree" : listsLength + 1,
				"name" : null,
				"importance" : null,
				"atributes" : []
			};
		};

		$scope.deleteContainer = function(degree) {
			console.log(degree);
			delete $scope.models.lists[degree];
			//console.log(Object.keys(aa)[0]);

		};

		$scope.saveGroups = function() {
			$http.post('/api/group', $scope.models.lists).then(function(resp) {
				$scope.models.lists = resp.data;
				console.log(resp);
			}, function(error) {
				console.log(error);
			});
		};

		$scope.$watch('models', function(model) {
			$scope.modelAsJson = angular.toJson(model, true);
		}, true);

		$http.get('/api/group').then(function(resp) {
			$scope.models.lists = resp.data;
			console.log(resp);
		}, function(error) {
			console.log(error);
		});

	});
</script>

<div class="container" ng-app="demo">

	<div ng-controller="SimpleDemoController" class="cont">
		<div ng-repeat="li in models.lists" style="width: 25%;">
			<div class="group-container">
				<div style="width: 100%; height: 25px;">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
						<b>Grupa {{li.degree}}</b> : {{li.importance | number}}%
					</div>

					<div class="col-sm-1" ng-if="li.atributes.length<1"
						ng-click="deleteContainer(li.degree)">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					</div>
				</div>
				<div style="width: 100%">
					<ul dnd-list="li.atributes">


						<li ng-repeat="item in li.atributes" dnd-draggable="item"
							dnd-moved="li.atributes.splice($index, 1)"
							dnd-effect-allowed="move" dnd-selected="models.selected = item"
							dnd-disable-if="item.importance == 0"
							ng-class="{'selected': models.selected === item}">
							{{item.name}} - {{item.importance}}%</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-12">{{models.lists}}</div>
		<button class="btn btn-success" ng-click="addGroup()">Dodaj
			geupę</button>
		<button class="btn btn-success" ng-click="saveGroups()">Zapisz</button>





	</div>
</div>

<jsp:include page="../main/footer.jsp" />