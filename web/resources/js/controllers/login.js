var loginController = angular.module('login',['ui.router','angular-storage']);

loginController.controller('loginController',function($scope,$http,store,$state){
    $scope.loginPerson = {};
    $scope.errorMessages = '';
    $scope.login = function(){
        $http({
            url:"http://localhost:8080/AngularFirstApp/secretSanta/login",
            method:'POST',
            data:$scope.loginPerson
        }).then(function(response){
            if(response.data.token !== "null"){
                store.set('jwt',response.data.token);
                $state.go('wishesList');
            }
            else{
                $scope.errorMessages = [ 'Your account not found error' ];
            }
        }), function (error) {
            alert(error);
        }
    };
    $scope.logout = function(){
        store.remove('jwt');
        $state.go('login');
    };
});
