'use strict';

/*global app: false */

/**
 * The clazz controller.
 *
 */
app.controller('DashboardCtrl', ['$rootScope', '$scope', '$state', function($rootScope, $scope, $state) {


  // calling our submit function.
  $scope.submitSearchRedirect = function () {
    $rootScope.clazzesSearchString = $scope.searchString
    $state.go('me.clazzes')
  };

}]);
