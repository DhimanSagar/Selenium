Feature: User is applying the Coupon and gift card  

@Smoke
Scenario: User is applying the coupon while booking

Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
When User add the coupon
And User Click checkout
And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close

@Smoke
Scenario: User is applying the Gift Card while booking

Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
When User add the Gift certificate
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close

@Regression
Scenario: User is applying the both Coupon and Gift Card while booking

Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
When User add the coupon
When User add the Gift certificate
And User Click checkout
#And User signin with OTP
And User Enter the Details
And User enter the payment details
Then able to buy the product
#And Browser close
