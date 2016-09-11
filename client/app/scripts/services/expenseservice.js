'use strict';

/**
 * @ngdoc service
 * @name expenseTrackerApp.expenseService
 * @description
 * # expenseService
 * Service in the expenseTrackerApp.
 */
angular.module('expenseTrackerApp')
  .service('Expense', function ($resource) {
    var apiUrl = 'http://localhost:8088/api/expenses/:id';
    return $resource(apiUrl, { id : '@_id' }, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  });
