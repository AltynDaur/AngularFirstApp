angular.module('santaStuff',['personService']).controller('SantaController',function($scope,Persons){
    $scope.refresh = function(){
        $scope.needForGift = Persons.query();
    };
    $scope.refresh();
});