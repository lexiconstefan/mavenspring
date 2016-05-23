/**
 * 
 */
App.controller('userController', ['$scope','UserService', function($scope, UserService){
	$scope.user = {};
	$scope.users={};
	
	function getAllUsers(){
		UserService.getAllUsers().then(
				function(response){
					$scope.users = response.data;
				}, 
				function(errResponse){
					console.error('Error while fetching users');
					return $q.reject(errResponse);
				}
		);
	};
	getAllUsers();
	$scope.userSubmit = function(user){
		UserService.insertUser(user);
		getAllUsers();
	};
}]);