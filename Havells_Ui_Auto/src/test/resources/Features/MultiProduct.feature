Feature: User are buying more then 1 product

@Regression
Scenario: User is able to buy same product with more then one quantity

Given User is on home page
When click on the product from image
When Select the Quantity
And redirect to products details page  
And Product is getting add to cart  
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close

@Smoke
Scenario: User is able to buy multiple type of product

Given User is on home page
When click on the product from image
And redirect to products details page
And click on Home link
And Select the Another product
And Product is getting add to cart
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close

