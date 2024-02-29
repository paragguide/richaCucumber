Feature: Amazon Document
  I want to use this document to test Amazon.com
  
  @amazon @uid
  Scenario: Amazon Uid test
    Given I open browser "chrome" and get url "https://www.amazon.in/" generate report "AmazonReport"
    And click on signin
    When I enter valid userid "paragguide@yahoo.co.in"
    And click continue button
    Then I validate userid
    And password textbox comes
    
  @amazon @pwd
  Scenario: Amazon Pwd test
   Given uid is valid
   When i enter correct password "RMinfotech"
   Then i should login
   
   @amazon @search
   Scenario Outline: Amazon Product search
    Given user is logged in
    When i search for product <product> with price <price>
    Then result should come
    
    Examples:
    |product|price|
    |Mobile| 15000|
    |LCD|35000|
    |shirt|3000|
    
  
