Feature: Validating Place/Location API's'

#Scenario: Validate whether Add Place is success or not
#    Given User send "addPlacePayLoad" Payload
#    When User calls "AddPlace" API with Post http request
#    Then The "statusCode" in response is 200
#    And The "status" in reponse is "OK" 
#    And The "scope" in reponse is "APP" 
    

Scenario Outline: Validate whether Add Place is success or not
    Given User send "addPlacePayLoad" Payload with "<name>" and "<language>" and "<address>"
    When User calls "AddPlace" API with Post http request
    Then The "statusCode" in response is 200
    And The "status" in reponse is "OK" 
    And The "scope" in reponse is "APP" 
    
    Examples:
    |name|language|address|
    |Aadithya S Deepu|English|MRA 10 D|
    |Sruthi SS|Japanese|MRA 11 D|