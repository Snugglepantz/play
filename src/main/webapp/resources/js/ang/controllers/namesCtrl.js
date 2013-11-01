'use strict';
namesmvc.controller('NamesCtrl', function NamesCtrl($scope, SyncSocket, Person, PersonList, $http) {

  $scope.name = "";
  $scope.city = "";
  $scope.state = "";
  $scope.data = PersonList.query();

  $scope.addPerson = function() {
    var person = {
      id: 0,
      name: $scope.name,
      city: $scope.city,
      state: $scope.state
    };
    person = Person.save(person);
    SyncSocket.update();
    $scope.data.push(person);
    $scope.name = "";
    $scope.city = "";
    $scope.state = "";
  }
  $scope.removeName = function(person) {
    Person.delete({id: person.customerId});
    SyncSocket.update();
    $scope.data.splice($scope.data.indexOf(person), 1);
  }

  SyncSocket.refresh = function() {
    $scope.data = PersonList.query();
  }
  SyncSocket.init();
});
