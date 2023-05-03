Feature: Masons App - Individual masons scenarios.

  Background:
  	Given android masons app is installed on the device and launched successfully
  	Then android user should navigate to masons app login screen
  	
  @IM_WRU_Screen @IM_Sanity
  Scenario Outline: To verify that when user performs login with valid credential then user navigates to Who are you screen.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen

    Examples: 
      | MasonsEmail 	  | MasonsPass     |
      | INDMasonsEmail1 | INDMasonsPass1 |

  @IM_Login @IM_Sanity
  Scenario Outline: To verify that user should navigates to dashboard screen when select the lodge or grand lodge or mason on Who are you screen.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen

    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		|
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt |
      
  @IM_SetPin @IM_Sanity
  Scenario Outline: To verify that user should be able to Set the Pin.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Profile Icon on mason dashboard screen
    Then android user land on mason Profile screen
    When android user click on Set Pin option on Individual mason Profile screen
    And android user entering the Pin"<SetPin>"
    And android user re-entering the Pin"<SetPin>"
    Then android user land on Pin created for mason screen
    When android user click on Close button on Pin created screen
    Then android user land on mason Profile screen

    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| SetPin |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | 0000   |
           
  @IM_AddACH @IM_Sanity
  Scenario Outline: To verify that user should be able to Add new ACH Bank Account.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Profile Icon on mason dashboard screen
    Then android user land on mason Profile screen
    When android user click on Add ACH Account on Individual mason Profile screen
    Then android user land on Add ACH Accounts screen in IM app
    When andrid user click on Add ACH button in IM app
    And android user enters the Debitors Identification in IM app"<DebtIden>"
    And android user enters the Debitors Middle name in IM app"<MidName>"
    And android user scroll till Debitors Account Info state input display
    And android user enters the Debitors Address Line two in IM app"<AddLine2>"
    And android user enters the Debitors State in IM app"<State>"
    And android user scroll till Debitors Account Info section display
    And android user enters the Debitors Institution Identification in IM app"<InstIden>"
    And android user enters the Debitors Identification CardNo in IM app"<CardNO>"
    And android user click on Continue button on Add Ach Account screen in IM app
    Then android user land on Ach account created screen in IM app
    When android user click on Go To Dashboard button in IM app
    And android user click on Add ACH Account on Individual mason Profile screen
    Then android user verify newly created Ach account card"<CardNO>"
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| DebtIden  | MidName | AddLine2 | State | InstIden  | CardNO           |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | 123456789 | abc     | Chicago  | AK    | 101110802 | 1212121212123333 |
      
  @IM_AddMnyExisACH @IM_Sanity
  Scenario Outline: To verify that user should be able to Add Money using ACH account.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    And android user click on Manage Balance button in IM app
    Then android user land on Add Money screen in IM app
    When android user click on Bank Account ACH option on Add Money screen in IM app
    Then android user land on Add ACH Accounts screen in IM app
    When android user select Ach Account card base on "<CardNO>"
    Then android user land on Debitors Account Info screen in IM app
    When android user enters the Debitors reason in IM app"<Reason>"
    And android user enters the Amount to Add in IM account"<Amount>"
    And android user click on Submit button on Debitors Account Info screen in IM app
    Then android user land on Confirm Your Transfer screen in IM app
    When android user click on CONFIRM TRANSFER button in IM app
    Then android user land on Money Added screen through ACH screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance after adding money
  
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| CardNO 					 | Reason     | Amount |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | 1212121212123333 | AddExisACH | 100    |
  
  #Debit card should be added
  @IM_AddMnyExisDebitCard
  Scenario Outline: To verify that user should be able to Add Money using Debit Card.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    And android user click on Manage Balance button in IM app
    Then android user land on Add Money screen in IM app
    When android user click on Debit Card option on Add Money screen in IM app
    Then android user land on My Cards screen in IM app
    When android user select Debit card base on "<CardNO>"
    Then android user land on Add Balance screen in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user click on Continue button on Add Balance screen
    Then android user land on Confirm Your Transfer screen in IM app
    When android user click on CONFIRM TRANSFER button in IM app
    Then android user land on Money Added screen through ACH screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance after adding money
       
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| CardNO 					 | Amount |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | ************1115 | 50			|     
  
  #Beneficiary should be added
  @RequestMnyToMason @IM_Sanity
  Scenario Outline: To verify that user should be able Request Money to mason.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Request Money option on IM dashboard screen
    Then android user land on Request Money From screen in IM app
    When android user select mason option on Request Money From screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on name "<BenName>" and email "<BenEmail>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Request Money confirmation screen
    When android user click on REQUEST NOW button on Request Money screen
    Then android user land on Money Request SENT screen in IM app
    When android user click on Back Arrow button on SENT screen
    Then android user land on Individual mason dashboard screen
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| BenName    | BenEmail    | Amount | Note    |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | BeneNameIM | BeneEmailIM | 5			| M-M Req |
  
  @DeleteOwnRequest @IM_Sanity
  Scenario Outline: To verify that user should be able to delete his own request.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Request Money option on IM dashboard screen
    Then android user land on Request Money From screen in IM app
    When android user select mason option on Request Money From screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on name "<BenName>" and email "<BenEmail>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Request Money confirmation screen
    When android user click on REQUEST NOW button on Request Money screen
    Then android user land on Money Request SENT screen in IM app
    When android user click on Back Arrow button on SENT screen
    Then android user land on Individual mason dashboard screen
    When android user click on See All option to see all Transactions
    Then android user land on Transactions screen in IM app
    When android user select the transaction request base on note "<Note>" and amount "<AMountFormat>" and click on delete in IM app
    Then android user land on request deleted screen in IM app
    Then android user land on Transactions screen in IM app
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| BenName    | BenEmail    | Amount | Note    | AMountFormat |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | BeneNameIM | BeneEmailIM | 4			| Del Req | +$4.00			 |
  
  #Beneficiary should be added
  @SendMoneyM-M @IM_Sanity
  Scenario Outline: To verify that user should be able Send money mason to mason.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on Send Money option on IM dashboard screen
    Then android user land on Send Money From screen in IM app
    When android user click on PtP Transfer option on Send Money screen in IM app
    Then android user land on Send From screen in IM app
    When android user click on Quick Money Wallet radio button on Send From screen in IM app
    And android user click on CONFIRMATION buton on Send From screen in IM app
    Then android user land on Send Money To screen in IM app
    When android user click on mason option on Send Money To screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on name "<BenName>" and email "<BenEmail>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Send Money confirmation screen
    When android user click on SEND NOW button on Send Money screen
    And android user entering the Pin"<Pin>"
    Then android user land on Transfer Done screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples:  
      | MasonsEmail 	  | MasonsPass     | GLorL 		| BenName    | BenEmail 	 | Amount | Note     | Pin  |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | BeneNameIM | BeneEmailIM | 5      | Send M-M | 0000 |
  
  #Beneficiary should be added
  @SendMoneyM-L @IM_Sanity
  Scenario Outline: To verify that user should be able Send money mason to lodge.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on Send Money option on IM dashboard screen
    Then android user land on Send Money From screen in IM app
    When android user click on PtP Transfer option on Send Money screen in IM app
    Then android user land on Send From screen in IM app
    When android user click on Quick Money Wallet radio button on Send From screen in IM app
    And android user click on CONFIRMATION buton on Send From screen in IM app
    Then android user land on Send Money To screen in IM app
    When android user click on lodge option on Send Money To screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on lodge name "<LodName>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Send Money confirmation screen
    When android user click on SEND NOW button on Send Money screen
    And android user entering the Pin"<Pin>"
    Then android user land on Transfer Done screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples:  
      | MasonsEmail 	  | MasonsPass     | GLorL 		| LodName    | Amount | Note     | Pin  |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | LodgeName1 | 6      | Send M-L | 0000 |
  
  #Beneficiary should be added
  @SendMoneyM-GL @IM_Sanity
  Scenario Outline: To verify that user should be able Send money mason to grand lodge.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on Send Money option on IM dashboard screen
    Then android user land on Send Money From screen in IM app
    When android user click on PtP Transfer option on Send Money screen in IM app
    Then android user land on Send From screen in IM app
    When android user click on Quick Money Wallet radio button on Send From screen in IM app
    And android user click on CONFIRMATION buton on Send From screen in IM app
    Then android user land on Send Money To screen in IM app
    When android user click on grand lodge option on Send Money To screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on grand lodge name "<GLName>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Send Money confirmation screen
    When android user click on SEND NOW button on Send Money screen
    And android user entering the Pin"<Pin>"
    Then android user land on Transfer Done screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples:  
      | MasonsEmail 	  | MasonsPass     | GLorL 		| GLName     | Amount | Note      | Pin  |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | GLName1    | 7      | Send M-GL | 0000 |
      
  @DeleteACH @IM_Sanity
  Scenario Outline: To verify that user should be able to Remove ACH Bank Account.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Profile Icon on mason dashboard screen
    Then android user land on mason Profile screen
    When android user click on Add ACH Account on Individual mason Profile screen
    Then android user land on Add ACH Accounts screen in IM app
    When android user select Ach Account card base on "<CardNO>"
    And android user click on Delete Icon on Ach Account screen
    Then android user land on BANK REMOVED screen in IM app
    Then android user land on Add ACH Accounts screen in IM app
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| CardNO           |   
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | 1212121212123333 |
      
  @IM_ChangePin @IM_Sanity
  Scenario Outline: To verify that user should be able to Change the Pin.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Profile Icon on mason dashboard screen
    Then android user land on mason Profile screen
    When android user click on Change Pin option on Individual mason Profile screen
    And android user entering the Pin"<OldPin>"
    And android user re-entering the Pin"<NewPin>"
    And android user re-entering the Pin"<NewPin>"
    Then android user land on Pin changed for mason screen
    When android user click on Close button on Pin created screen
    Then android user land on mason Profile screen
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| OldPin | NewPin |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | 0000   | 1111		|
      
  @IM_DisablePin @IM_Sanity
  Scenario Outline: To verify that user should be able to Disable the Pin.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Profile Icon on mason dashboard screen
    Then android user land on mason Profile screen
    When android user click on Disable Pin option on Individual mason Profile screen
    And android user entering the Pin"<OldPin>"
    Then android user land on Pin Removed for mason screen
    When android user click on Close button on Pin created screen
    Then android user land on mason Profile screen
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| OldPin |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | 1111   |
      
  @ReqRefuse @IM_Sanity
  Scenario Outline: To verify that user should be able to Refuse the money request.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Request Money option on IM dashboard screen
    Then android user land on Request Money From screen in IM app
    When android user select mason option on Request Money From screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on name "<BenName>" and email "<BenEmail>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Request Money confirmation screen
    When android user click on REQUEST NOW button on Request Money screen
    Then android user land on Money Request SENT screen in IM app
    When android user click on Back Arrow button on SENT screen
    Then android user land on Individual mason dashboard screen
    Then adnroid user close the mason application
    Given android masons app is installed on the device and launched successfully
  	Then android user should navigate to masons app login screen
    When android user provides masons Username "<BenEmail>" and Password "<BenPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on Money Requested option on IM dashboard screen
    Then android user land on Money Requested screen in IM app
    When android user select the money request base on Note "<Note>" and amount "<AMountFormat>" in IM app
    Then android user land on What do you want to do screen in IM app
    When android click on Cross icon for refuse the money request
    Then android user land on money Request deleted screen in IM app
    When android user click on device back button
    Then android user land on Money Requested screen in IM app
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| BenName    | BenEmail    | BenPass    | Amount | Note       | AMountFormat |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | BeneNameIM | BeneEmailIM | BenePassIM | 1			 | Req Refuse | $ 1.00       |
      
  @ReqAccept @IM_Sanity
  Scenario Outline: To verify that user should be able to Accept or PayBack the money request.
    When android user provides masons Username "<MasonsEmail>" and Password "<MasonsPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    When android user click on Request Money option on IM dashboard screen
    Then android user land on Request Money From screen in IM app
    When android user select mason option on Request Money From screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on name "<BenName>" and email "<BenEmail>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Request Money confirmation screen
    When android user click on REQUEST NOW button on Request Money screen
    Then android user land on Money Request SENT screen in IM app
    When android user click on Back Arrow button on SENT screen
    Then android user land on Individual mason dashboard screen
    Then adnroid user close the mason application
    Given android masons app is installed on the device and launched successfully
  	Then android user should navigate to masons app login screen
    When android user provides masons Username "<BenEmail>" and Password "<BenPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge or mason at"<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on Money Requested option on IM dashboard screen
    Then android user land on Money Requested screen in IM app
    When android user select the money request base on Note "<Note>" and amount "<AMountFormat>" in IM app
    Then android user land on What do you want to do screen in IM app
    When android click on True Sign icon for Payback the money request
    Then android user land on Send Money confirmation screen
    When android user click on SEND NOW button on Send Money screen
    Then android user land on Transfer Done screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Individual mason dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples: 
      | MasonsEmail 	  | MasonsPass     | GLorL 		| BenName    | BenEmail    | BenPass    | Amount | Note       | AMountFormat |
      | INDMasonsEmail1 | INDMasonsPass1 | IMasonAt | BeneNameIM | BeneEmailIM | BenePassIM | 2			 | Req Accept | $ 2.00       |