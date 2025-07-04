Feature: Search and Place the order for Products

@greenkart
Scenario: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When user searched with Shortname Tom and extracted actual name of product
#Then user searched for Tom shortname in offers page to check if product exist with same name
Then user searched for Tom shortname in offers page
And validate product name in offers page matches with landing page

@parameterization
Scenario Outline: Search Experience for product search in both home and offers page
Given User is on GreenCart Landing page
When user searched with Shortname <VegName> and extracted actual name of product
#Then user searched for <VegName> shortname in offers page to check if product exist with same name
Then user searched for <VegName> shortname in offers page
And validate product name in offers page matches with landing page

Examples:
| VegName |
|   Tom	  |
|	Car	  |
|   Beet   |
