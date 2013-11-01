'use strict';

angular.module('personServices', ['ngResource'])
  .factory('messageList', function ($resource) {
    return $resource('rest/message/', {}, {
      query: {method: 'GET', isArray: true}
    })
  }).factory('Message', function ($resource) {
    return $resource('rest/message/:id', {}, {
  })
});