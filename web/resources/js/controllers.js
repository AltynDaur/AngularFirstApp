var scheduleControllers = angular.module('scheduleControllers',['ui.bootstrap']);

scheduleControllers.controller('loginController',function($scope,$http){
    var loginPerson = new LoginPerson($scope.login,$scope.password);
    console.log(loginPerson);
    $scope.person =  function(loginPerson){
        $http({
            method:'POST',
            url:'/AngularFirstApp/schedule/login',
            body: loginPerson,
            cache:true
        }).success(callback);
        return callback;
    }

    console.log($scope.person);
    if(!$scope.person){
        $cookieStore.put('user',$scope.person);
        console.log($cookieStore.get('user'));
    }
});
scheduleControllers.controller('carouselCtrl',function($scope){
    $scope.myInterval = 5000;
    var slides = $scope.slides = [{
        image: 'http://localhost:8080/AngularFirstApp/resources/images/student.jpg',
        text: 'Student',
        href: 'scheduleTable.html'
    },
        {
            image: 'http://localhost:8080/AngularFirstApp/resources/images/teacher.jpg',
            text: 'Teacher',
            href:'/AngularFirstApp/#/login'
        },
        {
            image: 'http://localhost:8080/AngularFirstApp/resources/images/chair.jpg',
            text: 'Chair',
            href: '/AngularFirstApp/#/login'
        }
    ];

});