(function(){
    angular.module('scheduleApp', ['login', 'register', 'start', 'angular-jwt', 'mainPage','ui.router','pascalprecht.translate','appFooter'])
        .config(AppConfig)
        .run(AppRun);

    function AppConfig($urlRouterProvider, jwtInterceptorProvider, $httpProvider, $stateProvider,$translateProvider) {
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

        $translateProvider.translations('en', {
            TITLE1: 'Ho! Ho! Ho! Merry ',
            TITLE2: 'Christmas ',
            TITLE3: 'any Holiday!',
            SECRETSANTA: 'Secret Santa',
            REGISTER: 'Register',
            GREETING: 'Greetings, master jedi!',
            GREETINGALTER: 'Greetings, master ',
            FIRSTNAME: 'First Name',
            LASTNAME: 'Last Name',
            ENTERFN: 'Enter your first name',
            ENTERLN: 'Enter your last name',
            LOGIN: 'Login',
            CREATELOGIN: 'Create your login',
            ENTERLOGIN: 'Enter your login',
            PASS: 'Password',
            CREATEPASS: 'Create your password',
            ENTERPASS: 'Enter your password',
            REPEATPASS: 'Repeat password',
            REPEATYPASS: 'Repeat your password',
            SIGNIN: 'Sign in',
            BACK: 'Oops, I think, I should go back!',
            AUTHOR: 'Altynbekov Dauren',
            AUTHORSCITY: 'Karaganda city',
            GITHUBLINK: 'Fork this project on GitHub',
            CHANGELANGUAGE: 'Change language'
        });
        $translateProvider.translations('ru', {
            TITLE1: 'Счастливого ',
            TITLE2: 'Нового года',
            TITLE3: 'праздника!',
            SECRETSANTA: 'Тайный Санта',
            REGISTER: 'Регистрация',
            GREETING: 'Приветствую, мастер джедай!',
            GREETINGALTER: 'Приветствую, мастер ',
            FIRSTNAME: 'Имя',
            LASTNAME: 'Фамилия',
            ENTERFN: 'Введите ваше имя',
            ENTERLN: 'Введите вашу фамилию',
            LOGIN: 'Логин',
            CREATELOGIN: 'Создайте свой пароль',
            ENTERLOGIN: 'Введите свой логин',
            PASS: 'Пароль',
            CREATEPASS: 'Создайте свой пароль',
            ENTERPASS: 'Введите свой пароль',
            REPEATPASS: 'Повторите пароль',
            REPEATYPASS: 'Повторите свой пароль',
            SIGNIN: 'Войти',
            BACK: 'Ой! Кажется мне надо назад!',
            AUTHOR: 'Алтынбеков Даурен',
            AUTHORSCITY: 'г. Караганда',
            GITHUBLINK: 'Просмотрите этот проект на GitHub',
            CHANGELANGUAGE: 'Смена языка'

        });
        $translateProvider.preferredLanguage('en');
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
