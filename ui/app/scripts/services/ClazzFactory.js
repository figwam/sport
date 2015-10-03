'use strict';

/*global app: false */

/**
 * The clazz factory.
 */
app.factory('ClazzFactory', function($http) {
  return {
    get: function() {
      return $http.get('/clazzes?p=0&s=1&f=');
    }
  };
});
