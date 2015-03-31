angular.module('wishes',['wishService']).controller('WishesController',function($scope,Wishes){
    $scope.wishes=Wishes.query;
    $scope.errorMessages = '';

    $scope.addWish = function () {
        $scope.errorMessages = ''
        var count = parseInt($scope.wish.count)
        if(typeof count === 'number' && count > 0){

            Wishes.save($scope.wishes,function(response){
                console.log('All OK')
            }),function(error){
                $scope.errorMessages = [ 'Unknown  server error' ];
            };
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