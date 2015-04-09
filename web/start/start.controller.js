(function(){
    angular.module('start')
        .controller('carouselCtrl',function($scope){
            $scope.myInterval = 5000;
            var slides = $scope.slides = [
                {
                    'image':'/AngularFirstApp/resources/images/teacher.jpg',
                    'text':'Santa',
                    'href':'login'
                },
                {
                    'image':'/AngularFirstApp/resources/images/chair.jpg',
                    'text':'Register',
                    'href':'register'
                }
            ];

        });
})();