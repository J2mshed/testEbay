Feature: Add items to cart

  Scenario Outline: Verify that user can add item to Cart from Items page searched by <searchKeyword>
    Given I open start page
    When I set '<searchKeyword>' as search criteria on Start page
    And I click on 'Search' button on Start page
    And I am on Search results page
    And I click on '<itemName>' item name on Search results page
    Then I am on Items page
    When I click on 'Add to cart' button on Items page popup page come
    And I am on AlmostDone page
    When I click on 'No thanks' button on AlmostDone page
    Then I am on Cart Payments page
    Then Cart Payments contains '<itemName>' on Cart Payments page
    And Cart subtotal is '<price>' on Cart Payments page
    And I click on 'Go to checkout' button on Cart Payments page
    And I am on Continue Verification page
    And I click on 'Continue as guest' button on Verifications page
    And I am on Guest Checkout page
    And Page contains '<itemName>' itemName on Checkout page
#    And I change the quantity of item to '<quantity>' on Checkout page
    And I set '<firstName>' as first name on Checkout page
    And I set '<lastName>' as last name on Checkout page
    And I set '<streetAddress>' as Street address on Checkout page


    
  Scenarios:
    | searchKeyword | itemName  | price | quantity| firstName | lastName| streetAddress|
    | duracell      | 6 x 76A Duracell 1.5V Alkaline Button Batteries (LR44, A76, EPX76, PX76A, V136A) | 8.07 | 5 | Jon| Johnson| 1521 Ocean Avenue, B4|