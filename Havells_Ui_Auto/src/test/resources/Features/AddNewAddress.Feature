Feature: User Adding new address and shipping to different Address


Scenario: User is adding the address in address book

Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
And User signin with OTP
When User Add new Address
And User click on Save in address book Checkbox
Then user is able to add address in address book

Scenario: User is booking using adding new address
Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
And User signin with OTP
When User Add new Address
Then user is able to add address in address book
And User Select the Details
And User enter the payment details
Then able to buy the product

Scenario: User is Shipped the product to different address

Given User is on home page
When click on the product from image
And redirect to products details page
And Product is getting add to cart
And User signin with OTP
When User select the Ship to different address
When User Add new Address
And User Enter the Details
And User enter the payment details
Then able to buy the product