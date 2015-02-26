var scheduleApp = angular.module('scheduleApp', ['login', 'scheduleTable', 'start', 'angular-jwt', 'ui.router']);
var appName = '/AngularFirstApp'
scheduleApp.config(function ($urlRouterProvider, jwtInterceptorProvider, $httpProvider, $stateProvider) {
    $stateProvider.state('schedule', {
        url: '/schedule',
        controller: 'scheduleCtrl',
        templateUrl: appName+'/scheduleTable.html'
    }).state('start', {
        url: '/',
        templateUrl: appName+'/start.html',
        controller: 'carouselCtrl'
    }).state('login', {
            url: '/login',
            templateUrl: appName+'/login.html',
            controller: 'loginController'
        });

    $urlRouterProvider.otherwise('/');

    jwtInterceptorProvider.tokenGetter = function (store) {
        return store.get('jwt');
    };

    $httpProvider.interceptors.push('jwtInterceptor');
});

scheduleApp.controller('appController', function AppCtrl($scope, $location) {
    $scope.$on('$routeChangeSuccess', function (e, nextRoute) {
        if (nextRoute.$$route && angular.isDefined(nextRoute.$$route.pageTitle)) {
            $scope.pageTitle = nextRoute.$$route.pageTitle + ' | Schedule Sample';
        }
    });
});