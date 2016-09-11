'use strict';

describe('Service: exchangeRate', function () {

  // load the service's module
  beforeEach(module('expenseTrackerApp'));

  // instantiate service
  var exchangeRate;
  beforeEach(inject(function (_exchangeRate_) {
    exchangeRate = _exchangeRate_;
  }));

  it('should do something', function () {
    expect(!!exchangeRate).toBe(true);
  });

});
