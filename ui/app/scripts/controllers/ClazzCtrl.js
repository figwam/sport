'use strict';

/*global app: false */

/**
 * The clazz controller.
 */
app.controller('ClazzCtrl', ['$rootScope', '$scope', '$alert', 'ClazzFactory', function($rootScope, $scope, $alert, ClazzFactory) {

  /**
   * Initializes the controller.
   */
  $scope.init = function() {
    ClazzFactory.get()
      .success(function(data) {
        $rootScope.clazzes = data;
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
