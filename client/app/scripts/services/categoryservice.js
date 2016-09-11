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

    // $resource nude
    // query - za citanje na site
    // get(id) - za citanje na eden
    // delete(id) za brisenje
    // save(object) za dodavanje ili update (zavisi od toa dali ima id, ako nema id, togaj e dodavanje, ako ima e update

    var apiUrl = 'http://localhost:8088/api/categories/:id';

    return $resource(apiUrl);

  });
