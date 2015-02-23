angular.module('loginPersonService',['ngResource']).factory('LoginPersons',function($resource){
    return $resource('schedule/login:loginPersonId',{});
})