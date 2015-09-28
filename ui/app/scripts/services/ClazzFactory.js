'use strict';

/*global app: false */

/**
 * The clazz factory.
 */
app.factory('ClazzFactory', function($http) {
  return {
    get: function() {
      return $http.get('/clazzes');
    }
  };
});
