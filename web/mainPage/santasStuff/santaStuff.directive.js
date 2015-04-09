(function(){
    angular.module('santaStuff')
        .directive('santaStuff', SantaStuffDirective);

    function SantaStuffDirective(){
        return {
            restrict: 'E',
            templateUrl: '/AngularFirstApp/mainPage/santasStuff/santaStuff.template.html',
            controller:'SantaController'
        };
    };
})();