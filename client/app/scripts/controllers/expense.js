'use strict';

/**
 * @ngdoc function
 * @name expenseTrackerApp.controller:ExpenseCtrl
 * @description
 * # ExpenseCtrl
 * Controller of the expenseTrackerApp
 */
angular.module('expenseTrackerApp')
  .controller('ExpenseCtrl', function ($scope, Expense, Category, exchangeRateService) {
    $scope.editMode = false;

    $scope.expenses = [];
    $scope.addAmount = '';
    $scope.addInDollar = false;
    $scope.categories = [];
    $scope.addDescription = '';

    $scope.editAmount = '';
    $scope.editInDollar = false;
    $scope.editDescription = '';
    $scope.editId = 0;

    $scope.dollarToEuro = 0;
    exchangeRateService.getRate().then(function (response) {
      $scope.dollarToEuro = response.data;
    })

    $scope.currency = {
      name: 'euro'
    };

    refresh();
    $scope.categories = Category.query();

    $scope.addNewExpense = function () {
      $scope.expense = new Expense();
      $scope.expense.amount = $scope.addAmount;
      $scope.expense.description = $scope.addDescription;
      $scope.expense.category = $scope.categoriesList;
      $scope.expense.isDollar = $scope.addInDollar;

      Expense.save($scope.expense, function () {
        $scope.addAmount = '';
        $scope.addDescription = '';
        $scope.addInDollar = false;
        refresh();
      })
    };

    $scope.editExpense = function (expense) {
      $scope.editMode = true;
      $scope.editAmount = expense.amount;
      $scope.editDescription = expense.description;
      $scope.editId = expense.expense_id;
      $scope.editInDollar = expense.isDollar;

      $scope.categories.forEach(function(category) {
        if (category.category_id === expense.category.category_id) {
          $scope.editCategoriesList = category;
        }
      })
    };

    $scope.saveEdit = function() {
      $scope.editMode = false;

      $scope.editedExpense = new Expense();
      $scope.editedExpense.expense_id = $scope.editId;
      $scope.editedExpense.amount = $scope.editAmount;
      $scope.editedExpense.isDollar = $scope.editInDollar;
      $scope.editedExpense.description = $scope.editDescription;
      $scope.editedExpense.category = $scope.editCategoriesList;

      Expense.update($scope.editedExpense, function () {
        refresh();
      })
    };

    $scope.cancelEdit = function() {
      $scope.editMode = false;
    };

    $scope.removeExpense = function (expense) {
      Expense.delete(expense, function() {
        refresh();
      })
    };

    $scope.refreshRate = function () {
      exchangeRateService.refreshRate().then(function () {
        exchangeRateService.getRate().then(function (response) {
          $scope.dollarToEuro = response.data;
        })
      })
    }

    function refresh() {
      $scope.expenses = Expense.query();
    }
  });
