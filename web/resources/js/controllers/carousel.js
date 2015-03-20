angular.module('start',['ui.bootstrap','ui.router'])
    .controller('carouselCtrl',function($scope){
    $scope.myInterval = 5000;
    var slides = $scope.slides = [{
        image: '/AngularFirstApp/resources/images/student.jpg',
        text: 'Child',
        href: '/AngularFirstApp/#/login'
        },
        {
            image: '/AngularFirstApp/resources/images/teacher.jpg',
            text: 'Santa',
            href:'/AngularFirstApp/#/login'
        },
        {
            image: '/AngularFirstApp/resources/images/chair.jpg',
            text: 'Register',
            href: '/AngularFirstApp/#/register'
        }
    ];

});