Feature: Search and Place the Order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for the Product search in both home abd Offers Page

    Given User is on GreenCart landing Page
    When User searched with shortname <Name> and extracted the actual name of the Product
    And Added "3" items of the selected product to cart
    Then User proceeds to Checkout and validate the <Name> items in the checkout page
    And Verify user has ability to enter promo code and place the order

    Examples:
      | Name |
      | Tom  |