(function(){
    angular.module('myGiftRooms')
        .controller('roomModalController', roomModalController);

    function roomModalController($scope, $modalInstance, room,Rooms,$rootScope){
        $scope.room = room;

        $scope.shuffle = function () {
            Rooms.shuffle({id:room.id}, function(response){
                console.log('Room shuffled');
                $rootScope.$emit('roomShuffled');
            });
        };

        $scope.removePerson = function(personId){
            Rooms.removePerson({id:room.id, personId:personId},function(response){
                console.log('User '+ currentUserID+'deleted from room #'+room.id);
            })
        };

        $scope.leaveRoom = function(){
            Rooms.removePerson({id:room.id, personId:currentUserID},function(response){
                console.log('User '+ currentUserID+'deleted from room #'+room.id);
            })
        };

        $scope.ok = function () {
            $modalInstance.close();
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

})();