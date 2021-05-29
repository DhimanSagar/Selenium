Feature: User is only buying single product

@Smoke
Scenario: User is Buying the product by click on image
Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product

@Smoke
Scenario: User is buying the product by the dropdown.
Given User is on home page
When Select the product from dropdown
And Product is getting add to cart
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close

@Regression
Scenario: User is buying the product by selecting Subcategory
Given User is on home page
When click on the Subcategory of product
And Product is getting add to cart
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close

@Regression
Scenario: Already login user buying the product
Given User is on the My account
And User signin with OTP
When Select the product from dropdown 
And Product is getting add to cart
And User Click checkout
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close
