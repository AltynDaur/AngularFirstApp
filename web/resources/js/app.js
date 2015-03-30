var scheduleApp = angular.module('scheduleApp', ['login', 'register', 'start', 'angular-jwt', 'wishesList','ui.router']);
var appName = '/AngularFirstApp';
scheduleApp.config(function ($urlRouterProvider, jwtInterceptorProvider, $httpProvider, $stateProvider) {
    $stateProvider.state('schedule', {
        url: '/register',
        controller: 'RegisterController',
        templateUrl: appName+'/register.html'
    }).state('start', {
        url: '/',
        templateUrl: appName+'/start.html',
        controller: 'carouselCtrl'
    }).state('login', {
        url: '/login',
        templateUrl: appName+'/login.html',
        controller: 'loginController'
    }).state('wishesList',{
        url:'/admin/wishesList',
        templateUrl:appName+'/private/wishesList.html',
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