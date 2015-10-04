/**
 * Alerts Controller
 */

app.controller('AlertsCtrl', ['$scope', AlertsCtrl]);

function AlertsCtrl($scope) {

  /* Example of adding alerts to scope */
  /*
  $scope.alerts = [{
    type: 'success',
    msg: 'Something good happened and I want to tell it to user'
  }, {
    type: 'danger',
    msg: 'Something really bad happened and I want to tell it to user'
  }];
  */

  $scope.addAlert = function() {
    $scope.alerts.push({
      msg: 'Another alert!'
    });
  };

  $scope.closeAlert = function(index) {
    $scope.alerts.splice(index, 1);
  };
}
