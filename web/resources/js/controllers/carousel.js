angular.module('start',['ui.bootstrap','ui.router'])
    .controller('carouselCtrl',function($scope){
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