var myApp = angular.module('myApp', []);
myApp
		.controller(
				'PageNavigationController',
				function($scope, $http) {
					var urlBase = 'http://localhost:8080/freshmen-web/';
					$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";

					function loadData() {
						$http.get(urlBase + '/list/all').success(
								function(data) {
									$scope.lstData = data;

								});
					}

					$scope.editIndex = -1;

					$scope.save = function() {
						var saveObj = new Object();
						saveObj.name = $scope.name;
						saveObj.occupation = $scope.occupation;

						path = '/save';
						if ($scope.editIndex > -1) {
							saveObj.index = $scope.editIndex;
							path = '/update';
						}
						$http(
								{
									method : 'POST',
									url : urlBase + path,
									data : saveObj,
									headers : {
										'Accept' : 'application/json',
										'Content-Type' : 'application/json; charset=utf-8',
									}
								}).success(
								function(data, status, headers, config) {
									$scope.editIndex = -1;
									loadData();
									$scope.name = '';
									$scope.occupation = '';

								}).error(
								function(data, status, headers, config) {
								});
					}

					$scope.edit = function(row, index) {
						$scope.name = row.name;
						$scope.occupation = row.occupation;
						$scope.editIndex = index;
					}

					$scope.remove = function(row, index) {
						row.index = index;
						path = '/delete';

						$http(
								{
									method : 'POST',
									url : urlBase + path,
									data : row,
									headers : {
										'Accept' : 'application/json',
										'Content-Type' : 'application/json; charset=utf-8',
									}
								}).success(
								function(data, status, headers, config) {
									$scope.editIndex = -1;
									loadData();
								}).error(
								function(data, status, headers, config) {
								});
					}

					loadData();

				});