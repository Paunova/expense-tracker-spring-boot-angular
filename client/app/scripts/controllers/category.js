'use strict';

/**
 * @ngdoc function
 * @name expenseTrackerApp.controller:CategoryCtrl
 * @description
 * # CategoryCtrl
 * Controller of the expenseTrackerApp
 */
angular.module('expenseTrackerApp')
  .controller('CategoryCtrl', function ($scope, Category) {
    $scope.categories = [];
    $scope.newCategoryName = '';

    refresh();

    $scope.addNewCategory = function () {
      $scope.category = new Category();
      $scope.category.name = $scope.newCategoryName;

      Category.save($scope.category, function () {
        refresh();
        $scope.newCategoryName = '';
      });
    };

    $scope.removeCategory = function(category) {
      Category.delete(category, function() {
        refresh()
      });
    };

    function refresh() {
      $scope.categories = Category.query();
    }
  });
