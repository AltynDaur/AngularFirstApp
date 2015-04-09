(function(){
    angular.module('giftRoom').directive('giftRoom',giftRoomDirective);

    function giftRoomDirective(){
        return {
            restrict:'E',
            templateUrl:'/AngularFirstApp/mainPage/giftRoom/giftRoom.template.html',
            controller:'roomController'
      };
    };
})();