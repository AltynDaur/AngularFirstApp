angular.module('registerPersonService',['ngResource']).factory('RegisterPersons',function($resource){
    return $resource('secretSanta/register:registerPersonId',{});
});
angular.module('wishService',['ngResource']).factory('Wishes',function($resource){
    return $resource('secretSanta/wish/:id',{}, {
        delete:{ method:'DELETE',params:{id:'@id'}},
        query: { method: 'GET', isArray: true },
        update:{ method: 'PUT'}
    });
});
angular.module('personService',['ngResource']).factory('Persons',function($resource){
    return $resource('secretSanta/person/:id',{});
});