angular.module('registerPersonService',['ngResource']).factory('RegisterPersons',function($resource){
    return $resource('schedule/register:registerPersonId',{});
})