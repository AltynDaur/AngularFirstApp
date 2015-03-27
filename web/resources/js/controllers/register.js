angular.module('register',['registerPersonService']).controller('RegisterController',function($scope, $http,$state,RegisterPersons){

    $scope.registerPerson = {};

    $scope.register = function(){
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};
        RegisterPersons.save($scope.registerPerson,function(response){
            $scope.successMessages = 'Register had success';
            $state.go('login')
        }),function(error){
            if ((error.status == 409) || (error.status == 400)) {
                $scope.errors = error.data;
            } else {
                $scope.errorMessages = [ 'Unknown  server error' ];
            }
            $scope.$apply();
        }

    };
});