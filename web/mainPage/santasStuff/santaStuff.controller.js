(function(){
    angular.module('santaStuff',['personService']).controller('SantaController',SantaController);

    function SantaController($scope,Persons,Wishes){
        refresh = function(){
            $scope.needForGift = Persons.query();
        };

        $scope.updateAnswer = function(answer, wish){
            wish.santasAnswer = answer;
            Wishes.update(wish,function(response){

            });
        };
        refresh();
    }
})();
