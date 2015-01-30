package testPackage;

import java.util.Collection;
import locators.MyAccount;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import utilities.Browsers;
import values.MyAccountValue;
import base.BaseClass;

public class InvalidInfo extends BaseClass{
	
	MyAccount 		mal = new MyAccount();
	MyAccountValue 	mav = new MyAccountValue();
	
	public InvalidInfo(Browsers browser) {
		super(browser);
	}

	@Parameters
	public static Collection<Browsers[]> data(){
		return Browsers.chooseBrowsersForExectution();
	}
	
	
	
	@Test ()
	public void invalidInfo (){
		
		driver.get(BaseURL+"/account/clubspa/index.jsp");
		typeByXpath (mal.email, mav.email);
		typeByXpath (mal.password, mav.wrongPass);
		clickByXpath (mal.submitButton);
		iWait (30);
		inLineValidation (mal.actStatusMsg, mav.expStatusMsg);
		
		System.out.println ("Invalid Info test cases ran completly");
				
	}

	
}