(function(){
    angular.module('login')
        .controller('loginController',LoginController);

    function LoginController($scope,$http,store,$state, jwtHelper, $rootScope){
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
                        currentUser = jwtHelper.decodeToken(response.data.token);
                        $rootScope.currentUserID = currentUser.id;
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

    };

})();