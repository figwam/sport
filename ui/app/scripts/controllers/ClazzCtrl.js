'use strict';

/*global app: false */

/**
 * The clazz controller.
 */
app.controller('ClazzCtrl', ['$rootScope', '$scope', '$alert', function($rootScope, $scope, $alert, TraineeFactory) {

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
}]);
