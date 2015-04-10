(function(){
    angular.module('wishes').controller('WishesController',WishesController);

    function WishesController($scope,Wishes){
        refresh = function () {
            $scope.wishes = Wishes.query();
        };

        $scope.addWish = function () {
            var count = parseInt($scope.wish.count);
            if(typeof count === 'number' && count > 0){
                Wishes.save($scope.wish,function(currentWish){
                    $scope.wishes.push(currentWish);
                    refresh();
                    console.log(currentWish);
                }),function(error){
                    $scope.errorMessages = [ 'Unknown  server error' ];
                };
                $scope.wish = {};
            } else {
                $scope.errorMessages = ['Count should be a number!']
            };
        };

        $scope.deleteWish = function(wishId,index){
            Wishes.delete({id:wishId},function(response){
                $scope.wishes.splice(index,1);
                console.log(wishId+' successfully deleted');
            });
        };
        refresh();
    };

})();