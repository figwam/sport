'use strict';

/*global app: false */

/**
 * The sign up controller.
 */
app.controller('SignUpCtrl', ['$scope', '$auth', '$location', function($scope, $auth, $location) {

  /**
   * The submit method.
   */
  $scope.submit = function() {
    $auth.signup({
      firstname: $scope.firstname,
      lastname: $scope.lastname,
      street: $scope.street,
      plz: $scope.plz,
      zip: $scope.zip,
      city: $scope.city,
      state: $scope.state,
      email: $scope.email,
      password: $scope.password
    }).then(function() {
      /*DO AUTOLOGIN AFTER SIGN UP*/
      $auth.login({ email: $scope.email, password: $scope.password, rememberMe: true })
        .then(function() {
          $location.path("/me")
        })
    }).catch(function(response) {
      $scope.errorMessage = {};
      angular.forEach(response.data.message, function(message, field) {
        console.log(response.data.message);
        // response.data.message -> Message ist trainee.exists
        $scope.form.email.$setValidity('trainee.exists', false);
      });
    });
  };
}]);
