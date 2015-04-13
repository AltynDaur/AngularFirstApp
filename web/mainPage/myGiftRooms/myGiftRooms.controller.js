(function(){
    angular.module('myGiftRooms')
        .controller('myGiftRoomsController',myGiftRoomsController);

    function myGiftRoomsController($scope,Rooms,$rootScope){
        refreshMyRooms = function (){
            $scope.myRooms = Rooms.myRooms();
        };
        $scope.addRoom = function () {
            Rooms.save($scope.room,function(result){
                $scope.room = {};
                $rootScope.$broadcast('roomsDataChanged',true);
                $scope.errorMessages = {}}
            ,function(error){
                $scope.errorMessages = error;
            });
        };

        $scope.checkRoom = function(roomId){

        };
        $rootScope.$on('roomsDataChanged',function(event,data){
            refreshMyRooms();
        });
        refreshMyRooms();
    };
})();