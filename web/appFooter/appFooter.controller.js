(function(){
    angular.module('appFooter').controller('appFooterController',appFooterController);

    function appFooterController($scope, $translate){
        $scope.changeLanguage = function (key) {
            $translate.use(key);
        };
    };

})();