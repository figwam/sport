'use strict';

/*global app: false */

/**
 * The home controller.
 */
app.controller('HomeCtrl', ['$rootScope', '$scope', '$alert', '$http', '$location','TraineeFactory', function($rootScope, $scope, $alert, $http, $location, TraineeFactory) {

  /**
   * Initializes the controller.
   */
  $scope.init = function() {
    TraineeFactory.get()
      .success(function(data) {
        $rootScope.trainee = data;
      })
      .error(function(error) {
        /*$alert({ // Dont alert, we dont expect authorized trainee on home page
          content: error.message,
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });*/
      });
  };

  // calling our submit function.
  $scope.submitSearchRedirect = function () {
    $rootScope.clazzesSearchString = $scope.searchString
    $location.path('/clazzes');
  };


}]);
