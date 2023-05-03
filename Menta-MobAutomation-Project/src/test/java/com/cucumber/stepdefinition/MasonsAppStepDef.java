package com.cucumber.stepdefinition;

import java.util.List;
import java.util.Objects;

import org.testng.Assert;

import com.appium.utility.Constants;
import com.utility.LogCapture;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class MasonsAppStepDef 
{
	@Given("^android masons app is installed on the device and launched successfully$")
	public void android_masons_app_is_installed_on_the_device_and_launched_successfully() throws Throwable 
	{
		String vMasonsAppPackage = Constants.CONFIG.getProperty("appPackageMasons");
		String vMasonsAppActivity = Constants.CONFIG.getProperty("appActivityMasons");
		
		if(Constants.CONFIG.getProperty("isLocalJenkins").equals("true"))
		{
			Thread.sleep(10000);		
	        String vDeviceID = Constants.CONFIG.getProperty("device");
	        LogCapture.info("Masons Application is launching on the device "+vDeviceID+"....");
	        //System.out.println(vBrowserName);
	        Constants.JenkinsBrowser= (Objects.equals(Constants.JenkinsBrowser, "null")) ? "" : "";
	        try {
	            if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
	            	vDeviceID = Constants.JenkinsBrowser;
	                LogCapture.info("Device ID is :" + vDeviceID);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        Assert.assertEquals(Constants.KEYWORD_PASS, Constants.key.launchAppUsingDeviceId(vDeviceID , vMasonsAppPackage , vMasonsAppActivity));  
	        LogCapture.info("Device ID is :" + vDeviceID);		   
			LogCapture.info("Masons Application installed and launched successfully......!!!!");
		}
		else if(Constants.CONFIG.getProperty("isBrowserstackJenkins").equals("true"))
		{
			Thread.sleep(10000);
			
			 String vDeviceID = Constants.CONFIG.getProperty("bDevice");
		        LogCapture.info("Masons Application is launching on the device "+vDeviceID+"....");
		        //System.out.println(vBrowserName);
		        //Constants.JenkinsBrowser= (Objects.equals(Constants.JenkinsBrowser, "null")) ? "" : "";
		        try {
		            if (!Constants.JenkinsBrowser.isEmpty() || !Constants.JenkinsBrowser.equals("")) {
		            	vDeviceID = Constants.JenkinsBrowser;
		                LogCapture.info("Device ID is :" + vDeviceID);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			
		        
		        String vVersion = Constants.CONFIG.getProperty("bVersion");
		        LogCapture.info("Masons Application is launching on the device version "+vVersion+"....");
		        //System.out.println(vBrowserName);
		        //Constants.BrowserStack= (Objects.equals(Constants.BrowserStack, "null")) ? "" : "";
		        try {
		            if (!Constants.BrowserStack.isEmpty() || !Constants.BrowserStack.equals("")) {
		            	vVersion = Constants.BrowserStack;
		                LogCapture.info("Device Version is :" + vVersion);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
			
		    
		    String rep = vDeviceID.replaceAll("-", " ");    
		    
			Assert.assertEquals(Constants.KEYWORD_PASS,Constants.key.launchAppANDROIDBrowserstack(rep , vVersion));
			LogCapture.info("Application installed and launched successfully......!!!!");
		}
	}

	@Then("^android user should navigate to masons app login screen$")
	public void android_user_should_navigate_to_masons_app_login_screen() throws Throwable 
	{
		String vObjMasonsLoginScreen = Constants.ANDROIDMasonsOR.getProperty("MasonsLoginScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMasonsLoginScreen));
		LogCapture.info("Android user is on masons app login screen...");
	}

	@When("^android user provides masons Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void android_user_provides_masons_Username_and_Password(String IMEmail, String IMPass) throws Throwable 
	{
		String vObjMasonsEmailInput = Constants.ANDROIDMasonsOR.getProperty("MasonsEmailInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMasonsEmailInput));
		   
		String vObjMasonsPassInput = Constants.ANDROIDMasonsOR.getProperty("MasonsPassInput");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMasonsPassInput));
		  
		String vIMasonsEmail = Constants.ANDROIDTestData.getProperty(IMEmail);
		String vIMasonsPass = Constants.ANDROIDTestData.getProperty(IMPass);
		  		
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjMasonsEmailInput, vIMasonsEmail));
		   
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjMasonsPassInput, vIMasonsPass));
		LogCapture.info("Android user entered email successfully..."+vIMasonsEmail);
		LogCapture.info("Android user entered password successfully..."+vIMasonsPass);
	}

	@When("^android user click on the masons login button$")
	public void android_user_click_on_the_masons_login_button() throws Throwable 
	{
		String vObjMasonsLoginBtn = Constants.ANDROIDMasonsOR.getProperty("MasonsLoginBtn");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMasonsLoginBtn));
		Assert.assertEquals("PASS", Constants.key.click(vObjMasonsLoginBtn));
		LogCapture.info("Android user clicked on masons login button...");
	}

	@Then("^android user land on Who are you screen$")
	public void android_user_land_on_Who_are_you_screen() throws Throwable 
	{
		String vObjWhoAreYouScreen = Constants.ANDROIDMasonsOR.getProperty("WhoAreYouScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWhoAreYouScreen));
		LogCapture.info("Android user is on Who are you? screen...");
	}
	
	@When("^android user select the grand lodge or lodge or mason at\"([^\"]*)\"$")
	public void android_user_select_the_grand_lodge_or_lodge_or_mason_at(String GLorLodge) throws Throwable 
	{
		GLorLodge = Constants.ANDROIDTestData.getProperty(GLorLodge);

		try
		{
			String vObjMasonAtList = Constants.ANDROIDMasonsOR.getProperty("MasonAtList");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMasonAtList));
			
			List<MobileElement> masonAtList = Constants.key.getElementList(vObjMasonAtList);
			int sizemasonAtList = masonAtList.size();
			//System.out.println(sizemasonAtList);
			
			for(int i=0 ; i<sizemasonAtList ; i++)
			{
				String masonAtTxt = masonAtList.get(i).getText().trim();
				//System.out.println(masonAtTxt);
				if(masonAtTxt.equalsIgnoreCase(GLorLodge.trim()))
				{
					masonAtList.get(i).click();
					LogCapture.info("Android user selected specify lodge or grand lodge or mason at..."+GLorLodge);
					break;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			LogCapture.info("Android user entered Lodge name or Grand Lodge name incorrect hence its not selected...");
		}
	}
	
	
	@When("^android user click on CONTINUE button on Who are you screen$")
	public void android_user_click_on_CONTINUE_button_on_Who_are_you_screen() throws Throwable 
	{
		String vObjCONTINUEBtnWhoAreYouPage = Constants.ANDROIDMasonsOR.getProperty("CONTINUEBtnWhoAreYouPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCONTINUEBtnWhoAreYouPage));
		Assert.assertEquals("PASS", Constants.key.click(vObjCONTINUEBtnWhoAreYouPage));
		LogCapture.info("Android user clicked on CONTINUE button...");
	}

	@Then("^android user land on Individual mason dashboard screen$")
	public void android_user_land_on_Individual_mason_dashboard_screen() throws Throwable 
	{
		String vObjManageBtnOnIMDashPage = Constants.ANDROIDMasonsOR.getProperty("ManageBtnOnIMDashPage");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjManageBtnOnIMDashPage));
		LogCapture.info("Android user is on Individual mason Dashboard screen...");
	}
	
	@When("^android user (entering|re-entering) the Pin\"([^\"]*)\"$")
	public void android_user_entering_the_Pin(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("entering"))
		{
			String amount = data;
			String str[] = amount.split("");
			for (int i = 0; i < str.length; i++) 
			{
				Constants.TempData = str[i];
				switch (Constants.TempData) 
				{
				case "1":
					System.out.println("1");
					String vObjOne = Constants.ANDROIDMasonsOR.getProperty("One");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
					Assert.assertEquals("PASS", Constants.key.click(vObjOne));
					break;
				case "2":
					System.out.println("2");
					String vObjTwo = Constants.ANDROIDMasonsOR.getProperty("Two");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
					Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
					break;
				case "3":
					System.out.println("3");
					String vObjThree = Constants.ANDROIDMasonsOR.getProperty("Three");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
					Assert.assertEquals("PASS", Constants.key.click(vObjThree));
					break;
				case "4":
					System.out.println("4");
					String vObjFour = Constants.ANDROIDMasonsOR.getProperty("Four");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
					Assert.assertEquals("PASS", Constants.key.click(vObjFour));
					break;
				case "5":
					System.out.println("5");
					String vObjFive = Constants.ANDROIDMasonsOR.getProperty("Five");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
					Assert.assertEquals("PASS", Constants.key.click(vObjFive));
					break;
				case "6":
					System.out.println("6");
					String vObjSix = Constants.ANDROIDMasonsOR.getProperty("Six");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
					Assert.assertEquals("PASS", Constants.key.click(vObjSix));
					break;
				case "7":
					System.out.println("7");
					String vObjSeven = Constants.ANDROIDMasonsOR.getProperty("Seven");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
					Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
					break;
				case "8":
					System.out.println("8");
					String vObjEight = Constants.ANDROIDMasonsOR.getProperty("Eight");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
					Assert.assertEquals("PASS", Constants.key.click(vObjEight));
					break;
				case "9":
					System.out.println("9");
					String vObjNine = Constants.ANDROIDMasonsOR.getProperty("Nine");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
					Assert.assertEquals("PASS", Constants.key.click(vObjNine));
					break;
				case "0":
					System.out.println("0");
					String vObjZero = Constants.ANDROIDMasonsOR.getProperty("Zero");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
					Assert.assertEquals("PASS", Constants.key.click(vObjZero));
					break;
				case ".":
					System.out.println(".");
					String vObjDott = Constants.ANDROIDMasonsOR.getProperty("Dott");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
					Assert.assertEquals("PASS", Constants.key.click(vObjDott));
					break;
				default:
					System.out.println("Not a number");
				}
			}
			LogCapture.info("Android user entered Pin successfully..."+data);
		}
		else if(optionValue.equalsIgnoreCase("re-entering"))
		{
			String amount = data;
			String str[] = amount.split("");
			for (int i = 0; i < str.length; i++) 
			{
				Constants.TempData = str[i];
				switch (Constants.TempData) 
				{
				case "1":
					System.out.println("1");
					String vObjOne = Constants.ANDROIDMasonsOR.getProperty("One");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
					Assert.assertEquals("PASS", Constants.key.click(vObjOne));
					break;
				case "2":
					System.out.println("2");
					String vObjTwo = Constants.ANDROIDMasonsOR.getProperty("Two");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
					Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
					break;
				case "3":
					System.out.println("3");
					String vObjThree = Constants.ANDROIDMasonsOR.getProperty("Three");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
					Assert.assertEquals("PASS", Constants.key.click(vObjThree));
					break;
				case "4":
					System.out.println("4");
					String vObjFour = Constants.ANDROIDMasonsOR.getProperty("Four");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
					Assert.assertEquals("PASS", Constants.key.click(vObjFour));
					break;
				case "5":
					System.out.println("5");
					String vObjFive = Constants.ANDROIDMasonsOR.getProperty("Five");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
					Assert.assertEquals("PASS", Constants.key.click(vObjFive));
					break;
				case "6":
					System.out.println("6");
					String vObjSix = Constants.ANDROIDMasonsOR.getProperty("Six");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
					Assert.assertEquals("PASS", Constants.key.click(vObjSix));
					break;
				case "7":
					System.out.println("7");
					String vObjSeven = Constants.ANDROIDMasonsOR.getProperty("Seven");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
					Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
					break;
				case "8":
					System.out.println("8");
					String vObjEight = Constants.ANDROIDMasonsOR.getProperty("Eight");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
					Assert.assertEquals("PASS", Constants.key.click(vObjEight));
					break;
				case "9":
					System.out.println("9");
					String vObjNine = Constants.ANDROIDMasonsOR.getProperty("Nine");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
					Assert.assertEquals("PASS", Constants.key.click(vObjNine));
					break;
				case "0":
					System.out.println("0");
					String vObjZero = Constants.ANDROIDMasonsOR.getProperty("Zero");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
					Assert.assertEquals("PASS", Constants.key.click(vObjZero));
					break;
				case ".":
					System.out.println(".");
					String vObjDott = Constants.ANDROIDMasonsOR.getProperty("Dott");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
					Assert.assertEquals("PASS", Constants.key.click(vObjDott));
					break;
				default:
					System.out.println("Not a number");
				}
			}
			LogCapture.info("Android user re-entered Pin successfully..."+data);
		}
	}		

	@When("^android user click on Profile Icon on mason dashboard screen$")
	public void android_user_click_on_Profile_Icon_on_Individual_mason_dashboard_screen() throws Throwable 
	{
		String vObjIndMasonProfileIcon = Constants.ANDROIDMasonsOR.getProperty("IndMasonProfileIcon");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIndMasonProfileIcon));
		Assert.assertEquals("PASS", Constants.key.click(vObjIndMasonProfileIcon));
		LogCapture.info("Android user clicked on Profile Icon...");
	}
	
	@Then("^android user land on mason Profile screen$")
	public void android_user_land_on_mason_Profile_screen() throws Throwable 
	{
		String vObjIndMasonProfileScreen = Constants.ANDROIDMasonsOR.getProperty("IndMasonProfileScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjIndMasonProfileScreen));
		LogCapture.info("Android user is on mason profile screen...");
	}
	
	@Then("^android user land on (Pin created for mason|Pin changed for mason|Pin Removed for mason) screen$")
	public void android_user_is_on_Individual_mason_Profile_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Pin created for individual mason"))
		{
			String vObjPinSetSuccessForIM = Constants.ANDROIDMasonsOR.getProperty("PinSetSuccessForIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPinSetSuccessForIM));
			String vPinSuccessTXT = Constants.key.readText(vObjPinSetSuccessForIM);
			System.out.println(vPinSuccessTXT);
			LogCapture.info("Android user is on Pin created successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Pin changed for individual mason"))
		{
			String vObjPinChangedScreenIM = Constants.ANDROIDMasonsOR.getProperty("PinChangedScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPinChangedScreenIM));
			String vPinChangedTXT = Constants.key.readText(vObjPinChangedScreenIM);
			System.out.println(vPinChangedTXT);
			LogCapture.info("Android user is on Pin changed successfully screen...");
		}
		else if(optionValue.equalsIgnoreCase("Pin Removed for individual mason"))
		{
			String vObjPinRemovedScreenIM = Constants.ANDROIDMasonsOR.getProperty("PinRemovedScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPinRemovedScreenIM));
			String vPinRemovedTXT = Constants.key.readText(vObjPinRemovedScreenIM);
			System.out.println(vPinRemovedTXT);
			LogCapture.info("Android user is on Pin removed successfully screen...");
		}
	}
	
	@When("^android user click on (Set|Change|Disable) Pin option on Individual mason Profile screen$")
	public void android_user_click_on_Set_Pin_option_on_Individual_mason_Profile_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Set"))
		{
			String vObjSetPinOptnProfileScreen = Constants.ANDROIDMasonsOR.getProperty("SetPinOptnProfileScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSetPinOptnProfileScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjSetPinOptnProfileScreen));
			LogCapture.info("Android user clicked on Set Pin option on profile screen...");
		}		
		else if(optionValue.equalsIgnoreCase("Change"))
		{
			String vObjChangePinOptnIM = Constants.ANDROIDMasonsOR.getProperty("ChangePinOptnIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChangePinOptnIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjChangePinOptnIM));
			LogCapture.info("Android user clicked on Change Pin option on profile screen...");
		}
		else if(optionValue.equalsIgnoreCase("Disable"))
		{
			String vObjDisablePinToggleIM = Constants.ANDROIDMasonsOR.getProperty("DisablePinToggleIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDisablePinToggleIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjDisablePinToggleIM));
			LogCapture.info("Android user clicked on Disable Pin option on profile screen...");
		}
	}
	
	@When("^android user click on Close button on Pin created screen$")
	public void android_user_click_on_CLose_button_on_Pin_created_screen() throws Throwable 
	{
		String vObjCloseBtnOnPinCreatedScreen = Constants.ANDROIDMasonsOR.getProperty("CloseBtnOnPinCreatedScreen");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseBtnOnPinCreatedScreen));
		Assert.assertEquals("PASS", Constants.key.click(vObjCloseBtnOnPinCreatedScreen));
		LogCapture.info("Android user clicked on Close button on Pin created  screen...");
	}
	
	@When("^android user click on Add ACH Account on Individual mason Profile screen$")
	public void android_user_click_on_Add_ACH_Account_on_Individual_mason_Profile_screen() throws Throwable 
	{
		String vObjAddACHAccOptnIM = Constants.ANDROIDMasonsOR.getProperty("AddACHAccOptnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddACHAccOptnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjAddACHAccOptnIM));
		LogCapture.info("Android user clicked on Add Ach Account option...");
	}
	
	@When("^andrid user click on Add ACH button in IM app$")
	public void andrid_user_click_on_Add_ACH_button_in_IM_app() throws Throwable 
	{
			String vObjAddACHAccBtnIM = Constants.ANDROIDMasonsOR.getProperty("AddACHAccBtnIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddACHAccBtnIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddACHAccBtnIM));
			LogCapture.info("Android user clicked on Add ACH Account button...");	
	}
	
	@Then("^android user land on (Add ACH Accounts|Ach account created) screen in IM app$")
	public void android_user_land_on_Add_ACH_Account_screen_in_IM_app(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Add ACH Accounts"))
		{
			String vObjAddACHAccountScreenIM = Constants.ANDROIDMasonsOR.getProperty("AddACHAccountScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddACHAccountScreenIM));
			LogCapture.info("Android user is on Ach Accounts screen...");
		}
		else if(optionValue.equalsIgnoreCase("Ach account created"))
		{
			String vObjAchAccCreatedIM = Constants.ANDROIDMasonsOR.getProperty("AchAccCreatedIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchAccCreatedIM));
			String vAchCreatedTxtIM = Constants.key.readText(vObjAchAccCreatedIM);
			System.out.println(vAchCreatedTxtIM);
			LogCapture.info("Android user is on Ach Account Created screen...");
		}
	}
	
	@When("^android user scroll till Debitors Account Info (section|state input) display$")
	public void android_user_swipe_till_Debitors_Account_Info_section_display(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("section"))
		{
			String vTXT = "Continue";
			Constants.key.scrollDownUI(vTXT);
			LogCapture.info("Android user perform scroll action till Debitor's Account Info display...");
		}
		else if(optionValue.equalsIgnoreCase("state input"))
		{
			String vTXT = "State";
			Constants.key.scrollDownUI(vTXT);
			LogCapture.info("Android user perform scroll action till Debitor's Account Info state input display...");
		}
	}
	
	@When("^android user click on Continue button on Add Ach Account screen in IM app$")
	public void android_user_click_on_Continue_button_on_Add_Ach_Account_screen_in_IM_app() throws Throwable 
	{
		String vObjContinueBtnAchIM = Constants.ANDROIDMasonsOR.getProperty("ContinueBtnAchIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtnAchIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtnAchIM));
		LogCapture.info("Android user clicked on Continue button...");
	}
	
	@When("^android user click on Go To Dashboard button in IM app$")
	public void android_user_click_on_Go_To_Dashboard_button_in_IM_app() throws Throwable 
	{
		String vObjGoToDashboardBtnIM = Constants.ANDROIDMasonsOR.getProperty("GoToDashboardBtnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGoToDashboardBtnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjGoToDashboardBtnIM));
		LogCapture.info("Android user clicked on Go To Dashboard button...");
	}
	
	@When("^android user enters the Debitors (Identification|Middle name|Address Line two|State|Institution Identification|Identification CardNo) in IM app\"([^\"]*)\"$")
	public void android_user_enters_the_Ach_Debitors_Identification_in_IM_app(String optionValue , String data) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Identification"))
		{
			String vObjDebtIdentificationIM = Constants.ANDROIDMasonsOR.getProperty("DebtIdentificationIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebtIdentificationIM));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebtIdentificationIM, data));
			LogCapture.info("Android user entered the Debitors Identification..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Middle name"))
		{
			String vObjDebtMiddleNameInputIM = Constants.ANDROIDMasonsOR.getProperty("DebtMiddleNameInputIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebtMiddleNameInputIM));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebtMiddleNameInputIM, data));
			LogCapture.info("Android user entered the Debitors Middle Name..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Address Line two"))
		{
			String vObjDebtAddLine2InputIM = Constants.ANDROIDMasonsOR.getProperty("DebtAddLine2InputIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebtAddLine2InputIM));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebtAddLine2InputIM, data));
			LogCapture.info("Android user entered the Debitors Address Line2..."+data);
		}
		else if(optionValue.equalsIgnoreCase("State"))
		{
			String vObjDebtStateInputIM = Constants.ANDROIDMasonsOR.getProperty("DebtStateInputIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebtStateInputIM));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebtStateInputIM, data));
			LogCapture.info("Android user entered the Debitors State..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Institution Identification"))
		{
			String vObjInstIdenIM = Constants.ANDROIDMasonsOR.getProperty("InstIdenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjInstIdenIM));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjInstIdenIM, data));
			LogCapture.info("Android user entered the Institution Identification..."+data);
		}
		else if(optionValue.equalsIgnoreCase("Identification CardNo"))
		{
			String vObjDebtIdenCardNoIM = Constants.ANDROIDMasonsOR.getProperty("DebtIdenCardNoIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebtIdenCardNoIM));
			Assert.assertEquals("PASS", Constants.key.writeInInput(vObjDebtIdenCardNoIM, data));
			LogCapture.info("Android user entered the Identification as card No..."+data);
		}
	}
	
	@Then("^android user verify newly created Ach account card\"([^\"]*)\"$")
	public void android_user_verify_newly_created_Ach_account_card(String data) throws Throwable 
	{
		String vLastFourDigit = Constants.key.lastDigits(data);
		
		String vObjAchAccListIM = Constants.ANDROIDMasonsOR.getProperty("AchAccListIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchAccListIM));
		
		List<MobileElement> achAccList = Constants.key.getElementList(vObjAchAccListIM);
		int achCardSize = achAccList.size();
		//System.out.println(achCardSize);
		
		for(int i=0 ; i<achCardSize ; i++)
		{
			String cardNoTxt = achAccList.get(i).getText();
			//System.out.println(cardNoTxt);
			String actCardLastDigits = Constants.key.lastDigits(cardNoTxt);
			//System.out.println(actCardLastDigits);
			if(actCardLastDigits.equalsIgnoreCase(vLastFourDigit))
			{
				LogCapture.info("Ach Account displayed on ACH Accounts screen...");
			}
			else
			{
				LogCapture.info("Ach Account is not displayed on ACH Accounts screen...");
			}
		}
	}
	
	@Then("^android user click on (Manage Balance|CONFIRM TRANSFER) button in IM app$")
	public void android_user_click_on_Manage_Balance_button_in_IM_app(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Manage Balance"))
		{
			String vObjManageBalanceBtnIM = Constants.ANDROIDMasonsOR.getProperty("ManageBalanceBtnIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjManageBalanceBtnIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjManageBalanceBtnIM));
			LogCapture.info("Android user clicked on Manage Balance button...");
		}
		else if(optionValue.equalsIgnoreCase("CONFIRM TRANSFER"))
		{
			String vObjCONFIRMTRANSFERBtnIM = Constants.ANDROIDMasonsOR.getProperty("CONFIRMTRANSFERBtnIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCONFIRMTRANSFERBtnIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjCONFIRMTRANSFERBtnIM));
			LogCapture.info("Android user clicked on CONFIRM TRANSFER button...");
		}
	}
	
	@Then("^android user land on (Add Money|Debitors Account Info|Confirm Your Transfer|Money Added screen through ACH|BANK REMOVED) screen in IM app$")
	public void android_user_land_on_Add_Money_screen_in_IM_app(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Add Money"))
		{
			String vObjAddMoneyScreenIM = Constants.ANDROIDMasonsOR.getProperty("AddMoneyScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddMoneyScreenIM));
			LogCapture.info("Android user is on Add Money screen...");
		}
		else if(optionValue.equalsIgnoreCase("Debitors Account Info"))
		{
			String vObjDebtAccInfoScreenIM = Constants.ANDROIDMasonsOR.getProperty("DebtAccInfoScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebtAccInfoScreenIM));
			LogCapture.info("Android user is on Debitors Account Info screen...");
		}
		else if(optionValue.equalsIgnoreCase("Confirm Your Transfer"))
		{
			String vObjConfYourTransferScreenIM = Constants.ANDROIDMasonsOR.getProperty("ConfYourTransferScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjConfYourTransferScreenIM));
			LogCapture.info("Android user is on Confirm Your Transfer screen...");
		}
		else if(optionValue.equalsIgnoreCase("Money Added screen through ACH"))
		{
			String vObjMoneyAddedThrghAchIM = Constants.ANDROIDMasonsOR.getProperty("MoneyAddedThrghAchIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMoneyAddedThrghAchIM));
			String vMnyAddedTxt = Constants.key.readText(vObjMoneyAddedThrghAchIM);
			System.out.println(vMnyAddedTxt);
			LogCapture.info("Android user is on Money Added through ACH screen...");
		}
		else if(optionValue.equalsIgnoreCase("BANK REMOVED"))
		{
			String vObjBANKRemovedScreenIM = Constants.ANDROIDMasonsOR.getProperty("BANKRemovedScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBANKRemovedScreenIM));
			String vBANKRMVDTxt = Constants.key.readText(vObjBANKRemovedScreenIM);
			System.out.println(vBANKRMVDTxt);
			Assert.assertEquals("PASS", Constants.key.click(vObjBANKRemovedScreenIM));
			LogCapture.info("Android user is on BANK REMOVED screen...");
		}
	}
	
	@When("^android user click on Bank Account ACH option on Add Money screen in IM app$")
	public void android_user_click_on_Bank_Account_ACH_option_on_Add_Money_screen_in_IM_app() throws Throwable 
	{
		String vObjBankAccACHIM = Constants.ANDROIDMasonsOR.getProperty("BankAccACHIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBankAccACHIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjBankAccACHIM));
		LogCapture.info("Android user clicked on Bank Account (ACH) option...");
	}
	
	@When("^android user enters the Debitors reason in IM app\"([^\"]*)\"$")
	public void android_user_enters_the_Debitors_reason_in_IM_app(String data) throws Throwable 
	{
		String vObjReasonInputDebtAccInfoPageIM = Constants.ANDROIDMasonsOR.getProperty("ReasonInputDebtAccInfoPageIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReasonInputDebtAccInfoPageIM));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjReasonInputDebtAccInfoPageIM, data));
		LogCapture.info("Android user entered Reason successfully..."+data);
	}
	
	@When("^android user enters the Amount to Add in IM account\"([^\"]*)\"$")
	public void android_user_enters_the_Amount_to_Add_in_IM_account(String data) throws Throwable 
	{
		String vObjAmntInputDebtAccInfoPageIM = Constants.ANDROIDMasonsOR.getProperty("AmntInputDebtAccInfoPageIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAmntInputDebtAccInfoPageIM));
		Assert.assertEquals("PASS", Constants.key.clearText(vObjAmntInputDebtAccInfoPageIM));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAmntInputDebtAccInfoPageIM, data));
		LogCapture.info("Android user entered Amount successfully..."+data);
	}
	
	@When("^android user click on Submit button on Debitors Account Info screen in IM app$")
	public void android_user_click_on_Submit_button_on_Debitors_Account_Info_screen_in_IM_app() throws Throwable 
	{
		String vObjSubmitBtnDAIScreenIM = Constants.ANDROIDMasonsOR.getProperty("SubmitBtnDAIScreenIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSubmitBtnDAIScreenIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjSubmitBtnDAIScreenIM));
		LogCapture.info("Android user clicked on Submit button...");
	}
	
	@When("^android user click on GO TO DASHBOARD button on Money Added screen in IM app$")
	public void android_user_click_on_GO_TO_DASHBOARD_button_on_Money_Added_screen_in_IM_app() throws Throwable 
	{
		String vObjGOTODASHMnyAddedScreenIM = Constants.ANDROIDMasonsOR.getProperty("GOTODASHMnyAddedScreenIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGOTODASHMnyAddedScreenIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjGOTODASHMnyAddedScreenIM));
		LogCapture.info("Android user clicked on GO TO DASHBOARD button...");
	}
	
	@When("^android user select Ach Account card base on \"([^\"]*)\"$")
	public void android_user_select_Ach_Account_card_base_on(String data) throws Throwable 
	{
	    String vExpLastDigits = Constants.key.lastDigits(data);
	    
	    String vObjAchAccListIM = Constants.ANDROIDMasonsOR.getProperty("AchAccListIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAchAccListIM));
		
		List<MobileElement> achAccList = Constants.key.getElementList(vObjAchAccListIM);
		int achCardSize = achAccList.size();
		//System.out.println(achCardSize);
		
		for(int i=0 ; i<achCardSize ; i++)
		{
			String cardNoTxt = achAccList.get(i).getText();
			//System.out.println(cardNoTxt);
			String actCardLastDigits = Constants.key.lastDigits(cardNoTxt);
			//System.out.println(actCardLastDigits);
			if(actCardLastDigits.equalsIgnoreCase(vExpLastDigits))
			{
				achAccList.get(i).click();
				LogCapture.info("Android user selected the ACH Account..."+data);
				break;
			}
			else 
			{
				LogCapture.info("Android user is not able to select the ACH Account..."+data);
			}
		} 
	}
	
	@When("^android user select Debit card base on \"([^\"]*)\"$")
	public void android_user_select_Debit_card_base_on(String data) throws Throwable 
	{
		String vDebtLastDigit = Constants.key.lastDigits(data);
		
		String vObjDebitCardListIM = Constants.ANDROIDMasonsOR.getProperty("DebitCardListIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardListIM));
		
		List<MobileElement> debtCardList = Constants.key.getElementList(vObjDebitCardListIM);
		int debtCardListSize = debtCardList.size();
		//System.out.println(debtCardListSize);
		
		for(int i=0 ; i<debtCardListSize ; i++)
		{
			String cardNoTxt = debtCardList.get(i).getText();
			//System.out.println(cardNoTxt);
			String actCardLastDigits = Constants.key.lastDigits(cardNoTxt);
			//System.out.println(actCardLastDigits);
			if(actCardLastDigits.equalsIgnoreCase(vDebtLastDigit))
			{
				debtCardList.get(i).click();
				LogCapture.info("Android user selected the Debit card...");
				break;
			}
			else 
			{
				LogCapture.info("Android user is not able to select the Debit card...");
			}
		}
		
	}
	
	@Then("^android user verify Individual Mason account balance (before|after) adding money$")
	public void android_user_verify_Individual_Mason_account_balance_before_adding_money(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("before"))
		{
			String vObjBalanceTxtIM = Constants.ANDROIDMasonsOR.getProperty("BalanceTxtIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBalanceTxtIM));
			String b = Constants.key.readText(vObjBalanceTxtIM);
			Constants.DataMap.put("Before", b);
		}
		else if(optionValue.equalsIgnoreCase("after"))
		{
			String vObjBalanceTxtIM = Constants.ANDROIDMasonsOR.getProperty("BalanceTxtIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBalanceTxtIM));
			String a = Constants.key.readText(vObjBalanceTxtIM);
			Constants.DataMap.put("After", a);
			System.out.println("Account Balance Is : "+Constants.DataMap);
		}
	}
	
	@When("^android user click on Delete Icon on Ach Account screen$")
	public void android_user_click_on_Delete_Icon_on_Ach_Account_screen() throws Throwable 
	{
		String vObjDeleteBtnACHAccIM = Constants.ANDROIDMasonsOR.getProperty("DeleteBtnACHAccIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDeleteBtnACHAccIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjDeleteBtnACHAccIM));
		LogCapture.info("Android user clicked on Delete Icon button...");
	}
	
	@When("^android user enters the Amount through keypad in IM app \"([^\"]*)\"$")
	public void android_user_enters_the_Amount_through_keypad_in_IM_app(String data) throws Throwable 
	{
		String amount = data;
		String str[] = amount.split("");
		for (int i = 0; i < str.length; i++) 
		{
			Constants.TempData = str[i];
			switch (Constants.TempData) 
			{
			case "1":
				System.out.println("1");
				String vObjOne = Constants.ANDROIDMasonsOR.getProperty("One");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjOne));
				Assert.assertEquals("PASS", Constants.key.click(vObjOne));
				break;
			case "2":
				System.out.println("2");
				String vObjTwo = Constants.ANDROIDMasonsOR.getProperty("Two");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTwo));
				Assert.assertEquals("PASS", Constants.key.click(vObjTwo));
				break;
			case "3":
				System.out.println("3");
				String vObjThree = Constants.ANDROIDMasonsOR.getProperty("Three");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjThree));
				Assert.assertEquals("PASS", Constants.key.click(vObjThree));
				break;
			case "4":
				System.out.println("4");
				String vObjFour = Constants.ANDROIDMasonsOR.getProperty("Four");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFour));
				Assert.assertEquals("PASS", Constants.key.click(vObjFour));
				break;
			case "5":
				System.out.println("5");
				String vObjFive = Constants.ANDROIDMasonsOR.getProperty("Five");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjFive));
				Assert.assertEquals("PASS", Constants.key.click(vObjFive));
				break;
			case "6":
				System.out.println("6");
				String vObjSix = Constants.ANDROIDMasonsOR.getProperty("Six");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSix));
				Assert.assertEquals("PASS", Constants.key.click(vObjSix));
				break;
			case "7":
				System.out.println("7");
				String vObjSeven = Constants.ANDROIDMasonsOR.getProperty("Seven");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeven));
				Assert.assertEquals("PASS", Constants.key.click(vObjSeven));
				break;
			case "8":
				System.out.println("8");
				String vObjEight = Constants.ANDROIDMasonsOR.getProperty("Eight");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjEight));
				Assert.assertEquals("PASS", Constants.key.click(vObjEight));
				break;
			case "9":
				System.out.println("9");
				String vObjNine = Constants.ANDROIDMasonsOR.getProperty("Nine");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjNine));
				Assert.assertEquals("PASS", Constants.key.click(vObjNine));
				break;
			case "0":
				System.out.println("0");
				String vObjZero = Constants.ANDROIDMasonsOR.getProperty("Zero");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjZero));
				Assert.assertEquals("PASS", Constants.key.click(vObjZero));
				break;
			case ".":
				System.out.println(".");
				String vObjDott = Constants.ANDROIDMasonsOR.getProperty("Dott");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDott));
				Assert.assertEquals("PASS", Constants.key.click(vObjDott));
				break;
			default:
				System.out.println("Not a number");
			}
		}
		LogCapture.info("Android user entered amount successfully..."+data);
	}
	
	@When("^android user click on (Request Money|Send Money|Money Requested) option on IM dashboard screen$")
	public void android_user_click_on_Request_Money_option_on_IM_dashboard_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Request Money"))
		{
			String vObjReqMnyOptnDashScreenIM = Constants.ANDROIDMasonsOR.getProperty("ReqMnyOptnDashScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqMnyOptnDashScreenIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjReqMnyOptnDashScreenIM));
			LogCapture.info("Android user clicked on Request Money option...");
		}
		else if(optionValue.equalsIgnoreCase("Send Money"))
		{
			String vObjSendMnyOptnDashPageIM = Constants.ANDROIDMasonsOR.getProperty("SendMnyOptnDashPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMnyOptnDashPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjSendMnyOptnDashPageIM));
			LogCapture.info("Android user clicked on Send Money option...");
		}
		else if(optionValue.equalsIgnoreCase("Money Requested"))
		{
			String vObjMnyReqOptnDasgPageIM = Constants.ANDROIDMasonsOR.getProperty("MnyReqOptnDasgPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMnyReqOptnDasgPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjMnyReqOptnDasgPageIM));
			LogCapture.info("Android user clicked on Money Requested option...");
		}
	}
	
	@Then("^android user land on (Request Money From|Send Money From|Send From|Send Money To|Choose Beneficiary|Money Requested) screen in IM app$")
	public void android_user_land_on_Request_Money_From_screen_in_IM_app(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Request Money From"))
		{
			String vObjReqMnyScreenIM = Constants.ANDROIDMasonsOR.getProperty("ReqMnyScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqMnyScreenIM));
			LogCapture.info("Android user is on Request Money From screen...");
		}
		else if(optionValue.equalsIgnoreCase("Send Money From"))
		{
			String vObjSendMnyScreenIM = Constants.ANDROIDMasonsOR.getProperty("SendMnyScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMnyScreenIM));
			LogCapture.info("Android user is on Send Money From screen...");
		}
		else if(optionValue.equalsIgnoreCase("Send From"))
		{
			String vObjSendFromPageIM = Constants.ANDROIDMasonsOR.getProperty("SendFromPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendFromPageIM));
			LogCapture.info("Android user is on Send From screen...");
		}
		else if(optionValue.equalsIgnoreCase("Send Money To"))
		{
			String vObjSendMoneyToScreenIM = Constants.ANDROIDMasonsOR.getProperty("SendMoneyToScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyToScreenIM));
			LogCapture.info("Android user is on Send Money To screen...");
		}
		else if(optionValue.equalsIgnoreCase("Choose Beneficiary"))
		{
			String vObjChooseBeneScreenIM = Constants.ANDROIDMasonsOR.getProperty("ChooseBeneScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjChooseBeneScreenIM));
			LogCapture.info("Android user is on Choose Beneficiary screen...");
		}
		else if(optionValue.equalsIgnoreCase("Money Requested"))
		{
			String vObjMnyReqScreenIM = Constants.ANDROIDMasonsOR.getProperty("MnyReqScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMnyReqScreenIM));
			LogCapture.info("Android user is on Money Requested screen...");
		}
	}
	
	@When("^android user select mason option on Request Money From screen in IM app$")
	public void android_user_select_mason_option_on_Request_Money_From_screen_in_IM_app() throws Throwable 
	{
		String vObjReqMnyMtoMOptnIM = Constants.ANDROIDMasonsOR.getProperty("ReqMnyMtoMOptnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqMnyMtoMOptnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjReqMnyMtoMOptnIM));
		LogCapture.info("Android user clicked on mason option...");
	}
	
	@When("^android user enters the note for request the money in IM app \"([^\"]*)\"$")
	public void android_user_enters_the_note_for_request_the_money_in_IM_app(String data) throws Throwable 
	{
		String vObjAddNoteReqMntIM = Constants.ANDROIDMasonsOR.getProperty("AddNoteReqMntIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddNoteReqMntIM));
		Assert.assertEquals("PASS", Constants.key.writeInInput(vObjAddNoteReqMntIM, data));
		LogCapture.info("Android user entered note successfully..."+data);
	}
	
	@When("^android user click on CONTINUE button on keypad screen$")
	public void android_user_click_on_CONTINUE_button_on_keypad_screen() throws Throwable 
	{
		String vObjContinueBtnKeypadScreenIM = Constants.ANDROIDMasonsOR.getProperty("ContinueBtnKeypadScreenIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtnKeypadScreenIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtnKeypadScreenIM));
		LogCapture.info("Android user clicked on CONTINUE button...");
	}
	
	@Then("^android user land on (Request Money|Send Money) confirmation screen$")
	public void android_user_land_on_Request_Money_confirmation_screen(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Request Money"))
		{
			String vObjReqMnyConfScreenIM = Constants.ANDROIDMasonsOR.getProperty("ReqMnyConfScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqMnyConfScreenIM));
			LogCapture.info("Android user is on Request Money confirmation screen...");
		}
		else if(optionValue.equalsIgnoreCase("Send Money"))
		{
			String vObjSendMoneyConfScreenIM = Constants.ANDROIDMasonsOR.getProperty("SendMoneyConfScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSendMoneyConfScreenIM));
			LogCapture.info("Android user is on Send Money confirmation screen...");
		}
	}
	
	@When("^android user click on REQUEST NOW button on Request Money screen$")
	public void android_user_click_on_REQUEST_NOW_button_on_Request_Money_screen() throws Throwable 
	{
		String vObjREQUESTNOWBtnIM = Constants.ANDROIDMasonsOR.getProperty("REQUESTNOWBtnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjREQUESTNOWBtnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjREQUESTNOWBtnIM));
		LogCapture.info("Android user clicked on REQUEST NOW button...");
	}
	
	@Then("^android user land on Money Request SENT screen in IM app$")
	public void android_user_land_on_Money_Request_SENT_screen_in_IM_app() throws Throwable 
	{
		String vObjReqSENTPageIM = Constants.ANDROIDMasonsOR.getProperty("ReqSENTPageIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqSENTPageIM));
		String vReqSentTxt = Constants.key.readText(vObjReqSENTPageIM);
		System.out.println(vReqSentTxt);
		LogCapture.info("Android user is on Money Request SENT screen...");
	}
	
	@When("^android user click on Back Arrow button on SENT screen$")
	public void android_user_click_on_Back_Arrow_button_on_SENT_screen() throws Throwable 
	{
		String vObjBackArrowBtnIM = Constants.ANDROIDMasonsOR.getProperty("BackArrowBtnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBackArrowBtnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjBackArrowBtnIM));
		LogCapture.info("Android user clicked on Back Arrow button...");		
	}
	
	@When("^android user select the beneficiary base on name \"([^\"]*)\" and email \"([^\"]*)\" in IM app$")
	public void android_user_select_the_beneficiary_base_on_name_and_email_in_IM_app(String name, String email) throws Throwable 
	{
		String vName = Constants.ANDROIDTestData.getProperty(name);
		String vEmail = Constants.ANDROIDTestData.getProperty(email);
		//System.out.println(vName + vEmail);
		try
		{
			String vObjBenefNameListIM = Constants.ANDROIDMasonsOR.getProperty("BenefNameListIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBenefNameListIM));
		
			int nameListSize = Constants.key.getElementList(vObjBenefNameListIM).size();
			//System.out.println(nameListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjBenefNameListIM);
			for (int i = 0; i < nameListSize; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if (val.equalsIgnoreCase(vName))
				{
					String vObjBeneEmailListIM = Constants.ANDROIDMasonsOR.getProperty("BeneEmailListIM");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjBeneEmailListIM));
				
					int emailListSize = Constants.key.getElementList(vObjBeneEmailListIM).size();
					List<MobileElement> lists1 = Constants.key.getElementList(vObjBeneEmailListIM);
					
					for (int j = 0; j < emailListSize; j++) 
					{
						String val1 = lists1.get(j).getText();
						//System.out.println(val1);
						if (val1.equalsIgnoreCase(vEmail))
						{
							lists1.get(j).click();
							break;
						}
					}
				}
			}
			LogCapture.info("Android user selected beneficiary successfully name is "+vName+ " and email is "+vEmail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	@When("^android user click on See All option to see all Transactions$")
	public void android_user_click_on_See_All_option_to_see_all_Transactions() throws Throwable 
	{
		String vObjSeeAllOptnDashScreenIM = Constants.ANDROIDMasonsOR.getProperty("SeeAllOptnDashScreenIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSeeAllOptnDashScreenIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjSeeAllOptnDashScreenIM));
		LogCapture.info("Android user clicked on See All option to see the list of Transactions...");
	}
	
	@Then("^android user land on (Transactions|request deleted) screen in IM app$")
	public void android_user_land_on_Transactions_screen_in_IM_app(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("Transactions"))
		{
			String vObjTransactionsScreenIM = Constants.ANDROIDMasonsOR.getProperty("TransactionsScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsScreenIM));
			LogCapture.info("Android user is on Transactions screen...");
		}
		else if(optionValue.equalsIgnoreCase("request deleted"))
		{
			String vObjReqDeletedScreenIM = Constants.ANDROIDMasonsOR.getProperty("ReqDeletedScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqDeletedScreenIM));
			String vReqDelTxt = Constants.key.readText(vObjReqDeletedScreenIM);
			System.out.println(vReqDelTxt);
			Assert.assertEquals("PASS", Constants.key.click(vObjReqDeletedScreenIM));
			LogCapture.info("Android user is on Request Deleted screen...");
		}
	}
	
	@When("^android user select the transaction request base on note \"([^\"]*)\" and amount \"([^\"]*)\" and click on delete in IM app$")
	public void android_user_select_the_transaction_request_base_on_note_and_amount_and_click_on_delete_in_IM_app(String reqData, String reqAmt) throws Throwable 
	{
		try
		{
			String vObjTransactionsReasonTxtIM = Constants.ANDROIDMasonsOR.getProperty("TransactionsReasonTxtIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsReasonTxtIM));
		
			int reqListSize = Constants.key.getElementList(vObjTransactionsReasonTxtIM).size();
			//System.out.println(reqListSize);
			List<MobileElement> lists = Constants.key.getElementList(vObjTransactionsReasonTxtIM);
			for (int i = 0; i < reqListSize; i++)
			{
				String val = lists.get(i).getText();
				//System.out.println(val);
				if (val.equalsIgnoreCase(reqData))
				{
					String vObjTransactionsAmountTxtIM = Constants.ANDROIDMasonsOR.getProperty("TransactionsAmountTxtIM");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTransactionsAmountTxtIM));
					
					String vObjDeleteReqBtnIM = Constants.ANDROIDMasonsOR.getProperty("DeleteReqBtnIM");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDeleteReqBtnIM));
				
					int TransactionAmountSize = Constants.key.getElementList(vObjTransactionsAmountTxtIM).size();
					
					List<MobileElement> lists2 = Constants.key.getElementList(vObjDeleteReqBtnIM);
					List<MobileElement> lists1 = Constants.key.getElementList(vObjTransactionsAmountTxtIM);
					for (int j = 0; j < TransactionAmountSize; j++) 
					{
						String val1 = lists1.get(j).getText();
						//System.out.println(val1);
						if (val1.equalsIgnoreCase(reqAmt))
						{
							lists2.get(j).click();
							LogCapture.info("Android user selected the specified request and clicked on Delete icon...");
							break;
						}
					}
				}
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^android user click on PtP Transfer option on Send Money screen in IM app$")
	public void android_user_click_on_PtP_Transfer_option_on_Send_Money_screen_in_IM_app() throws Throwable 
	{
		String vObjPtPTransferOptnIM = Constants.ANDROIDMasonsOR.getProperty("PtPTransferOptnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPtPTransferOptnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjPtPTransferOptnIM));
		LogCapture.info("Android user clicked on P2P Transfer option...");
	}
	
	@When("^android user click on Quick Money Wallet radio button on Send From screen in IM app$")
	public void android_user_click_on_Quick_Money_Wallet_radio_button_on_Send_From_screen_in_IM_app() throws Throwable 
	{
		String vObjQuickMnyWalletOptnIM = Constants.ANDROIDMasonsOR.getProperty("QuickMnyWalletOptnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjQuickMnyWalletOptnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjQuickMnyWalletOptnIM));
		LogCapture.info("Android user clicked on Quick Money Wallet radio button...");
	}
	
	@When("^android user click on CONFIRMATION buton on Send From screen in IM app$")
	public void android_user_click_on_CONFIRMATION_buton_on_Send_From_screen_in_IM_app() throws Throwable 
	{
		String vObjCONFIRMATIONBtnSendFromPageIM = Constants.ANDROIDMasonsOR.getProperty("CONFIRMATIONBtnSendFromPageIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCONFIRMATIONBtnSendFromPageIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjCONFIRMATIONBtnSendFromPageIM));
		LogCapture.info("Android user clicked on CONFIRMATION buton...");
	}
	
	@When("^android user click on (mason|lodge|grand lodge) option on Send Money To screen in IM app$")
	public void android_user_click_on_mason_option_on_Send_Money_To_screen_in_IM_app(String optionValue) throws Throwable 
	{
		if(optionValue.equalsIgnoreCase("mason"))
		{
			String vObjMasonOptnSendMnyPageIM = Constants.ANDROIDMasonsOR.getProperty("MasonOptnSendMnyPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMasonOptnSendMnyPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjMasonOptnSendMnyPageIM));
			LogCapture.info("Android user selected the Mason option...");
		}
		else if(optionValue.equalsIgnoreCase("lodge"))
		{
			String vObjLodgeOptnSendMnyPageIM = Constants.ANDROIDMasonsOR.getProperty("LodgeOptnSendMnyPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLodgeOptnSendMnyPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjLodgeOptnSendMnyPageIM));
			LogCapture.info("Android user selected the lodge option...");
		}
		else if(optionValue.equalsIgnoreCase("grand lodge"))
		{
			String vObjGrandLodgeOptnSendMnyPageIM = Constants.ANDROIDMasonsOR.getProperty("GrandLodgeOptnSendMnyPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGrandLodgeOptnSendMnyPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjGrandLodgeOptnSendMnyPageIM));
			LogCapture.info("Android user selected the grand lodge option...");
		}
	}
	
	@When("^android user click on SEND NOW button on Send Money screen$")
	public void android_user_click_on_SEND_NOW_button_on_Send_Money_screen() throws Throwable 
	{
		String vObjSENDNOWBtnIM = Constants.ANDROIDMasonsOR.getProperty("SENDNOWBtnIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjSENDNOWBtnIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjSENDNOWBtnIM));
		LogCapture.info("Android user clicked on SEND NOW button...");
	}
	
	@Then("^android user land on Transfer Done screen in IM app$")
	public void android_user_land_on_Transfer_Done_screen_in_IM_app() throws Throwable 
	{
		String vObjTransferDonePageIM = Constants.ANDROIDMasonsOR.getProperty("TransferDonePageIM");
		Assert.assertEquals("PASS" ,Constants.key.eleLocatedDisplayed(vObjTransferDonePageIM));
		String vTFDoneTxt = Constants.key.readText(vObjTransferDonePageIM);
		System.out.println(vTFDoneTxt);
		LogCapture.info("Android user is on Transfer Done screen...");
	}
	
	@When("^android user select the beneficiary base on (lodge|grand lodge) name \"([^\"]*)\" in IM app$")
	public void android_user_select_the_beneficiary_base_on_lodge_name_in_IM_app(String optionValue , String data) throws Throwable 
	{
		String vLodgeName = Constants.ANDROIDTestData.getProperty(data);
		if(optionValue.equalsIgnoreCase("lodge"))
		{
			try
			{
				String vObjLodgeNameListIM = Constants.ANDROIDMasonsOR.getProperty("LodgeNameListIM");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLodgeNameListIM));
				
				List<MobileElement> lodgeList = Constants.key.getElementList(vObjLodgeNameListIM);
				int lodgeListSize = lodgeList.size();
				//System.out.println(lodgeListSize);
				
				for(int i=0; i<lodgeListSize ; i++)
				{
					String actLodTxt = lodgeList.get(i).getText();
					//System.out.println(actLodTxt);
					if(actLodTxt.trim().equalsIgnoreCase(vLodgeName.trim()))
					{
						lodgeList.get(i).click();
						LogCapture.info("Android user selected the specified Lodge..."+vLodgeName);
						break;
					}
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				LogCapture.info("Android user is not able to select the specified Lodge..."+vLodgeName);
			}
		}
		else if(optionValue.equalsIgnoreCase("grand lodge"))
		{
			try
			{
				String vObjLodgeNameListIM = Constants.ANDROIDMasonsOR.getProperty("LodgeNameListIM");
				Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLodgeNameListIM));
				
				List<MobileElement> lodgeList = Constants.key.getElementList(vObjLodgeNameListIM);
				int lodgeListSize = lodgeList.size();
				//System.out.println(lodgeListSize);
				
				for(int i=0; i<lodgeListSize ; i++)
				{
					String actLodTxt = lodgeList.get(i).getText();
					//System.out.println(actLodTxt);
					if(actLodTxt.trim().equalsIgnoreCase(vLodgeName.trim()))
					{
						lodgeList.get(i).click();
						LogCapture.info("Android user selected the specified grand Lodge..."+vLodgeName);
						break;
					}
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				LogCapture.info("Android user is not able to select the specified grand Lodge..."+vLodgeName);
			}
		}		
	}
	
	@Then("^adnroid user close the mason application$")
	public void adnroid_user_close_the_mason_application() throws Throwable 
	{
		Constants.key.quitApp();
		LogCapture.info("Android user closed the mason application...");
	}
	
	@Then("^android user land on What do you want to do screen in IM app$")
	public void android_user_land_on_What_do_you_want_to_do_screen_in_IM_app() throws Throwable 
	{
		String vObjWhatDoYouWantToDoPageIM = Constants.ANDROIDMasonsOR.getProperty("WhatDoYouWantToDoPageIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjWhatDoYouWantToDoPageIM));
		LogCapture.info("Android user is on What do you want to do screen?...");
	}
	
	@When("^android click on Cross icon for refuse the money request$")
	public void android_click_on_Cross_icon_for_refuse_the_money_request() throws Throwable 
	{
		String vObjCrossRefuseReqIconIM = Constants.ANDROIDMasonsOR.getProperty("CrossRefuseReqIconIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCrossRefuseReqIconIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjCrossRefuseReqIconIM));
		LogCapture.info("Android user clicked on Cross icon for refuse the money request...");
	}
	
	@Then("^android user land on money Request deleted screen in IM app$")
	public void android_user_land_on_money_Request_deleted_screen_in_IM_app() throws Throwable 
	{
		String vObjReqDeletedScreenIM = Constants.ANDROIDMasonsOR.getProperty("ReqDeletedScreenIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjReqDeletedScreenIM));
		String vReqDeletedTXT = Constants.key.readText(vObjReqDeletedScreenIM);
		System.out.println(vReqDeletedTXT);
		//Put click method once dialog box element is clickable
		LogCapture.info("Android user is on Request Deleted Successfully screen...");
	}
	
	@When("^android user click on device back button$")
	public void android_user_click_on_device_back_button() throws Throwable 
	{
		Constants.key.deviceBackButton();
		LogCapture.info("Android user clicked on Device Back button...");
	}
	
	@When("^android user select the money request base on Note \"([^\"]*)\" and amount \"([^\"]*)\" in IM app$")
	public void android_user_select_the_money_request_base_on_Note_and_amount_in_IM_app(String note, String amount) throws Throwable 
	{
		try
		{
			String vObjRequestNoteListIM = Constants.ANDROIDMasonsOR.getProperty("RequestNoteListIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRequestNoteListIM));
			
			List<MobileElement> noteList = Constants.key.getElementList(vObjRequestNoteListIM);
			int noteListSize = noteList.size();
			//System.out.println(noteListSize);
			
			for(int i=0 ; i<noteListSize ; i++)
			{
				String actNote = noteList.get(i).getText();
				//System.out.println(actNote);
				if(actNote.equalsIgnoreCase(note))
				{
					String vObjRequestedAmntListIM = Constants.ANDROIDMasonsOR.getProperty("RequestedAmntListIM");
					Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjRequestedAmntListIM));
					
					List<MobileElement> reqAmntList = Constants.key.getElementList(vObjRequestedAmntListIM);
					int reqAmntListSize = reqAmntList.size();
					//System.out.println(reqAmntListSize);
					for(int j=0 ; j<reqAmntListSize ; j++)
					{
						String actAmnt = reqAmntList.get(j).getText();
						//System.out.println(actAmnt);
						if(actAmnt.equalsIgnoreCase(amount))
						{
							reqAmntList.get(j).click();
							LogCapture.info("Android user selected the specified request base on note "+note+" and amount "+amount);
						}
					}
				}
			}
		}
		catch (Exception e) 
		{
			LogCapture.info("Android user is not able to select the specified request...");
			e.printStackTrace();
		}
	}
	
	@When("^android click on True Sign icon for Payback the money request$")
	public void android_click_on_True_Sign_icon_for_Payback_the_money_request() throws Throwable 
	{
		String vObjTrueReqAcceptIconIM = Constants.ANDROIDMasonsOR.getProperty("TrueReqAcceptIconIM");
		Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjTrueReqAcceptIconIM));
		Assert.assertEquals("PASS", Constants.key.click(vObjTrueReqAcceptIconIM));
		LogCapture.info("Android user clicked on money request Accept icon...");
	}
	
	// In App steps for ingomoney started
		@When("^android user click on Add Credit Debit Card on Individual mason Profile screen$")
		public void android_user_click_on_Add_Credit_Debit_Card_on_Individual_mason_Profile_screen() throws Throwable 
		{
			String vObjAddCredDebtCardOptnIM = Constants.ANDROIDMasonsOR.getProperty("AddCredDebtCardOptnIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddCredDebtCardOptnIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjAddCredDebtCardOptnIM));
			LogCapture.info("Android user clicked on Add Credit/Debit Card option...");
		}

		@Then("^android user land on My Cards screen in IM app$")
		public void android_user_land_on_My_Cards_screen_in_IM_app() throws Throwable 
		{
			String vObjMyCardScreenIM = Constants.ANDROIDMasonsOR.getProperty("MyCardScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjMyCardScreenIM));
			LogCapture.info("Android user is on My Cards screen...");
		}

		@When("^android user click on Plus button for Add New Card on My Cards screen in IM app$")
		public void android_user_click_on_Plus_button_for_Add_New_Card_on_My_Cards_screen_in_IM_app() throws Throwable 
		{
			String vObjPlusIconMyCardsPageIM = Constants.ANDROIDMasonsOR.getProperty("PlusIconMyCardsPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjPlusIconMyCardsPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjPlusIconMyCardsPageIM));
			Constants.key.pause(50000);
			LogCapture.info("Android user clicked on Plus button...");
		}

		@Then("^android user land on Card has been added screen in IM app$")
		public void android_user_land_on_Card_has_been_added_screen_in_IM_app() throws Throwable 
		{
			String vObjCredDebtCardAddedScreenIM = Constants.ANDROIDMasonsOR.getProperty("CredDebtCardAddedScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCredDebtCardAddedScreenIM));
			String vCardAddedScreenTXT = Constants.key.readText(vObjCredDebtCardAddedScreenIM);
			System.out.println(vCardAddedScreenTXT);
			LogCapture.info("Android user is on Card Added screen...");
		}
		
		@When("^android user click on Close button on Card Created screen in IM app$")
		public void android_user_click_on_Close_button_on_Card_Created_screen_in_IM_app() throws Throwable 
		{
			String vObjCloseBtnCardCreatedPageIM = Constants.ANDROIDMasonsOR.getProperty("CloseBtnCardCreatedPageIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjCloseBtnCardCreatedPageIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjCloseBtnCardCreatedPageIM));
			LogCapture.info("Android user clicked on Close button...");
		}	
		// In App steps for ingomoney ended
		
		/*  Add Money Using Existing Debit Card  in App Code  started */
		@When("^android user click on Debit Card option on Add Money screen in IM app$")
		public void android_user_click_on_Debit_Card_option_on_Add_Money_screen_in_IM_app() throws Throwable 
		{
			String vObjDebitCardOptnIM = Constants.ANDROIDMasonsOR.getProperty("DebitCardOptnIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjDebitCardOptnIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjDebitCardOptnIM));
			LogCapture.info("Android user click on Debit Card option...");
		}

		@When("^android user select the first card by default$")
		public void android_user_select_the_first_card_by_default() throws Throwable 
		{
			String vObjByDefaultFirstCardIM = Constants.ANDROIDMasonsOR.getProperty("ByDefaultFirstCardIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjByDefaultFirstCardIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjByDefaultFirstCardIM));
			LogCapture.info("Android user selected the ingomoney debit card...");
		}

		@Then("^android user land on Add Balance screen in IM app$")
		public void android_user_land_on_Add_Balance_screen_in_IM_app() throws Throwable 
		{
			String vObjAddBalanceScreenIM = Constants.ANDROIDMasonsOR.getProperty("AddBalanceScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjAddBalanceScreenIM));
			LogCapture.info("Android user is on Add Balance screen...");
		}

		@When("^android user click on Continue button on Add Balance screen$")
		public void android_user_click_on_Continue_button_on_Add_Balance_screen() throws Throwable 
		{
			String vObjContinueBtnAddBalScreenIM = Constants.ANDROIDMasonsOR.getProperty("ContinueBtnAddBalScreenIM");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjContinueBtnAddBalScreenIM));
			Assert.assertEquals("PASS", Constants.key.click(vObjContinueBtnAddBalScreenIM));
			LogCapture.info("Android user clicked on Continue button...");
		}

		
		/*   Grand Lodge Step-Def   */
		
		@Then("^android user land on Grand Lodge dashboard screen$")
		public void android_user_land_on_Grand_Lodge_dashboard_screen() throws Throwable 
		{
			String vObjGLDashboardScreen = Constants.ANDROIDMasonsOR.getProperty("GLDashboardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGLDashboardScreen));
			LogCapture.info("Android user is on Grand Lodge dashboard screen...");
		}
		
		@Then("^android user click on Add Money button on GL dashboard screen$")
		public void android_user_click_on_Add_Money_button_on_GL_dashboard_screen() throws Throwable 
		{
			String vObjGLDashboardScreen = Constants.ANDROIDMasonsOR.getProperty("GLDashboardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGLDashboardScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjGLDashboardScreen));
			LogCapture.info("Android user clicked on Add Money button...");
		}
		
		@When("^android user click on the Transactions layout on GL dashboard screen$")
		public void android_user_click_on_the_Transactions_layout_on_GL_dashboard_screen() throws Throwable 
		{
			String vObjGLTransactionsLayout = Constants.ANDROIDMasonsOR.getProperty("GLTransactionsLayout");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGLTransactionsLayout));
			Assert.assertEquals("PASS", Constants.key.click(vObjGLTransactionsLayout));
			LogCapture.info("Android user clicked on Transaction layout...");
		}

		@When("^android user land on Grand lodge Transactions screen$")
		public void android_user_land_on_Grand_lodge_Transactions_screen() throws Throwable 
		{
			String vObjGLTransactionsScreen = Constants.ANDROIDMasonsOR.getProperty("GLTransactionsScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGLTransactionsScreen));
			LogCapture.info("Android user is on Transactions screen...");
		}

		@When("^android user click on Plus button on GL Transactions screen$")
		public void android_user_click_on_Plus_button_on_GL_Transactions_screen() throws Throwable 
		{
			String vObjGLPlusBtnTxnsScreen = Constants.ANDROIDMasonsOR.getProperty("GLPlusBtnTxnsScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGLPlusBtnTxnsScreen));
			Assert.assertEquals("PASS", Constants.key.click(vObjGLPlusBtnTxnsScreen));
			LogCapture.info("Android user clicked on Plus button on Transactions screen...");
		}

		@When("^android user click on GL Send Money button$")
		public void android_user_click_on_GL_Send_Money_button() throws Throwable 
		{
			String vObjGLSendMnyBtn = Constants.ANDROIDMasonsOR.getProperty("GLSendMnyBtn");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjGLSendMnyBtn));
			Assert.assertEquals("PASS", Constants.key.click(vObjGLSendMnyBtn));
			LogCapture.info("Android user clicked on Send Money button...");
		}
		
		/*  Lodge Step def  */
		@Then("^android user land on Lodge dashboard screen$")
		public void android_user_land_on_Lodge_dashboard_screen() throws Throwable 
		{
			String vObjLDashboardScreen = Constants.ANDROIDMasonsOR.getProperty("LDashboardScreen");
			Assert.assertEquals("PASS", Constants.key.eleLocatedDisplayed(vObjLDashboardScreen));
			LogCapture.info("Android user is on Lodge dashboard screen...");
		}
		
}
	

