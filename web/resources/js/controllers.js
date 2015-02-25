var scheduleControllers = angular.module('scheduleControllers',['ui.bootstrap']);

scheduleControllers.controller('loginController',function($scope,$http,$cookieStore,LoginPersons){
    $scope.reset = function() {
        $scope.loginPerson = {};
    };
    $scope.login = function(){
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};
        LoginPersons.save($scope.loginPerson, function(data){
            $scope.successMessages = ['Person logged in'];
            $scope.reset();
        },function(result){
            if((result.status == 409) || (result.status == 400)){
                $scope.errors = result.data;
            } else{
                $scope.errorMessages = ['Unknown error'];
            }
            $cookieStore.user = result.data;
            $location.path('/scheduleTable.html');
        });
    }

});
scheduleControllers.controller('carouselCtrl',function($scope){
    $scope.myInterval = 5000;
    var slides = $scope.slides = [{
        image: '/AngularFirstApp/resources/images/student.jpg',
        text: 'Student',
        href: 'scheduleTable.html'
    },
        {
            image: '/AngularFirstApp/resources/images/teacher.jpg',
            text: 'Teacher',
            href:'/AngularFirstApp/#/login'
        },
        {
            image: '/AngularFirstApp/resources/images/chair.jpg',
            text: 'Chair',
            href: '/AngularFirstApp/#/login'
        }
    ];

});