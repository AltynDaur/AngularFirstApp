(function(){
    angular.module('login').directive('logout',LogoutDirective);

    function LogoutDirective(){
        return {
            restrict:'E',
            template: '<div class="col-lg-1 form-group"><button type="button" ng-click="logout()" class="btn btn-danger btn-lg">Logout</button> </div>',
            controller:'loginController'
        };
    };
})();