'use strict';

/*global app: false */

/**
 * The home controller.
 */
app.controller('HomeCtrl', ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {

  // calling our submit function.
  $scope.submitSearchRedirect = function () {
    $rootScope.clazzesSearchString = $scope.searchString
    $location.path('/clazzes');
  };


}]);
