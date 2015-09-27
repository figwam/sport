'use strict';

/*global app: false */

/**
 * The sign up controller.
 */
app.controller('SignUpCtrl', ['$scope', '$alert', '$auth', function($scope, $alert, $auth) {

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
      $alert({
        content: 'Sie haben sich erfolgreich registriert',
        animation: 'fadeZoomFadeDown',
        type: 'material',
        duration: 3
      });
    }).catch(function(response) {
      $scope.errorMessage = {};
      angular.forEach(response.data.message, function(message, field) {
        console.log(response.data.message);
        // response.data.message -> Message ist trainee.exists
        $scope.form.email.$setValidity('trainee.exists', false);
      });
      /*
      $alert({
        content: response.data.message,
        animation: 'fadeZoomFadeDown',
        type: 'material',
        duration: 3
      });
      */
    });
  };
}]);
