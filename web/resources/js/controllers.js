var scheduleControllers = angular.module('scheduleControllers',['ui.bootstrap']);

scheduleControllers.controller('loginController',function($scope,$http){

});
scheduleControllers.controller('carouselCtrl',function($scope){
    $scope.myInterval = 5000;
    var slides = $scope.slides = [{
        image: 'http://localhost:8080/AngularFirstApp_war_exploded/resources/images/student.jpg',
        text: 'Student',
        href: 'scheduleTable.html'
    },
        {
            image: 'http://localhost:8080/AngularFirstApp_war_exploded/resources/images/teacher.jpg',
            text: 'Teacher',
            href:'login.html'
        },
        {
            image: 'http://localhost:8080/AngularFirstApp_war_exploded/resources/images/chair.jpg',
            text: 'Chair',
            href: 'login.html'
        }
    ];

});