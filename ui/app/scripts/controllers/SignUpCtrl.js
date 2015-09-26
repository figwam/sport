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
      $alert({
        content: response.data.message,
        animation: 'fadeZoomFadeDown',
        type: 'material',
        duration: 3
      });
    });
  };
}]);
