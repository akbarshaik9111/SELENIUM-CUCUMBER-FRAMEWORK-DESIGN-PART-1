Feature: Place the order for products

  @PlaceOrder
  Scenario Outline: Add the product to the cart and verify the promo and place order buttons
    Given User is on GreenKart home page
    When User searched with short name <Name> and extracted actual name of product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    #And Verify user has ability to enter promocode and place the order

    Examples:
      | Name |
      | Tom  |
