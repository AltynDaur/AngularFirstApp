angular.module('wishesList',['wishes','santaStuff']).controller('MainPageController',function($scope){
    $scope.checkSantaAnswer = function(answer){
        if(answer === 1){
            return true;
        } else if (answer === -1){
            return false;
        } else
            return 0;
    };
});