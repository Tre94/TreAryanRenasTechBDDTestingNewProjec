Feature:




#Payment Gateway Scenario
#- Scenario
#Before you order the toy, you should create a scenario to verify Header
#Here is the expected text “Mother Elephant With Babies Soft Toy”
#You should use parametrization in this scenario

  Background:
    Given The user wants to go to the Guru99 payment Gateway Page


  @Smoke
  Scenario: Verify Header
    When The user wants to verify  header as "Mother Elephant With Babies Soft Toy"









#- Scenario
#In order page you need to verify that the toy price is 20$
#Create a scenario verify that the toy price is 20$


  @Smoke
  Scenario: Verify toy price
    When The user wants to verify that the toy price is "$20"








#- Scenario
#Create a scenario that the URL should contain “payment-gateway”

  @Smoke
  Scenario: Url  verification
    When The user wants to verify that URL contains "payment-gateway"






#- Scenario
#The quantity must be 5
#You may need to fake enter card information (Card number will be 16 digit)
#Once you order, you should be able to verify “Payment successfull!” text.



  @Regression
  Scenario: Verify payment process
    When The user wants to choose quantity of the product as "5"
    And  The user wants to click Buy Now Button
    And  The user wants to enter card information as
      |Card          | 0987650987654321  |
      |expireMonth    | 11               |
      |expireYear     | 25                |
      |CVVCode       | 743               |
    And  The user wants to click pay button
    Then The user should be able to see "Payment successfull!"  text







#- Scenario outline
#The quantity must be 5,8,9,2,4
#You may need to fake enter card information (Card number will be 16 digit)
#Once you order, you should be able to verify “Payment successful!” text.



  @Regression
  Scenario Outline:

    When The user wants to choose quantity of the product as "<quantity>"
    And  The user wants to click Buy Now Button
    And  The user wants to enter card information as
      |Card          | 0987650987654321  |
      |expireMonth    | 11               |
      |expireYear     | 25                |
      |CVVCode       | 743               |
    And  The user wants to click pay button
    Then The user should be able to see "Payment successfull!"  text

    Examples:
      | quantity  |
      |   5       |
      |   8       |
      |   9       |
      |   2       |
      |   4       |


