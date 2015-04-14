(function(){
    angular.module('myGiftRooms')
        .controller('roomModalController', roomModalController);

    function roomModalController($scope, $modalInstance, room){
        $scope.room = room;

        $scope.ok = function () {
            $modalInstance.close();
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

})();