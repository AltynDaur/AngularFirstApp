var scheduleApp = angular.module('scheduleApp',['login','scheduleTable','angular-jwt']);

scheduleApp.config(function($urlRouterProvider, jwtInterceptorProvider, $httpProvider){
    $urlRouterProvider.otherwise('/');

    jwtInterceptorProvider.tokenGetter = function(store){
        return store.get('jwt');
    };

    $httpProvider.interceptors.push('jwtInterceptor');
});

scheduleApp.controller('appController',function AppCtrl($scope,$location){
    $scope.$on('$routeChangeSuccess', function(e, nextRoute){
        if ( nextRoute.$$route && angular.isDefined( nextRoute.$$route.pageTitle ) ) {
            $scope.pageTitle = nextRoute.$$route.pageTitle + ' | Schedule Sample' ;
        }
    });
});