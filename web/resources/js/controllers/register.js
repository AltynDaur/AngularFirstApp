angular.module('register',[]).controller('RegisterController',function($scope, $http,$state){
    $scope.loginPerson = {};
    $scope.register = function(){
        $http({
            url:"http://localhost:8080/AngularFirstApp/schedule/register",
            method:"POST",
            data:$scope.registerPerson
        }).then(function(response){
            $state.go('login')
        }, function(error){

        })
    };
});