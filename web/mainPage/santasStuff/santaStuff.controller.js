(function(){
    angular.module('santaStuff',['personService']).controller('SantaController',SantaController);

    function SantaController($scope,Persons,Wishes){
        $scope.refresh = function(){
            $scope.needForGift = Persons.query();
        };
        $scope.refresh();
        $scope.updateAnswer = function(answer, wish){
            wish.santasAnswer = answer;
            Wishes.update(wish,function(response){

            });
        };
    }
})();
