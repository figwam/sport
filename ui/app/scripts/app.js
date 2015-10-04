'use strict';

/**
 * The application.
 */
var app = angular.module('uiApp', [
  'ngResource',
  'ngMessages',
  'ngCookies',
  'ui.router',
  'mgcrea.ngStrap',
  'satellizer',
  'validation.match',
  'angularUtils.directives.dirPagination'
]);

/**
 * The run configuration.
 */
app.run(function($state,$rootScope) {

  /**
   * The trainee data.
   *
   * @type {{}}
   */
  $rootScope.trainee = {};
  $rootScope.clazzes = {};
  $rootScope.clazzesSearchString = '';
  $rootScope.$state = $state;

});

/**
 * The application routing.
 */
app.config(function ($urlRouterProvider, $stateProvider, $httpProvider, $authProvider, $compileProvider ) {


/*
   //http://stackoverflow.com/questions/22754393/in-a-chrome-app-using-angularjs-can-i-use-the-ngsrc-directive-directly-for-inte

    var currentImgSrcSanitizationWhitelist = $compileProvider.imgSrcSanitizationWhitelist();

    var newImgSrcSanitizationWhiteList = currentImgSrcSanitizationWhitelist.toString().slice(0,-1)+'|filesystem:chrome-extension:'+'|blob:chrome-extension%3A'+currentImgSrcSanitizationWhitelist.toString().slice(-1);

    console.log("Changing imgSrcSanitizationWhiteList from "+currentImgSrcSanitizationWhitelist+" to "+newImgSrcSanitizationWhiteList);
  //$compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|chrome-extension):/);
  $compileProvider.imgSrcSanitizationWhitelist(newImgSrcSanitizationWhiteList);
*/

  $urlRouterProvider
    .otherwise('/');

  $stateProvider
    .state('index', {url:'/index',
      views: {
        'header': {
          templateUrl: '/views/header.html'
        },
        'content': {
          templateUrl: '/views/home.html',
          controller: 'ClazzCtrl'
        },
        'footer': {
          templateUrl: '/views/footer.html'
        }
      }})
    .state('home', {url:'/',
      views: {
        'header': {
          templateUrl: '/views/header.html'
        },
        'content': {
          templateUrl: '/views/home.html',
          controller: 'HomeCtrl'
        },
        'footer': {
          templateUrl: '/views/footer.html'
        }
      }})
    .state('home.signUp', {url:'signUp',
      views: {
        'content@': {
          templateUrl: '/views/signUp.html',
          controller: 'SignUpCtrl'
        }
      }})
    .state('home.signIn', {url:'signIn',
      views: {
        'content@': {
          templateUrl: '/views/signIn.html',
          controller: 'SignInCtrl'
        }
      }})
    .state('home.signOut', { url:'signOut',
      views: {
        'content@': {
          templateUrl: '/views/home.html',
          controller: 'SignOutCtrl'
        }
      }})
    .state('home.clazzes', { url: 'clazzes',
      views: {
        'content@': {
          templateUrl: '/views/clazzes.html',
          controller: 'ClazzCtrl'
        }
      }})
    .state('trainee', { url: '/trainee',
      views: {
        'header': {
          templateUrl: '/views/header.html'
        },
        'content': {
          templateUrl: '/views/me/dashboard.html',
          controller: 'ClazzCtrl'
        },
        'footer': {
          templateUrl: '/views/footer.html'
        }
      }})


  //http://www.webdeveasy.com/interceptors-in-angularjs-and-useful-examples/
  $httpProvider.interceptors.push(function($q, $injector) {
    return {
      request: function(request) {
        // Add auth token for Silhouette if trainee is authenticated
        var $auth = $injector.get('$auth');
        if ($auth.isAuthenticated()) {
          request.headers['X-Auth-Token'] = $auth.getToken();
        }

        // Add CSRF token for the Play CSRF filter
        var cookies = $injector.get('$cookies');
        var token = cookies.get('PLAY_CSRF_TOKEN');
        if (token) {
          // Play looks for a token with the name Csrf-Token
          // https://www.playframework.com/documentation/2.4.x/ScalaCsrf
          request.headers['Csrf-Token'] = token;
        }

        return request;
      }
      /*
      ,

      responseError: function(rejection) {
        if (rejection.status === 401) {
          $injector.get('$state').go('home');// usually signIn
        }
        return $q.reject(rejection);
      }
      */
    };
  });

  // Auth config
  $authProvider.httpInterceptor = true; // Add Authorization header to HTTP request
  $authProvider.loginOnSignup = true;
  $authProvider.loginRedirect = '/trainee';
  $authProvider.logoutRedirect = '/';
  $authProvider.signupRedirect = '/signIn';
  $authProvider.loginUrl = '/signIn';
  $authProvider.signupUrl = '/signUp';
  $authProvider.loginRoute = '/signIn';
  $authProvider.signupRoute = '/signUp';
  $authProvider.tokenName = 'token';
  $authProvider.tokenPrefix = 'satellizer'; // Local Storage name prefix
  $authProvider.authHeader = 'X-Auth-Token';
  $authProvider.platform = 'browser';
  $authProvider.storage = 'localStorage';

  // Facebook
  $authProvider.facebook({
    clientId: '1503078423241610',
    url: '/authenticate/facebook',
    scope: 'email',
    scopeDelimiter: ',',
    requiredUrlParams: ['display', 'scope'],
    display: 'popup',
    type: '2.0',
    popupOptions: { width: 481, height: 269 }
  });

  // Google
  $authProvider.google({
    clientId: '526391676642-nbnoavs078shhti3ruk8jhl4nenv0g04.apps.googleusercontent.com',
    url: '/authenticate/google',
    scope: ['profile', 'email'],
    scopePrefix: 'openid',
    scopeDelimiter: ' ',
    requiredUrlParams: ['scope'],
    optionalUrlParams: ['display'],
    display: 'popup',
    type: '2.0',
    popupOptions: { width: 580, height: 400 }
  });

  // VK
  $authProvider.oauth2({
    clientId: '4782746',
    url: '/authenticate/vk',
    authorizationEndpoint: 'http://oauth.vk.com/authorize',
    name: 'vk',
    scope: 'email',
    scopeDelimiter: ' ',
    requiredUrlParams: ['display', 'scope'],
    display: 'popup',
    popupOptions: { width: 495, height: 400 }
  });

  // Twitter
  $authProvider.twitter({
    url: '/authenticate/twitter',
    type: '1.0',
    popupOptions: { width: 495, height: 645 }
  });

  // Xing
  $authProvider.oauth1({
    url: '/authenticate/xing',
    name: 'xing',
    popupOptions: { width: 495, height: 500 }
  });
});


