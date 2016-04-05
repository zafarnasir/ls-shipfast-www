Feature: Cart

  Cart should be easy to access

  Scenario: Add item to cart

    User should be able to add item to his cart

    Given I have identified an item that I've decided to buy
    When I choose the item
    Then I should see the item appear in the cart

  Scenario: Remove item from cart

    User should be able to remove item from his cart

    Given I have identified an item that I've decided to not buy
    When I choose the item
    Then I should no longer see the item in the cart
