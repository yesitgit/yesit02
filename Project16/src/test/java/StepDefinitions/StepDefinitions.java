package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.Assert;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions 
{
	
	// New User Registration
	
	@Given("user is on registration page")
	public void user_is_on_registration_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is on registration page");
	}
	@When("user enters new user details {string} and rownumber {int}")
	public void user_enters_new_user_details(String sheetname, Integer rownumber) throws InvalidFormatException, IOException
	{
	    // Write code here that turns the phrase above into concrete actions
		ExcelReader reader = new ExcelReader();

		System.out.println("sheetname: "+sheetname);
		System.out.println("rownumber: "+rownumber);

		List<Map<String, String>> testdata = reader.getData("C:\\Users\\91962\\eclipse-workspace\\Project16\\src\\test\\resources\\TestData\\MockTestData11.xlsx", sheetname);

		
		
		String username = testdata.get(rownumber).get("username");

		String password = testdata.get(rownumber).get("password");

		String ConfirmPassword = testdata.get(rownumber).get("confirm password");
		
		String AccountNo = testdata.get(rownumber).get("account number");
		
		String MobileNo = testdata.get(rownumber).get("mobile number");

		int AccountNumber=(int) Double.parseDouble(AccountNo);  
		int MobileNumber=(int) Double.parseDouble(MobileNo);  
		
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		System.out.println("Confirm Password: "+ConfirmPassword);
		System.out.println("Account Number: "+AccountNumber);
		System.out.println("Mobile Number: "+MobileNumber);
	}
	@And("click on submit button")
	public void click_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on submit button");
	}
	@Then("user registered successfully and move to the login page {string}")
	public void user_registered_successfully_and_move_to_the_login_page(String pagetitle) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user registered successfully and move to the login page: "+pagetitle);
		String actualTitle = "Home Page";
		System.out.println("actualTitle: "+actualTitle);
		System.out.println("pagetitle: "+pagetitle);
	    Assert.assertEquals(pagetitle,actualTitle);
	}

	// User Login
	@Given("User is on Login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on Login page");
	}
	
	@When("user enters username and password details {string} and rownumber {int}")
	public void user_enters_username_and_password_details_and_rownumber(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		ExcelReader reader = new ExcelReader();

		System.out.println("sheetname: "+sheetname);
		System.out.println("rownumber: "+rownumber);

		List<Map<String, String>> testdata = reader.getData("C:\\Users\\91962\\eclipse-workspace\\Project16\\src\\test\\resources\\TestData\\MockTestData11.xlsx", sheetname);

		
		
		String username = testdata.get(rownumber).get("username");

		String password = testdata.get(rownumber).get("password");


		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
	}
	@When("click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on login button");
	}
	@Then("user login successfull and move to the Account Summary page {string}")
	public void user_login_successfull_and_move_to_the_account_summary_page(String pagetitle) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user login successfull and move to the Account Summary page: "+pagetitle);
		String actualTitle = "Account Summary";
		System.out.println("actualTitle: "+actualTitle);
		System.out.println("pagetitle: "+pagetitle);
	    Assert.assertEquals(pagetitle,actualTitle);
	}
	
	// Check Balance
	
	// User is on Account Summary page
	@Given("User is on Account Summary page")
	public void User_is_on_Account_Summary_page() 
	{
	    System.out.println("User is on Account Summary page");
	}
	
	// click on Click here for balance link
	@When("click on Click here for balance link")
	public void click_on_Click_here_for_balance_link() 
	{
		System.out.println("click on Click here for balance link");
	}
	
	// Should display the balance amount "INR 100"
	@Then("Should display the balance amount {string}")
	public void Should_display_the_balance_amount(String balanceamount) 
	{
		System.out.println("Available Balance: "+balanceamount);
	}
		

	// Amount Transfer
	
	Boolean chkStatus = false;
	int handbalance;
	String amtTransferMsg = null;
	
	@Given("User is on Payment Transfer page")
	public void user_is_on_payment_transfer_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on Payment Transfer page");
	}
	@When("user enters transferamt details {string} and rownumber {int}")
	public void user_enters_transferamt_details_and_rownumber(String sheetname, Integer rownumber) throws InvalidFormatException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		ExcelReader reader = new ExcelReader();

		System.out.println("sheetname: "+sheetname);
		System.out.println("rownumber: "+rownumber);

		List<Map<String, String>> testdata = reader.getData("C:\\Users\\91962\\eclipse-workspace\\Project16\\src\\test\\resources\\TestData\\MockTestData11.xlsx", sheetname);

		String transferamount = testdata.get(rownumber).get("Amount");

		String Availablebalance = testdata.get(rownumber).get("AvailableBalance");
		
		String statusmsg = testdata.get(rownumber).get("Status");


		System.out.println("Transfer Amount: "+transferamount);
		System.out.println("Available Balance: "+Availablebalance);
		System.out.println("Status : "+statusmsg);
		
		int tramt1=(int) Double.parseDouble(transferamount);  
		int balan1=(int) Double.parseDouble(Availablebalance);	
		
		
		System.out.println("Transfer Amount1: "+tramt1);
		System.out.println("Available Balance1: "+balan1);
		handbalance = balan1;
		
		if((tramt1<=balan1) && (balan1!=50))
		{
			System.out.println("if part");
			handbalance = handbalance - tramt1;
			System.out.println("handBalance inside if part: "+handbalance);
			chkStatus = true;
		}
		
		amtTransferMsg = statusmsg;
		
	}
	@When("User select the bank account")
	public void user_select_the_bank_account() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User select the bank account");
	}
	@When("User accept the Terms and Conditions")
	public void user_accept_the_terms_and_conditions() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User select the bank account");
	}
	@When("click on the submit button")
	public void click_on_the_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on the submit button");
	}
	@When("Move to the Security password page")
	public void move_to_the_security_password_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Move to the Security password page");
	}
	@When("user enters OTP {int}")
	public void user_enters_otp(Integer OTP) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user enters OTP: "+OTP);
	}
	@When("click on a submit button")
	public void click_on_a_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on a submit button");
	}
	@Then("Amount transferred status")
	public void amount_transferred_status() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Amount transferred status: "+chkStatus);
		System.out.println("Amount transferred status message: "+amtTransferMsg);
		Assert.assertTrue(amtTransferMsg, chkStatus);
	}
	
	// Logout the page
	
	// User is on logout page
	@Given("User is on logout page")
	public void User_is_on_logout_page() 
	{
	    System.out.println("User is on logout page");
	}
	
	// click on the Logout link
	@When("click on the Logout link")
	public void click_on_the_Logout_link() 
	{
		System.out.println("click on the Logout link");
	}
	
	// Should display the balance amount "INR 100"
	@Then("Should move to the Login page {string}")
	public void Should_move_to_the_Login_page(String pagetitle) 
	{
		System.out.println("Should move to the Login page");
		String actualTitle = "Login Page";
		System.out.println("actualTitle: "+actualTitle);
		System.out.println("pagetitle: "+pagetitle);
	    Assert.assertEquals(pagetitle,actualTitle);
	}
		

}
