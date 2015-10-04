'use strict';

/*global app: false */

/**
 * The navigation controller.
 */
app.controller('HeaderCtrl', ['$scope', '$auth', '$location', '$anchorScroll', function($scope, $auth, $location, $anchorScroll) {

  /**
   * Indicates if the trainee is authenticated or not.
   *
   * @returns {boolean} True if the trainee is authenticated, false otherwise.
   */
  $scope.isAuthenticated = function() {
    return $auth.isAuthenticated();
  };


  $scope.scrollTo = function(id) {
    $location.hash(id);
    $anchorScroll();
  };

}]);
