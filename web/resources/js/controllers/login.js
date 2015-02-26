var loginController = angular.module('login',['ui.router','angular-storage']);

loginController.controller('loginController',function($scope,$http,store,$state){
    $scope.loginPerson = {};
    $scope.login = function(){
        $http({
            url:"http://localhost:8080/schedule/login",
            method:'POST',
            data:$scope.loginPerson
        }).then(function(response){
            store.set('jwt',response.data.id_token);
            $state.go('scheduleTable');
        }), function (error) {
            alert(error.data);
        }
    }
});
