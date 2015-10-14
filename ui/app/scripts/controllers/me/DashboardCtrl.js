'use strict';

/*global app: false */

/**
 * The clazz controller.
 *
 */
app.controller('DashboardCtrl', ['$rootScope', '$scope', '$state', '$http', function($rootScope, $scope, $state, $http) {

  getClazzCount();

  // calling our submit function.
  $scope.submitSearchRedirect = function () {
    $rootScope.clazzesSearchString = $scope.searchString
    $state.go('me.clazzes')
  };

  function getClazzCount() {
    $http.get('/clazzesCount')
      .then(function(result) {
        $rootScope.totalClazzes = result.data
      });
  }

}]);
