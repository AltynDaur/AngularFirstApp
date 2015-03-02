var loginController = angular.module('login',['ui.router','angular-storage']);

loginController.controller('loginController',function($scope,$http,store,$state){
    $scope.loginPerson = {};
    $scope.login = function(){
        $http({
            url:"http://localhost:8080/AngularFirstApp/schedule/login",
            method:'POST',
            data:$scope.loginPerson
        }).then(function(response){
            store.set('jwt',response.data.token);
            $state.go('adminScheduleTable');
        }), function (error) {
            alert(error.data);
        }
    }
});
