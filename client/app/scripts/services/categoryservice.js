'use strict';

/**
 * @ngdoc service
 * @name expenseTrackerApp.categoryService
 * @description
 * # categoryService
 * Service in the expenseTrackerApp.
 */
angular.module('expenseTrackerApp')
  .service('Category', function ($resource) {
    // AngularJS will instantiate a singleton by calling "new" on this function
    // $resource nudi: query, get(id), delete(id), save(object)
    var apiUrl = 'http://localhost:8088/api/categories/:id';

    return $resource(apiUrl);
  });
