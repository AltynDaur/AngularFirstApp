angular.module('scheduleTable',['ui.router'])
.config(function($stateProvider){
        $stateProvider.state('schedule', {
            url:'/',
            controller:'scheduleCtrl',
            templateUrl:'scheduleTable.html'
        })
    }).controller('scheduleCtrl',function(){

    });