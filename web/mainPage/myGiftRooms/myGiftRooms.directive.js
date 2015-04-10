(function(){
    angular.module('myGiftRooms').directive('myGiftRooms', MyGiftRoomsDirective);

    function MyGiftRoomsDirective(){
        return {
            restrict:'E',
            templateUrl:'/AngularFirstApp/mainPage/myGiftRooms/myGiftRooms.template.html',
            controller:'myGiftRoomsController'
        };
    };
})();