'use strict';

/*global app: false */

/**
 * The sign up controller.
 */
app.controller('SignUpCtrl', ['$scope', '$auth', '$location', '$state', function($scope, $auth, $location, $state) {

  /**
   * The submit method.
   */
  $scope.submit = function() {
    $auth.signup({
      firstname: $scope.formData.firstname,
      lastname: $scope.formData.lastname,
      street: $scope.formData.street,
      plz: $scope.formData.plz,
      zip: $scope.formData.zip,
      city: $scope.formData.city,
      state: "None",
      email: $scope.formData.email,
      password: $scope.formData.password
    }).then(function() {
      /*DO AUTOLOGIN AFTER SIGN UP*/
      $auth.login({ email: $scope.formData.email, password: $scope.formData.password, rememberMe: true })
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

  // calling our submit function.
  $scope.submitOfferRedirect = function (selectedOfferName, selectedOfferId) {
    $scope.formData.aboId = selectedOfferId
    $scope.formData.aboName = selectedOfferName
    $location.hash('home');
    $anchorScroll();
    $state.go('home.signUp.profile')
  };


}]);
