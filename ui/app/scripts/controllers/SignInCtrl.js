'use strict';

/*global app: false */

/**
 * The sign in controller.
 */
app.controller('SignInCtrl', ['$scope', '$alert', '$auth', function($scope, $alert, $auth) {

  /**
   * Submits the login form.
   */

  $scope.submit = function() {
    $auth.setStorage($scope.rememberMe ? 'localStorage' : 'sessionStorage');
    $auth.login({ email: $scope.email, password: $scope.password, rememberMe: $scope.rememberMe })
      .then(function() {
        $alert({
          content: 'Sie haben sich erfolgreich eingeloggt',
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });
      })
      .catch(function(response) {
        $scope.errorMessage = {};
        angular.forEach(response.data.message, function(message, field) {
          console.log(response.data.message);
          // response.data.message -> Message ist invalid.credentials
          $scope.form.email.$setValidity('invalid.credentials', false);
          $scope.form.password.$setValidity('invalid.credentials', false);
        });
      });
  };

  /*
  $scope.submit = function() {
    $auth.setStorage($scope.rememberMe ? 'localStorage' : 'sessionStorage');
    $auth.login({ email: $scope.email, password: $scope.password, rememberMe: $scope.rememberMe })
      .then(function() {
        $alert({
          content: 'Sie haben sich erfolgreich eingeloggt',
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });
      })
      .catch(function(response) {
        console.log(response);
        $alert({
          content: response.data.message,
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });
      });
  };
  */

  /**
   * Authenticate with a social provider.
   *
   * @param provider The name of the provider to authenticate.
   */
  $scope.authenticate = function(provider) {
    $auth.authenticate(provider)
      .then(function() {
        $alert({
          content: 'Sie haben sich erfolgreich eingeloggt',
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });
      })
      .catch(function(response) {
        $alert({
          content: response.data.message,
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });
      });
  };
}]);
