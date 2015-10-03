'use strict';

/*global app: false */

/**
 * The clazz controller.
 */
app.controller('ClazzCtrl', ['$rootScope', '$scope', '$alert', '$http', '$location', 'ClazzFactory', function($rootScope, $scope, $alert, $http, $location, ClazzFactory) {

  /**
   * Initializes the controller.
   */
  /*
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
        }); /
      });
  };
  */

  $scope.totalClazzes = 0;
  $scope.clazzesPerPage = 10;
  getResultsPage(1)
  $scope.pagination = {
    current: 1
  };

  $scope.pageChanged = function(newPage) {
    getResultsPage(newPage);
  };

  function getResultsPage(pageNumber) {
    //play start paging from 0 --> (pageNumber-1)
    $http.get('/clazzes?p='+(pageNumber-1)+'&s=1&f='+($scope.searchString == null ? '':$scope.searchString))
      .then(function(result) {
        $rootScope.clazzes = result.data
        $scope.totalClazzes = result.data.total
      });
  }

  // calling our submit function.
  $scope.submitSearch = function () {
    getResultsPage(1);
    $location.path('/clazzes');
  };
}]);



app.filter('searchFor', function(){
  return function(arr, searchString){
    if(!searchString){
      return arr;
    }
    var result = [];
    searchString = searchString.toLowerCase();
    angular.forEach(arr, function(item){
      if(item.searchMeta.toLowerCase().indexOf(searchString) !== -1){
        result.push(item);
      }
    });
    return result;
  };
});
