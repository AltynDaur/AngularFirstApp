(function(){
    angular.module('myGiftRooms')
        .controller('myGiftRoomsController',myGiftRoomsController);

    function myGiftRoomsController($scope,Rooms){
        refresh = function (){
            $scope.myRooms = Rooms.myRooms();
        };
        $scope.addRoom = function () {
            Rooms.save($scope.room,function(result){
                console.log('Room added');
                refresh();
                $scope.room = {}
            },function(error){
                $scope.errorMessages = error;
            });
        };

        $scope.checkRoom = function(roomId){

        };
        refresh();
    };
})();