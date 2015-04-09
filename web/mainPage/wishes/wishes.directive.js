(function(){
    angular.module('wishes')
        .directive('wishes',WishesDirective);

    function WishesDirective(){
        return {
            restrict: 'E',
            templateUrl:'/AngularFirstApp/mainPage/wishes/wishes.template.html',
            controller:'WishesController'
        };
    };
})();