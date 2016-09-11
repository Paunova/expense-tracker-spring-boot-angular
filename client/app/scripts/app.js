'use strict';

/**
 * @ngdoc overview
 * @name expenseTrackerApp
 * @description
 * # expenseTrackerApp
 *
 * Main module of the application.
 */
angular
  .module('expenseTrackerApp', [
    'ngRoute',
    'ngResource'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/category', {
        templateUrl: 'views/category.html',
        controller: 'CategoryCtrl',
        controllerAs: 'category'
      })
      .when('/expense', {
        templateUrl: 'views/expense.html',
        controller: 'ExpenseCtrl',
        controllerAs: 'expense'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
