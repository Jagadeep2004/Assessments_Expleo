package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.TestListener;
import com.utils.utilsExcel;

@Listeners(TestListener.class)
public class SignUpLoginTest extends BaseTest {

    @Test(priority =1,dataProvider = "validData", dataProviderClass = utilsExcel.class)
    public void validTest(String name, String email, String password) {

        objSignUpLogin.signUp(name, email, password,
                "Home", "Lander", "Expleo", "IM nager 2007",
                "TamilNadu", "Salem", "99998", "9099868776");

        Assert.assertEquals(
                objSignUpLogin.getSuccessMessage().trim(),
                "ACCOUNT CREATED!"
        );
    }

    @Test(priority = 2,dataProvider = "invalidData", dataProviderClass = utilsExcel.class)
    public void invalidTest(String name, String email, String password) {

        objSignUpLogin.signUp(name, email, password,
                "Home", "Lander", "Expleo", "IM nager 2007",
                "TamilNadu", "Salem", "99998", "9099868776");

        
        String actualMsg = objSignUpLogin.getSignupErrorMessage();

        Assert.assertTrue(
            actualMsg.contains("Email Address already exist!"),
            "Expected error message not displayed. Actual: " + actualMsg
        );
    }
    
    @Test(priority = 3)
    public void validLoginTest() {

       
        String email = "mmll@gmail.com";
        String password = "12345678";

        objSignUpLogin.logIn(email, password);

        String actualText = objSignUpLogin.getLoggedInUserText();

        Assert.assertTrue(
            actualText.contains("Logged in as"),
            "User not logged in. Actual: " + actualText
        );
    }
    
    @Test(priority = 4)
    public void invalidLoginTest() {

        String email = "mmlll@gmail.com";
        String password = "12345678";

        objSignUpLogin.logIn(email, password);

        String errorMsg = objSignUpLogin.getLoginErrorMessage();

        Assert.assertTrue(
            errorMsg.contains("Your email or password is incorrect!"),
            "Expected login error not displayed. Actual: " + errorMsg
        );
    }
}