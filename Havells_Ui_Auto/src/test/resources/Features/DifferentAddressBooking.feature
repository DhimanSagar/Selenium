Feature: Different
Scenario: Already login user buying the product
Given User is on home page
And Click on the My account 
And User signin with OTP
When Select the product from dropdown 
And redirect to products details page
And Product is getting add to cart
And User Enter the Details
And User enter the payment details
Then able to buy the product