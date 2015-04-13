(function(){
    angular.module('giftRoom').controller('roomController', RoomController);

    function RoomController ($scope,Rooms,$rootScope) {
        refresh = function(){
            $scope.rooms = Rooms.query();
        };

        $scope.enterRoom = function(roomId){
            Rooms.update(roomId,function(result){
                console.log('You added yourself to room '+roomId);
                $rootScope.$broadcast('roomsDataChanged',true);
            });
        };
        $rootScope.$on('roomsDataChanged',function(event,data){
            refresh();
        });
        refresh();
    }
})();
