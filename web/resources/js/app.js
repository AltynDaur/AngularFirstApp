var scheduleApp = angular.module('scheduleApp', ['login', 'publicSchedule', 'start', 'angular-jwt', 'ui.router','restangular']);
var appName = '/AngularFirstApp';
scheduleApp.config(function ($urlRouterProvider, jwtInterceptorProvider, $httpProvider, $stateProvider, RestangularProvider) {
    $stateProvider.state('schedule', {
        url: '/publicSchedule',
        controller: 'publicScheduleController',
        templateUrl: appName+'/scheduleTable.html'
    }).state('start', {
        url: '/',
        templateUrl: appName+'/start.html',
        controller: 'carouselCtrl'
    }).state('login', {
        url: '/login',
        templateUrl: appName+'/login.html',
        controller: 'loginController'
    }).state('adminScheduleTable',{
        url:'/admin/scheduleTable',
        templateUrl:appName+'/private/adminScheduleTable.html',
        data:{
            requiresLogin:true
        }
    });

    RestangularProvider.setBaseUrl('/schedule/resources');

    $urlRouterProvider.otherwise('/');

    jwtInterceptorProvider.tokenGetter = function (store) {
        return store.get('jwt');
    };

    $httpProvider.interceptors.push('jwtInterceptor');
})
    .run(function($state,store,$rootScope){
    $rootScope.$on('$stateChangeStart',function(e,to){
        if(to.data && to.data.requiresLogin){
            if(!store.get('jwt')){
                e.preventDefault();
                $state.go('login');
            };
        }
    })
});

scheduleApp.controller('appController', function AppCtrl($scope, $location) {

});