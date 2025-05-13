import org.example.BaseClass;
import org.example.ConfigReader;
import org.example.PostPaidFlow;
import org.example.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

import static org.example.PostPaidFlow.driver;

public class firstSeleniumTestcase extends BaseClass {

    PostPaidFlow postPaidFlow;
    ConfigReader configReader = new ConfigReader();

    @Test(priority = 0)
    public void selectFamilyPlanAndEnterPincode() throws Exception {
        postPaidFlow = new PostPaidFlow(driver);
        postPaidFlow.clickFamilyplan();
        Thread.sleep(2000);

        String pincode = configReader.getProperty("pincode");
        System.out.println("******************" + pincode);
        postPaidFlow.enterPincode(pincode);

        WebDriverUtility util = new WebDriverUtility(driver);
        util.scrollBy(0, 500);
        Thread.sleep(3000);

        postPaidFlow.click701plan();
        Thread.sleep(3000);


    }
    @Test(priority = 0)
    public void post1() throws Exception {
        postPaidFlow = new PostPaidFlow(driver);
        postPaidFlow.clickFamilyplan();
        Thread.sleep(2000);

        String Invalid = configReader.getProperty("Invalid");
        System.out.println("******************" + Invalid); // Debugging print

        postPaidFlow.enterPincode(Invalid);
        Thread.sleep(3000);
    }

    @Test(priority = 0)
    public void post2() throws Exception {
        postPaidFlow = new PostPaidFlow(driver);
        postPaidFlow.clickFamilyplan();
        Thread.sleep(2000);

        String Nonserviceable = configReader.getProperty("Nonserviceable");
        System.out.println("******************" + Nonserviceable); // Debugging print

        postPaidFlow.enterPincode(Nonserviceable);
        Thread.sleep(3000);
    }
    @Test
    public void validateMember1ContactDetailsSection() {
    postPaidFlow = new PostPaidFlow(driver);
    postPaidFlow.validateMember1ContactDetailsSection();
  }

    @Test(priority = 1)
    public void enterMobileNumber() throws Exception {
        String mobilenumber = configReader.getProperty("mobilenumber");
        System.out.println("******************" + mobilenumber);
        postPaidFlow.entermobilenumber(mobilenumber);
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void selectExistingCustomerOption() throws Exception {
        WebDriverUtility util = new WebDriverUtility(driver);
        util.scrollBy(0, 500);
        Thread.sleep(2000);

        postPaidFlow.selectRadiobutton2();
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void fillDeliveryAddressDetails() throws Exception {
        String fullName = configReader.getProperty("fullName");
        String address = configReader.getProperty("address");
        String flatNumber = configReader.getProperty("flatNumber");

        postPaidFlow.fillDeliveryAddressForm(fullName, address, flatNumber);
        Thread.sleep(3000);
    }

}
