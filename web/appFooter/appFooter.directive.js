(function(){
    angular.module('appFooter').directive('appFooter',appFooterDirective);

    function appFooterDirective(){
        return {
            restrict: 'E',
            controller: 'appFooterController',
            templateUrl:'/AngularFirstApp/appFooter/appFooter.template.html'
        };
    };

})();