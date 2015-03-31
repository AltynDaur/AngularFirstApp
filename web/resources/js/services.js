angular.module('registerPersonService',['ngResource']).factory('RegisterPersons',function($resource){
    return $resource('schedule/register:registerPersonId',{});
});
angular.module('wishService',['ngResource']).factory('Wishes',function($resource){
    return $resource('schedule/wish:personId',{});
});