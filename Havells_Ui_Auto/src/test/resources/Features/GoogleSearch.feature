Feature: Feature to test search functionality

Scenario: Validate google search is working

Given Browser is open
And User is on google search
When User enter a text in search box
And hit enter
Then User navigate to search page