Feature: User Registration
 
	Scenario Outline: New User registration
		Given user is on registration page
		When user enters new user details "<Sheetname>" and rownumber <RowNumber>
		And click on submit button
		Then user registered successfully and move to the login page "Home Page"
		
    Examples: 

    | Sheetname | RowNumber | 

    | NewUser    | 0 | 

    | NewUser    | 1 | 

    | NewUser    | 2 | 
		
	Scenario Outline: User login
		Given User is on Login page
		When user enters username and password details "<Sheetname>" and rownumber <RowNumber>
		And click on login button
		Then user login successfull and move to the Account Summary page "Account Summary"
		
		Examples: 

    | Sheetname | RowNumber | 

    | UserLogin    | 0 | 

    | UserLogin    | 1 | 

    | UserLogin    | 2 | 
	
	Scenario: Check Balance
		Given User is on Account Summary page
		When click on Click here for balance link
		Then Should display the balance amount "INR 100"
		
	Scenario Outline: Amount Transfer 50 then 100 then 150
		Given User is on Payment Transfer page
		When user enters transferamt details "<Sheetname>" and rownumber <RowNumber>
		And User select the bank account
		And User accept the Terms and Conditions
		And click on the submit button
		And Move to the Security password page
		When user enters OTP 234567
		And click on a submit button
		Then Amount transferred status 
		Examples: 
      | Sheetname | RowNumber | Status |

    	| AmountTransfer  | 0 | "Success" |

    	| AmountTransfer  | 1 | "There is no more balance in your account. You will be levied a Minimum maintainence charge" |

    	| AmountTransfer  | 2 | "There is insufficienct funds in your account" |
		
#	Scenario Outline: Transfer amount Amount Rs. 50 Available Balance 100
#		Given User is on Payment Transfer page
#		When User enters amount <Amount>
#		And User select the bank account
#		And User accept the Terms and Conditions
#		And User Available Balance is <AvailableBalance>
#		And click on the submit button
#		Then validate the transfer amount is less than the available balance <Amount>
#		And Move to the Security password page
#		When user enters OTP 234567
#		And click on a submit button
#		Then Amount transferred status <Status>
#		Examples: 
      #| Amount | AvailableBalance | Status |
      #| 50 | 100 | "Success" |
      #| 100 | 50 | "There is no more balance in your account. You will be levied a Minimum maintainence charge" |
      #| 150 | 50 | "There is insufficienct funds in your account" |
      #
Scenario: Logout the page
		Given User is on logout page
		When click on the Logout link
		Then Should move to the Login page "Login Page"
		