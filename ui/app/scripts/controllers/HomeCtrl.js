'use strict';

/*global app: false */

/**
 * The home controller.
 */
app.controller('HomeCtrl', ['$rootScope', '$scope', '$alert', 'UserFactory', function($rootScope, $scope, $alert, UserFactory) {

  /**
   * Initializes the controller.
   */
  $scope.init = function() {
    UserFactory.get()
      .success(function(data) {
        $rootScope.user = data;
      })
      .error(function(error) {
        /*$alert({ // Dont alert, we dont expect authorized user on home page
          content: error.message,
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });*/
      });
  };
}]);
