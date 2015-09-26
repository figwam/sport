'use strict';

/*global app: false */

/**
 * The sign out controller.
 */
app.controller('SignOutCtrl', ['$auth', '$alert', function($auth, $alert) {
  if (!$auth.isAuthenticated()) {
    return;
  }
  $auth.logout()
    .then(function() {
      $alert({
        content: 'Sie haben sich ausgeloggt',
        animation: 'fadeZoomFadeDown',
        type: 'material',
        duration: 3
      });
    });
}]);
