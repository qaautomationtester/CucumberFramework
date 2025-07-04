Feature: Place the order for Products

@PlaceOrder
Scenario: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
And Added 3 items of the selected product to cart
Then User proceeds to checkout and validate the <Name> item in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name 	   |
| Walnuts  |