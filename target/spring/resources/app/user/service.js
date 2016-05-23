/**
 * 
 */
App.factory('UserService', ['$http', function($http){
	return{
		getAllUsers : function(){
			return $http.get('http://localhost:8080/spring/getuser/');
			
		},
		insertUser: function(user){
			 $http({
		          method  : 'POST',
		          url     : 'http://localhost:8080/spring/insertuser/',
		          data    : user//forms user object
		          
		         });
		}
	}
}]);