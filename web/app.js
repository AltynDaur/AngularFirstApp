(function(){
    angular.module('scheduleApp', ['login', 'register', 'start', 'angular-jwt', 'mainPage','ui.router'])
        .config(AppConfig)
        .run(AppRun);

    function AppConfig($urlRouterProvider, jwtInterceptorProvider, $httpProvider, $stateProvider) {
        var appName = '/AngularFirstApp';
        $stateProvider.state('register', {
            url: '/register',
            controller: 'RegisterController',
            templateUrl: appName+'/register/register.html'
        }).state('start', {
            url: '/',
            templateUrl: appName+'/start/start.html',
            controller: 'carouselCtrl'
        }).state('login', {
            url: '/login',
            templateUrl: appName+'/login/login.html',
            controller: 'loginController'
        }).state('wishesList',{
            url:'/admin/wishesList',
            templateUrl:appName+'/mainPage/wishesList.html',
            data:{
                requiresLogin:true
            }
        });
        $urlRouterProvider.otherwise('/');

        jwtInterceptorProvider.tokenGetter = function (store) {
            return store.get('jwt');
        };

        $httpProvider.interceptors.push('jwtInterceptor');
    };
    function AppRun($state,store,$rootScope){
        $rootScope.$on('$stateChangeStart',function(e,to){
            if(to.data && to.data.requiresLogin){
                if(!store.get('jwt')){
                    e.preventDefault();
                    $state.go('login');
                };
            }
        })
    };

})();
