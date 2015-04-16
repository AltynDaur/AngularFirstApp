(function(){
    angular.module('myGiftRooms')
        .controller('roomModalController', roomModalController);

    function roomModalController($scope, $modalInstance, room,Rooms){
        $scope.room = room;

        $scope.shuffle = function () {
            Rooms.shuffle(room.id, function(response){
                console.log('Room shuffled');
            });
        };

        $scope.ok = function () {
            $modalInstance.close();
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

})();