// Register `userList` component, along with its associated controller and template
angular.
  module('userList').
  component('userList', {
    templateUrl:  'user-list/user-list.template.html',
    controller: ['$http', function UserListController($http) {
      var self = this;

      $http.get('users/users.json').then(function(response) {
        self.users = response.data;
      });
    }]
  });