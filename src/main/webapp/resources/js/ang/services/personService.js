'use strict';

angular.module('personServices', ['ngResource'])
  .factory('SyncSocket', function () {          
    return {
      init : function () {
        var self = this;
        this.websocket = new WebSocket('ws://' + document.location.host + '/Play/person/sync');

        this.websocket.onopen = function (event) {
          console.log("connected");
        }
        this.websocket.onmessage = function (event) {
          console.log("message " + event.data);
          self.refresh();
        }
        this.websocket.onerror = function (evt) {
          console.error("error");
        }
      },
      update : function () {
        this.send();
      },
      send : function () {
        this.websocket.send("update");
      }
    }
  }).factory('PersonList', function ($resource) {
    return $resource('rest/customer/', {}, {
      query: {method: 'GET', isArray: true}
    })
  }).factory('Person', function ($resource) {
    return $resource('rest/customer/:id', {}, {
  })
});