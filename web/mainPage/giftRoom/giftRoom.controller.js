(function(){
    angular.module('giftRoom').controller('roomController', RoomController);

    function RoomController ($scope,Rooms) {
        $scope.refresh = function(){
            $scope.rooms = Rooms.query();
        };

        $scope.addRoom = function () {
            Rooms.save($scope.room,function(result){

            },function(error){

            });
        }
    }
})();
