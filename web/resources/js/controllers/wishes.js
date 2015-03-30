angular.module('wishes',[]).controller('WishesController',function($scope){
    $scope.wishes=[];
    $scope.errorMessages = '';

    $scope.addWish = function () {
        if(typeof $scope.wish.count === 'number'){
            $scope.wishes.push({
                id:$scope.wishes.length,
                want:$scope.wish.want,
                count:$scope.wish.count
            });
            $scope.wish = {}
        } else {
            $scope.errorMessages = ['Count should be a number!']
        }

    };
    $scope.deleteWish = function(wishId){
        for(var i = 0; i<$scope.wishes.length; i++ ){
            if($scope.wishes[i].id === wishId){
                $scope.wishes.splice(i,1);
            }
        };
    }
});