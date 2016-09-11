'use strict';

/**
 * @ngdoc service
 * @name expenseTrackerApp.exchangeRate
 * @description
 * # exchangeRate
 * Service in the expenseTrackerApp.
 */
angular.module('expenseTrackerApp')
  .service('exchangeRateService', function ($http) {
    // AngularJS will instantiate a singleton by calling "new" on this function
    var service = {};
    var api_url = 'http://localhost:8088/api/exchangeRate/';
    service.getRate = function () {
      return $http.get(api_url+"rate");
    };
    service.refreshRate = function () {
      return $http.post(api_url+"refresh", {});
    };
    return service;
  });
