Feature: Online single product are getting buy

Scenario: User is able to buy the product

Given User is on home page
When click on the product from image
And redirect to product details page
And Product is getting add to cart
And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product

#Scenario: User is able to buy same product with more then one quantity

#Given User is on home page
#When click on the product from image
#And redirect to product details page
#And Select the Quantity
#Then able to buy the product


#Scenario: User is able to buy product from the dropdown
#Given User is on home page.
#When Select the product from dropdown.
#And redirect to product details page.
#And Product is getting add to cart.
#And User signin with OTP.
#And User Enter the Details.
#And User enter the payment details.
#Then able to buy the product.

#Scenario: User is able to buy multiple type of product

