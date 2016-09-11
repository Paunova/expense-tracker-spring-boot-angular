'use strict';

/**
 * @ngdoc directive
 * @name expenseTrackerApp.directive:expense
 * @description
 * # expense
 */
angular.module('expenseTrackerApp')
  .directive('expense', function () {
    return {
      template: '<div></div>',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
        element.text('this is the expense directive');
      }
    };
  });
