(function(){
    angular.module('myGiftRooms')
        .controller('myGiftRoomsController',myGiftRoomsController);

    function myGiftRoomsController($scope,Rooms,$rootScope,$modal,$log){

        refreshMyRooms = function (){
            $scope.myRooms = Rooms.myRooms();
        };

        $scope.addRoom = function () {
            Rooms.save($scope.room,function(result){
                $scope.room = {};
                $rootScope.$broadcast('roomsDataChanged',true);
                $scope.errorMessages = {}
                }
            ,function(error){
                $scope.errorMessages = error;
            });
        };

        $scope.open = function (room) {

            var modalInstance = $modal.open({
                templateUrl: 'mainPage/myGiftRooms/roomModal.template.html',
                controller: 'roomModalController',
                size: 'lg',
                resolve: {
                    room: function(){
                        return room;
                    }
                }
            });

            modalInstance.result.then(function () {

            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };


        $rootScope.$on('roomsDataChanged',function(event,data){
            refreshMyRooms();
        });

        refreshMyRooms();
    };
})();