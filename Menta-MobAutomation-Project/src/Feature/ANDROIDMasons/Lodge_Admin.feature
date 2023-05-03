Feature: Masons App - Lodge admin scenarios.

  Background:
  	Given android masons app is installed on the device and launched successfully
  	Then android user should navigate to masons app login screen
  	
  @L_WRU_Screen
  Scenario Outline: To verify that when user performs login with valid credential then user navigates to Who are you screen.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen

    Examples: 
      | LEmail      | LPass      |
      | LodgeEmail1 | LodgePass1 |
      
  @L_Login
  Scenario Outline: To verify that user should navigates to dashboard screen when select the lodge or grand lodge or mason on Who are you screen.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen

    Examples: 
      | LEmail      | LPass      | GLorL |
      | LodgeEmail1 | LodgePass1 | L_at  |
        
  @L_AddACH
  Scenario Outline: To verify that user should be able to Add new ACH Bank Account.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    When android user click on Profile Icon on Individual mason dashboard screen
    Then android user land on Individual mason Profile screen
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
      | LEmail      | LPass      | GLorL | DebtIden  | MidName | AddLine2 | State | InstIden  | CardNO           |
      | LodgeEmail1 | LodgePass1 | L_at  | 123456789 | abc     | Chicago  | AK    | 101110802 | 1212121212123333 |
      
  @L_AddMnyACH
  Scenario Outline: To verify that user should be able to Add Money using ACH account.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance before adding money
    And android user click on Add Money button on GL dashboard screen
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
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance after adding money
  
    Examples: 
      | LEmail      | LPass      | GLorL | CardNO 					| Reason      | Amount |
      | LodgeEmail1 | LodgePass1 | L_at  | 1212121212123333 | Add-Mny-ACH | 40     |
      
  #Debit card should be added
  @L_AddMnyDebit
  Scenario Outline: To verify that user should be able to Add Money using Debit Card.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance before adding money
    And android user click on Add Money button on GL dashboard screen
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
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance after adding money
       
    Examples: 
      | LEmail      | LPass      | GLorL | CardNO 					| Amount |
      | LodgeEmail1 | LodgePass1 | L_at  | ************1116 | 20		 |
      
  #Grand Lodge added as a beneficiary
  @L_SendMny_L-GL
  Scenario Outline: To verify that user should be able to send money to grand lodge.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on the Transactions layout on GL dashboard screen
    And android user land on Grand lodge Transactions screen
    And android user click on Plus button on GL Transactions screen
    And android user click on GL Send Money button
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
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples: 
      | LEmail      | LPass      | GLorL | GLName     | Amount | Note      | Pin  |
      | LodgeEmail1 | LodgePass1 | L_at  | GLNameBene |	5			 | Send L-GL | 0000 |
      
  #Lodge added as a beneficiary    
  @L_SendMny_L-L
  Scenario Outline: To verify that user should be able to send money to lodge.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on the Transactions layout on GL dashboard screen
    And android user land on Grand lodge Transactions screen
    And android user click on Plus button on GL Transactions screen
    And android user click on GL Send Money button
    Then android user land on Send Money From screen in IM app
    When android user click on PtP Transfer option on Send Money screen in IM app
    Then android user land on Send From screen in IM app
    When android user click on Quick Money Wallet radio button on Send From screen in IM app
    And android user click on CONFIRMATION buton on Send From screen in IM app
    Then android user land on Send Money To screen in IM app
    When android user click on lodge option on Send Money To screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on grand lodge name "<LName>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Send Money confirmation screen
    When android user click on SEND NOW button on Send Money screen
    And android user entering the Pin"<Pin>"
    Then android user land on Transfer Done screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Lodge dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples: 
      | LEmail      | LPass      | GLorL | LName     | Amount | Note     | Pin  |
      | LodgeEmail1 | LodgePass1 | L_at  | LNameBene |	6			| Send L-L | 0000 |
      
  #Mason added as a beneficiary    
  @L_SendMny_L-M
  Scenario Outline: To verify that user should be able to send money to mason.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Grand Lodge dashboard screen
    Then android user verify Individual Mason account balance before adding money
    When android user click on the Transactions layout on GL dashboard screen
    And android user land on Grand lodge Transactions screen
    And android user click on Plus button on GL Transactions screen
    And android user click on GL Send Money button
    Then android user land on Send Money From screen in IM app
    When android user click on PtP Transfer option on Send Money screen in IM app
    Then android user land on Send From screen in IM app
    When android user click on Quick Money Wallet radio button on Send From screen in IM app
    And android user click on CONFIRMATION buton on Send From screen in IM app
    Then android user land on Send Money To screen in IM app
    When android user click on mason option on Send Money To screen in IM app
    Then android user land on Choose Beneficiary screen in IM app
    When android user select the beneficiary base on name "<MName>" and email "<MEmail>" in IM app
    And android user enters the Amount through keypad in IM app "<Amount>"
    And android user enters the note for request the money in IM app "<Note>"
    And android user click on CONTINUE button on keypad screen
    Then android user land on Send Money confirmation screen
    When android user click on SEND NOW button on Send Money screen
    And android user entering the Pin"<Pin>"
    Then android user land on Transfer Done screen in IM app
    When android user click on GO TO DASHBOARD button on Money Added screen in IM app
    Then android user land on Grand Lodge dashboard screen
    Then android user verify Individual Mason account balance after adding money
    
    Examples: 
      | LEmail      | LPass      | GLorL | MName      | MEmail      | Amount | Note     | Pin  |
      | LodgeEmail1 | LodgePass1 | L_at  | BeneNameIM | BeneEmailIM |	7			 | Send L-M | 0000 |
      
  @L_DeleteACH
  Scenario Outline: To verify that user should be able to Remove ACH Bank Account.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    When android user click on Profile Icon on Individual mason dashboard screen
    Then android user land on Individual mason Profile screen
    When android user click on Add ACH Account on Individual mason Profile screen
    Then android user land on Add ACH Accounts screen in IM app
    When android user select Ach Account card base on "<CardNO>"
    And android user click on Delete Icon on Ach Account screen
    Then android user land on BANK REMOVED screen in IM app
    Then android user land on Add ACH Accounts screen in IM app
    
    Examples: 
      | LEmail      | LPass      | GLorL | CardNO           |   
      | LodgeEmail1 | LodgePass1 | L_at  | 1212121212123333 |
      
  @L_ChangePin
  Scenario Outline: To verify that user should be able to Change the Pin.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    When android user click on Profile Icon on Individual mason dashboard screen
    Then android user land on Individual mason Profile screen
    When android user click on Change Pin option on Individual mason Profile screen
    And android user entering the Pin"<OldPin>"
    And android user re-entering the Pin"<NewPin>"
    And android user re-entering the Pin"<NewPin>"
    Then android user land on Pin changed for individual mason screen
    When android user click on Close button on Pin created screen
    Then android user land on Individual mason Profile screen
    
    Examples: 
      | LEmail      | LPass      | GLorL | OldPin | NewPin |
      | LodgeEmail1 | LodgePass1 | L_at  | 0000   | 1111	 |
      
  @L_DisablePin
  Scenario Outline: To verify that user should be able to Disable the Pin.
    When android user provides masons Username "<LEmail>" and Password "<LPass>"
    And android user click on the masons login button
    Then android user land on Who are you screen
    When android user select the grand lodge or lodge "<GLorL>"
    And android user click on CONTINUE button on Who are you screen
    Then android user land on Lodge dashboard screen
    When android user click on Profile Icon on Individual mason dashboard screen
    Then android user land on Individual mason Profile screen
    When android user click on Disable Pin option on Individual mason Profile screen
    And android user entering the Pin"<OldPin>"
    Then android user land on Pin Removed for individual mason screen
    When android user click on Close button on Pin created screen
    Then android user land on Individual mason Profile screen
    
    Examples: 
      | LEmail      | LPass      | GLorL | OldPin |
      | LodgeEmail1 | LodgePass1 | L_at  | 1111   |