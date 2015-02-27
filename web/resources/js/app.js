var scheduleApp = angular.module('scheduleApp', ['login', 'scheduleTable', 'start', 'angular-jwt', 'ui.router']);
var appName = '/AngularFirstApp'
scheduleApp.config(function ($urlRouterProvider, jwtInterceptorProvider, $httpProvider, $stateProvider) {
    $stateProvider.state('publicSchedule', {
        url: '/publicSchedule',
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
    }).state('adminScheduleTable',{
        url:'/admin/scheduleTable',
        templateUrl:appName+'/private/adminScheduleTable.html',
        data:{
            requiresLogin:true
        }
    });

    $urlRouterProvider.otherwise('/');

    jwtInterceptorProvider.tokenGetter = function (store) {
        return store.get('jwt');
    };

    $httpProvider.interceptors.push('jwtInterceptor');
})
    .run(function($state,store,$rootScope){
    $rootScope.$on('stateChangeStart',function(e,to){
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