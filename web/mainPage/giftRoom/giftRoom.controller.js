(function(){
    angular.module('giftRoom').controller('roomController', RoomController);

    function RoomController ($scope,Rooms) {
        refresh = function(){
            $scope.rooms = Rooms.query();
        };

        $scope.enterRoom = function(roomId){
            Rooms.update(roomId,function(result){

            });
        };
        refresh();
    }
})();
