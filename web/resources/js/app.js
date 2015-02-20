var scheduleApp = angular.module('scheduleApp',['ngRoute','scheduleControllers']);

scheduleApp.config(function($routeProvider){
    $routeProvider.
        when('/',{
            templateUrl:'start.html',
            controller:'carouselCtrl'
        }).
        when('/login',{
            templateUrl:'login.html'
        });
});