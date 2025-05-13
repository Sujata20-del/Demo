package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import static org.example.Chromedriver.isPincodeValid;

public class PostPaidFlow {
    public static WebDriver driver;
    //Objects

    @FindBy(id = "pincodeField")
    private WebElement PincodeField;

    @FindBy(xpath = "//a[@href='/new-connection/buy-postpaid-sim-connection-online']")
    private WebElement postpaidSimLink;

    @FindBy(xpath = "//a[text()='family plans']")
    private WebElement familyplans;

    @FindBy(xpath = "//button[contains(@class, 'btnProceed') and @data-price='701']")
    private WebElement dataprice701;

    // 1. Member 1 label
    @FindBy(xpath = "//div[@class='familymember-header active-mode position-relative']//p[@class='member-number'][normalize-space()='member 1']")
    private WebElement memberOneLabel;

    // 2. Primary member description
    @FindBy(xpath = "//div[@class='familymember-header active-mode position-relative']//div[@class='member-desc'][normalize-space()='primary member']")
    private WebElement primaryMemberDesc;

    // 3. "1. contact details" heading
    @FindBy(xpath = "//h5[normalize-space(text())='1. contact details']")
    private WebElement contactDetailsHeader;

    @FindBy(id = "enterpin")
    private WebElement pinCodeInput;

    @FindBy(id = "neoPhoneNumber")
    private WebElement mobileNumberInput;

    // Section Header - "2. select a number"
    @FindBy(xpath = "//h5[normalize-space()='2. select a number']")
    private WebElement selectNumberHeader;

    // Radio buttons
    @FindBy(xpath = "//label[@for='radio-11']")
    private WebElement radioButton1;

    @FindBy(xpath = "//label[@for='radio-12']")
    private WebElement radioButton2;

    // Section Header - "3. delivery address"
    @FindBy(xpath = "//span[@class='spanHead forDesktop']//h5[@class='mb-0'][normalize-space()='3. delivery address']")
    private WebElement deliveryAddressHeader;

    @FindBy(xpath = "//p[@class='details lastdetails']")
    private WebElement deliveryAddressDetails;

    // Delivery address fields
    @FindBy(id = "enterFullname")
    private WebElement fullNameInput;

    @FindBy(id = "gmapAddressField")
    private WebElement addressInput;

    @FindBy(id = "enterFlatNumber")
    private WebElement flatNumberInput;

    //constructor
    public PostPaidFlow(WebDriver driver) {
        PostPaidFlow.driver = driver;
        PageFactory.initElements(driver, this);
//        prop = new Properties();
//        fLib = new FileUtility();
    }

    //Actions//Method/POM
    public void clickFamilyplan() {
        familyplans.click();
        Assert.assertTrue(familyplans.isSelected(),"Family plan is not selected");
        System.out.println("Clicked on 'family plans' link.");
    }

    public void enterPincode(String pincode) throws InterruptedException {
        //pincodeField.clear();
        PincodeField.sendKeys(pincode);
        Thread.sleep(3000);
      //  PincodeField.clear();

    }

    public void ServiceablePincode(String pincode) {
        if (isPincodeValid(pincode)) {
            System.out.println("Plans should appear.");
        } else {
            System.out.println("Sorry, this pinCode is not serviceable.");

        }
    }

    public void Invalidpincode(String pincode) {
        if (!isPincodeValid(pincode)) {
            System.out.println("This pincode is not valid");
        }
    }

    public void click701plan() {
        dataprice701.click();
        System.out.println("Clicked on 'Proceed with 701 plan' link.");
    }

    public void validateMember1ContactDetailsSection() {
    Assert.assertTrue(memberOneLabel.isDisplayed(), "❌ Member 1 label is NOT displayed.");
    System.out.println("✅ Member 1 label is displayed.");

    Assert.assertTrue(primaryMemberDesc.isDisplayed(), "❌ Primary member label is NOT displayed.");
    System.out.println("✅ Primary member label is displayed.");

    Assert.assertTrue(contactDetailsHeader.isDisplayed(), "❌ 'Contact details' header is NOT displayed.");
    System.out.println("✅ 'Contact details' header is displayed.");
}

    public void entermobilenumber (String mobilenumber ){
//        mobileNumberInput.click();
//        mobileNumberInput.clear();
        mobileNumberInput.sendKeys(mobilenumber);

    }
    public void SelectANumberHeader() {
        Assert.assertTrue(selectNumberHeader.isDisplayed(), "Select a number is not displayed");
        System.out.println("Select a number is displayed");
    }
    public void selectRadiobutton () {
        // Check if 'Get number' is displayed
//        Assert.assertTrue(Getnumber.isdisplayed()," Get number of my choice is not displayed");
        System.out.println("Get number of my choice is displayed");
        // Click on radio button 1
        radioButton1.click();
        System.out.println("radio button 1 is selected");

    }
    public void selectRadiobutton2 () {
        radioButton2.click();
        System.out.println("radio button 1 is selected");
    }

    public void deliveryAddressHeader() {
        Assert.assertTrue(deliveryAddressDetails.isDisplayed(),"Delivery Address is not displayed");
        System.out.println("Delivery Address is displayed");
    }
    public void fillDeliveryAddressForm(String fullName, String address, String flatNumber ){

        fullNameInput.click();
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        flatNumberInput.click();
        flatNumberInput.clear();
        flatNumberInput.sendKeys(flatNumber);

        System.out.println("Delivery address form filled successfully.");
    }


}












