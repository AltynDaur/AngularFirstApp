(function(){
    angular.module('wishes').controller('WishesController',WishesController);

    function WishesController($scope,Wishes){
        $scope.refresh = function () {
            $scope.wishes = Wishes.query();
        };

        $scope.errorMessages = '';

        $scope.addWish = function () {
            $scope.errorMessages = '';
            var count = parseInt($scope.wish.count);
            if(typeof count === 'number' && count > 0){
                Wishes.save($scope.wish,function(currentWish){
                    $scope.wishes.push(currentWish);
                    $scope.refresh();
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
        $scope.refresh();
    };

})();