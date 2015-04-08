angular.module('santaStuff',['personService','wishService']).controller('SantaController',function($scope,Persons,Wishes){
    $scope.refresh = function(){
        $scope.needForGift = Persons.query();
    };
    $scope.refresh();
    $scope.updateAnswer = function(answer, wish){
        wish.santasAnswer = answer;
        Wishes.update(wish,function(response){

        });
    };
});