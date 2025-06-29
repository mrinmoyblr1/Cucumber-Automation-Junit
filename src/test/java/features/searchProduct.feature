Feature: Search and Place the Order for Products

  @OffersPage
  Scenario Outline: Search Experience for the Product search in both home abd Offers Page
    Given User is on GreenCart landing Page
    When User searched with shortname <Name> and extracted the actual name of the Product
    Then User searched for <Name> shortname in the offer page
    And validate product name in offers page matches with Landing Page
    Examples:
      | Name    |
      | Tom     |
#      | Beet|